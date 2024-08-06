package com.example.pizzeriahead.service;

import com.example.pizzeriahead.model.Pizzaiolo;
import com.example.pizzeriahead.repository.PizzaioloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaioloService {
    @Autowired
    private PizzaioloRepository pizzaioloRepository;

    public Iterable<Pizzaiolo> getAllPizzaiolo() {
        return pizzaioloRepository.findAll();
    }

    public Optional<Pizzaiolo> getPizzaiolobyId (Long id) {
        return pizzaioloRepository.findById(id);
    }

    public Pizzaiolo savePizzaiolo (Pizzaiolo pizzaiolo) {
        return pizzaioloRepository.save(pizzaiolo);
    }

    public void deletePizzaiolo (Long id) {
        pizzaioloRepository.deleteById(id);
    }

    public Pizzaiolo updatePizzaiolo(Long id, Pizzaiolo pizzaioloInfo) {
        Optional<Pizzaiolo> existingPizzaiolo = pizzaioloRepository.findById(id);
        if (existingPizzaiolo.isPresent()) {
            Pizzaiolo pizzaiolo = existingPizzaiolo.get();
            pizzaiolo.setNome(pizzaioloInfo.getNome());
            pizzaiolo.setCognome(pizzaioloInfo.getCognome());
            pizzaiolo.setEta(pizzaioloInfo.getEta());
            return pizzaioloRepository.save(pizzaiolo);
        } else {
            return null;
        }
    }

    public long conteggioPizzePizzaiolo(long id) {
        Pizzaiolo pizzaiolo = pizzaioloRepository.findById(id).orElse(null);
        if (pizzaiolo!= null) {
            return pizzaiolo.getPizze().size();
        }
        return 0;
    }

}
