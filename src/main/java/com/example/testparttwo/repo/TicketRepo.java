package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo {//extends PagingAndSortingRepository<Ticket, Long> {

    Page<Ticket> findAll(Pageable myPageable);

    int save(Ticket ticket);

    int bayTicket(Long ticketId, Long userId);

    Ticket findById(Long id);

    List<Ticket> findPaidByUser(Long id);

}
