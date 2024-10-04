
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import com.example.demo.model.Filme;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author wesle
 */
@Entity
public class Analise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
    private String analise;
    private int nota;

    
    public Analise() {
        
    }

    public Analise(Long id, Filme filme, String analise, int nota) {
        this.id = id;
        this.filme = filme;
        this.analise = analise;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
