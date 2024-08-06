package com.example.pizzeriahead.service;

import com.example.pizzeriahead.model.Pizza;
import com.example.pizzeriahead.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Iterable<Pizza> getAllPizze() {
        return pizzaRepository.findAll();
    }
    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void deletePizza (Long id) {
        pizzaRepository.deleteById(id);
    }

    public Pizza updatePizza(Long id, Pizza pizzaInfo) {
        Optional<Pizza> existingPizza = pizzaRepository.findById(id);
        if (existingPizza.isPresent()) {
            Pizza pizza = existingPizza.get();
            pizza.setNome(pizzaInfo.getNome());
            pizza.setAggiunta(pizzaInfo.getAggiunta());
            pizza.setRimozione(pizzaInfo.getRimozione());
            pizza.setPrezzo(pizzaInfo.getPrezzo());
            return pizzaRepository.save(pizza);
        } else {
            return null;
        }
    }
}
