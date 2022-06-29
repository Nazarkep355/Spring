package com.example.springfinalproject.Repository;

import com.example.springfinalproject.Entity.Route;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface RouteRepository extends CrudRepository<Route,Long> {
    Optional<Route> getRouteById(Long id);
    List<Route> findAll(Pageable pageable);
    List<Route> findFirstByOrderByIdDesc();
}
