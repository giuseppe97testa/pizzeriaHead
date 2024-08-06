package com.example.pizzeriahead.controller;


import com.example.pizzeriahead.model.Pizzaiolo;
import com.example.pizzeriahead.service.PizzaioloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzeriahead/pizzaioli")

public class PizzaioloController {
    @Autowired
    private PizzaioloService pizzaioloService;

    @GetMapping
    public Iterable<Pizzaiolo> getAllPizzaioli() {
        return pizzaioloService.getAllPizzaiolo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizzaiolo> getPizzaioloById(@PathVariable Long id) {
        return pizzaioloService.getPizzaiolobyId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/numeropizze/{id}")
    public ResponseEntity<Long> countPizzeByPizzaiolo(@PathVariable Long id) {
        long count = pizzaioloService.conteggioPizzePizzaiolo(id);
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizzaiolo> updatePizzaiolo(@PathVariable Long id, @RequestBody Pizzaiolo pizzaioloDetails) {
        Pizzaiolo updatedPizzaiolo = pizzaioloService.updatePizzaiolo(id, pizzaioloDetails);
        if (updatedPizzaiolo != null) {
            return ResponseEntity.ok(updatedPizzaiolo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Pizzaiolo createPizzaiolo(@RequestBody Pizzaiolo pizzaiolo) {
        return pizzaioloService.savePizzaiolo(pizzaiolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizzaiolo(@PathVariable Long id) {
        pizzaioloService.deletePizzaiolo(id);
        return ResponseEntity.noContent().build();
    }



}
