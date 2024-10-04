
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Analise;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wesle
 */
@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {
    List<Analise> findByFilmeId(Long filmeId);
   
    
    @Transactional
    void deleteByFilmeId(Long filmeId);
    
 

    
}
