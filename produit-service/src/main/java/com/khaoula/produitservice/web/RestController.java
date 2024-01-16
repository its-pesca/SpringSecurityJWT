package com.khaoula.produitservice.web;

import com.khaoula.produitservice.config.GlobalConfig;
import com.khaoula.produitservice.config.ProduitConfig;
import com.khaoula.produitservice.entities.Produit;
import com.khaoula.produitservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/produitConfig")
    public ProduitConfig produitConfig(){ return produitConfig;}

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getById(@PathVariable("id") Integer id){
        return produitRepository.findById(id).get();
    }

    @PutMapping("/produits/{id}")
    public void save(@PathVariable("id") Integer id, @RequestBody Produit p){
        Produit pr = produitRepository.findById(id).get();

        if (p.getMarque()!=null){pr.setMarque(p.getMarque());}
        if (p.getDesc()!=null){pr.setDesc(p.getDesc());}
        if (p.getPrix()!=null){pr.setPrix(p.getPrix());}
        if (p.getQuantite()!=null){pr.setQuantite(p.getQuantite());}

        produitRepository.save(pr);
    }

    @PostMapping("/produits")
    public void add(@RequestBody Produit p){
        produitRepository.save(p);
    }

    @DeleteMapping("/produits/{id}")
    public void supprime(@PathVariable("id") Integer id){
        produitRepository.deleteById(id);
    }
}
