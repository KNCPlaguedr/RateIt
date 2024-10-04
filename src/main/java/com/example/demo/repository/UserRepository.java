/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Analise;
import com.example.demo.model.Filme;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author wesle
 */
@Service
public class UserRepository {

    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private AnaliseRepository analiseRepository;

    
   @Transactional
public void deleteAnalises(List<Long> ids) {
    ids.forEach(id -> analiseRepository.deleteById(id));
}
}
