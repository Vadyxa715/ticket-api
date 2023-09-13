package com.example.testparttwo.servise;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto userDto);

    UserDto getUser (Long userId);

    List<UserDto> findAll ();

    List<TicketDto> getAllPaidTicketsByUserId(Long userId, TicketDto ticketDto);

}
