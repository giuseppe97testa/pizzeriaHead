package com.example.pizzeriahead.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="PIZZAIOLO")
public class Pizzaiolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private Integer eta;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pizzaiolo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Pizza> pizze;

    //Costruttore
    public Pizzaiolo() {
    }

    public Pizzaiolo(Long id, String nome, String cognome, Integer eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    //Get e Set Method

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Set<Pizza> getPizze() {
        return pizze;
    }

    public void setPizze(Set<Pizza> pizze) {
        this.pizze = pizze;
    }
}
