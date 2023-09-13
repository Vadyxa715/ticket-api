package com.example.testparttwo.servise.impl;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.dto.UserDto;
import com.example.testparttwo.entity.User;
import com.example.testparttwo.mapper.UserMapper;
import com.example.testparttwo.repo.TicketRepo;
import com.example.testparttwo.repo.UserRepo;
import com.example.testparttwo.servise.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private TicketRepo ticketrepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.revert(userDto);
        int saveUser = userRepo.save(user);
        User inserted = userRepo.findById(Long.valueOf(saveUser));
        return UserMapper.convert(inserted);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepo.findById(userId);
        return UserMapper.convert(user);
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public List<TicketDto> getAllPaidTicketsByUserId(Long userId, TicketDto ticketDto) {
        return null;
    }

//    @Override
//    public List<TicketDto> getAllPaidTicketsByUserId(Long userId, TicketDto ticketDto) {
//        return ticketrepo.findByUserId(userId)
//                .stream().map(TicketMapper::convert)
//                .filter(n -> n.getPaid())
//                .collect(Collectors.toList());
//    }
}
