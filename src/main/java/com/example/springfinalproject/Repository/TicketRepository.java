package com.example.springfinalproject.Repository;


import com.example.springfinalproject.Entity.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface TicketRepository extends CrudRepository<Ticket,Long> {
    List<Ticket> getTicketByOwnerAndEnableOrderByIdDesc(Long owner,boolean enable, Pageable pageable);
    List<Ticket> getTicketsByTrainAndEnable(Long train,boolean enable);
}
