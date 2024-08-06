package com.example.pizzeriahead.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="PIZZA")
public class Pizza {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String aggiunta;
    private String rimozione;
    private float prezzo;

    @ManyToOne
    @JoinColumn(name = "pizzaiolo_id")
    @JsonBackReference
    private Pizzaiolo pizzaiolo;

    //Costruttore
    public Pizza() {

    }

    public Pizza(Long id, String nome, String aggiunta, String rimozione, Float prezzo) {
        this.id = id;
        this.nome = nome;
        this.aggiunta = aggiunta;
        this.rimozione = rimozione;
        this.prezzo = prezzo;
    }


    //Metodi get e set

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
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

    public String getAggiunta() {
        return aggiunta;
    }

    public void setAggiunta(String aggiunta) {
        this.aggiunta = aggiunta;
    }

    public String getRimozione() {
        return rimozione;
    }

    public void setRimozione(String rimozione) {
        this.rimozione = rimozione;
    }

    public Pizzaiolo getPizzaiolo() {
        return pizzaiolo;
    }

    public void setPizzaiolo(Pizzaiolo pizzaiolo) {
        this.pizzaiolo = pizzaiolo;
    }
}
