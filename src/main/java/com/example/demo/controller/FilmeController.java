package com.example.demo.controller;

import com.example.demo.model.Analise;
import com.example.demo.model.Filme;
import com.example.demo.repository.AnaliseRepository;
import com.example.demo.repository.FilmeRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AnaliseRepository analiseRepository;
    
    @Autowired
    private UserRepository userRepository;

    
  
    @GetMapping
    public String listarFilmes(Model model) {
        List<Filme> filmes = filmeRepository.findAll();
        model.addAttribute("filmes", filmes);
        return "listar";
    }

     @GetMapping("/cadastrar")
    public String cadastrarFilme(Model model) {
    model.addAttribute("filme", new Filme());
    return "cadastrar";
    }
    
    @PostMapping("/cadastrar")
    public String salvarFilme(@ModelAttribute Filme filme) {
    filmeRepository.save(filme);
    return "redirect:/filmes";
    }
    


    @GetMapping("/{id}")
    public String detalhesFilme(@PathVariable Long id, Model model) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        List<Analise> analises = analiseRepository.findByFilmeId(id); 
        model.addAttribute("filme", filme);
        model.addAttribute("analises", analises);
        model.addAttribute("analise", new Analise());
        return "detalhes";
    }
    
    @GetMapping("/{id}/update")
    public String updateFilme (@PathVariable Long id, Model model){
        Filme filme = filmeRepository.findById(id).orElseThrow();
        model.addAttribute("filme", filme);
        return "update";
    }
    
    @PostMapping("/{id}/update")
    public String salvarUpdate(@ModelAttribute Filme filme) {
    filmeRepository.save(filme);
    return "redirect:/filmes";
    }

   @PostMapping("/{id}/analise")
public String adicionarAnalise(@PathVariable Long id, @RequestParam String analise, @RequestParam int nota) {
    Filme filme = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado")); 
    Analise novaAnalise = new Analise();
    novaAnalise.setFilme(filme);
    novaAnalise.setAnalise(analise);
    novaAnalise.setNota(nota); 
    analiseRepository.save(novaAnalise);
    return "redirect:/filmes/" + id;
}

@PostMapping("/{id}/deletar")
public String excluirFilme(@PathVariable Long id) {
    Filme filme = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    analiseRepository.deleteByFilmeId(id);
    filmeRepository.delete(filme);
    return "redirect:/filmes";
}

@PostMapping("/{id}/delete")
public String excluirAnalise(@PathVariable Long id, Model model) {
    Analise analise = analiseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Análise não encontrada"));
    analiseRepository.delete(analise);
    return "redirect:/filmes";
}


}
