package com.example.testparttwo.controller;

import com.example.testparttwo.entity.ERole;
import com.example.testparttwo.entity.Role;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.payload.request.LoginRequest;
import com.example.testparttwo.payload.request.SignupRequest;
import com.example.testparttwo.payload.response.JwtResponse;
import com.example.testparttwo.payload.response.MessageResponse;
import com.example.testparttwo.repo.RoleRepo;
import com.example.testparttwo.repo.UserRepo;
import com.example.testparttwo.security.jwt.JwtUtils;
import com.example.testparttwo.security.services.UserDetailsImpl;
import com.example.testparttwo.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(value = "/auth", produces = "application/json; charset=utf-8")
public class AuthController {

    @Autowired
    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Operation(summary = "войти логин/пароль")
    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).findFirst().orElse("ROLE_USER");

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                role));
    }

    @Operation(summary = "регистрация пользователя")
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getLogin(),
                encoder.encode(signUpRequest.getPassword()));

        String strRoles = signUpRequest.getRole();
        Role role = new Role();

        if (strRoles == null) {
            role = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else {

            switch (strRoles) {
                case "admin":
                    role = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                case "moder":
                    role = roleRepository.findByName(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    break;
                default:
                    role = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            }
        }

        user.setRole(role);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
