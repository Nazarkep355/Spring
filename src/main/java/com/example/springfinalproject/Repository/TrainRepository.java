package com.example.springfinalproject.Repository;


import com.example.springfinalproject.Entity.Train;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Repository
@Transactional
public interface TrainRepository extends CrudRepository<Train,Long> {
    List<Train> findTrainById(Long id);
    List<Train> findAllByEnableOrderById(Boolean enable,Pageable pageable);
    List<Train> findFirstByOrderByIdDesc();

    List<Train> findTrainsByEnableOrderById(Boolean enable);

    @Query("select t from Train t where ?1 member t.stations order by t.id DESC")
    List<Train> findTrainsByStationsContainingOrderByIdDesc(String station, Pageable pageable);

}
