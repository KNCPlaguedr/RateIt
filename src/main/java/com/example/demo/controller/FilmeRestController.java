/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Filme;
import com.example.demo.repository.AnaliseRepository;
import com.example.demo.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wesle
 */
@RestController
@RequestMapping("/api/filmes")
public class FilmeRestController {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AnaliseRepository analiseRepository;

//Create
    @PostMapping("/cadastrar")
    public ResponseEntity<Filme> salvarFilme(@RequestBody Filme filme) {
        try {
            Filme savedFilme = filmeRepository.save(filme);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFilme);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//Read
    @GetMapping("/listar")
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

//Update
    @PostMapping("/{id}/update")
    public ResponseEntity<Filme> salvarUpdate(@PathVariable Long id, @RequestBody Filme filme) {
        filme.setId(id);
        Filme filmeAtualizado = filmeRepository.save(filme);
        return ResponseEntity.ok(filmeAtualizado);
    }

    //Delete
    @PostMapping("/{id}/deletar")
    public ResponseEntity<Void> excluirFilme(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        analiseRepository.deleteByFilmeId(id);
        filmeRepository.delete(filme);
        return ResponseEntity.noContent().build();
    }

}
