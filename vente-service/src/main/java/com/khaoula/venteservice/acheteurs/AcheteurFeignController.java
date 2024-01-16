package com.khaoula.venteservice.acheteurs;

import com.khaoula.venteservice.JwtConfig.OpenFeignConfig;
import com.khaoula.venteservice.Modele.Acheteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACHETEUR-SERVICE",configuration = OpenFeignConfig.class)
public interface AcheteurFeignController {

    @GetMapping("/acheteurs")
    public List<Acheteur> findAll();

    @GetMapping("/acheteurs/{id}")
    public Acheteur findBy(@PathVariable Long id);
}
