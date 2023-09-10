package com.example.testparttwo.repo;

import com.example.testparttwo.dto.TicketDto;
import com.example.testparttwo.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query(value = "select t.* from tickets t join tickets_users tu on tu.ticket_id = t.id" +
            " where tu.user_id = ?1", nativeQuery = true)
    List<Ticket> findByUserId(Long userId);
}
