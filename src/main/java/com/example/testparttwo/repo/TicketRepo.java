package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Ticket;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> {
//    @Query(value = "select t.* from tickets t join tickets_users tu on tu.ticket_id = t.id" +
//            " where tu.user_id = ?1", nativeQuery = true)
//    List<Ticket> findByUserId(Long userId);

    @NonNull Optional<Ticket> findById (Long id);
    @NonNull Optional<Ticket> findByUserId (Long id);
}
