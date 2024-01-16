package com.khaoula.acheteurservice.web;


import com.khaoula.acheteurservice.config.AcheteurConfig;
import com.khaoula.acheteurservice.config.GlobalConfig;
import com.khaoula.acheteurservice.entities.Acheteur;
import com.khaoula.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    AcheteurRepository acheteurRepository;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    AcheteurConfig acheteurConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

    @GetMapping("/acheteurConfig")
    public AcheteurConfig acheteurConfig(){ return acheteurConfig;}

    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        List<Acheteur> la = acheteurRepository.findAll();
        return la;
    }

    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable ("id") Integer id){
        Acheteur e = acheteurRepository.findById(id).get();
        return e;
    }

    /*@PutMapping("/acheteurs/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Acheteur a){
        Acheteur ar = acheteurRepository.findById(id).get();

        if(a.getNom()!=null) {ar.setNom(a.getNom());}
        if(a.getVille()!=null){ar.setVille(a.getVille());}

        acheteurRepository.save(ar);
    }

    @PostMapping("/acheteurs")
    public void add(@RequestBody Acheteur a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/acheteurs/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }*/

}
