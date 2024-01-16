package com.khaoula.venteservice.produits;

import com.khaoula.venteservice.Modele.Produit;
import com.khaoula.venteservice.JwtConfig.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUIT-SERVICE",configuration = OpenFeignConfig.class)
public interface ProduitFeignController {
    @GetMapping("/produits")
    public List<Produit> findAll();

    @GetMapping("/produits/{id}")
    public Produit findBy(@PathVariable Long id);
}
