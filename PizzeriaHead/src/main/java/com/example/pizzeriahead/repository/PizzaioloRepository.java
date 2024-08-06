package com.example.pizzeriahead.repository;

import com.example.pizzeriahead.model.Pizzaiolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaioloRepository extends JpaRepository<Pizzaiolo, Long> {

}
