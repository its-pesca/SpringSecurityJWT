package com.khaoula.venteservice.web;

import com.khaoula.venteservice.Modele.Acheteur;
import com.khaoula.venteservice.Modele.Produit;
import com.khaoula.venteservice.acheteurs.AcheteurFeignController;
import com.khaoula.venteservice.config.GlobalConfig;
import com.khaoula.venteservice.config.VenteConfig;
import com.khaoula.venteservice.entities.Vente;
import com.khaoula.venteservice.produits.ProduitFeignController;
import com.khaoula.venteservice.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    VenteRepository venteRepository;

    @Autowired
    private ProduitFeignController produitFeignController;

    @Autowired
    private AcheteurFeignController acheteurFeignController;

    @Autowired
    GlobalConfig globalConfig;

    @Autowired
    VenteConfig venteConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){ return globalConfig;}

    @GetMapping("/venteConfig")
    public  VenteConfig venteConfig(){ return venteConfig;}

    @GetMapping("/ventes")
    public List<Vente> getAll(){
        List<Vente> lv = venteRepository.findAll();

        List<Produit> lp = produitFeignController.findAll();

        List<Acheteur> la = acheteurFeignController.findAll();

        for (Vente v:lv){
            for (Produit p:lp){
                if (v.getIdP() == p.getIdP()){
                    v.setProduit(p); break;
                }
            }
        }

        for (Vente v:lv){
            for (Acheteur a:la){
                if (v.getIdA() == a.getIdA()){
                    v.setAcheteur(a); break;
                }
            }
        }

        return lv;
    }

    @GetMapping("/ventes/{id}")
    public Vente getById(@PathVariable Long id){
        Vente v = venteRepository.findById(id).get();

        Acheteur a = acheteurFeignController.findBy(v.getIdA());
        v.setAcheteur(a);

        Produit p = produitFeignController.findBy(v.getIdP());
        v.setProduit(p);

        return v;
    }




}
