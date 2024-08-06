package com.example.pizzeriahead.controller;

import com.example.pizzeriahead.model.Pizza;
import com.example.pizzeriahead.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/pizzeriahead/pizza")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public Iterable<Pizza> getallPizze() {
        return pizzaService.getAllPizze();
    }

    @PostMapping
    public Pizza createPizzaOrder(@RequestBody Pizza pizza) {
        return pizzaService.savePizza(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza pizzaInfo) {
        Pizza updatedPizza = pizzaService.updatePizza(id, pizzaInfo);
        if (updatedPizza != null) {
            return ResponseEntity.ok(updatedPizza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }


}
