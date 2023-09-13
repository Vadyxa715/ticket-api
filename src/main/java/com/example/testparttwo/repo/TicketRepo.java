package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo {

    Page<Ticket> findAll(Pageable myPageable);
    //свой класс pagable с нужным полями (можно не все) - упростить

    //* Добавление методов просто в интерфейс из примера в ручную
    // сам пример:
    //     bezkoder.com/spring-boot-jdbctemplate-postgresql-example/    *//
    int save(Ticket ticket);

    int saveByUserIdAndTrailId(Ticket ticket);
    int update(Ticket ticket);
    Ticket findById(Long id);
    int deleteById(Long id);
    List<Ticket> findAll();
    List<Ticket> findByPaid(boolean paid);
    List<Ticket> findByTransporter(String transporter);
    int deleteAll();

    Ticket saveByUserIdAndTrailId(Ticket ticket);
}
