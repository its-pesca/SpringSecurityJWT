package com.khaoula.venteservice;

import com.khaoula.venteservice.config.GlobalConfig;
import com.khaoula.venteservice.config.VenteConfig;
import com.khaoula.venteservice.entities.Vente;
import com.khaoula.venteservice.repositories.VenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({GlobalConfig.class , VenteConfig.class})
public class VenteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenteServiceApplication.class, args);
    }

@Bean
    CommandLineRunner start(VenteRepository venteRepository){
        return args -> {
            venteRepository.save(Vente.builder()
                    .idVente(1L)
                    .idA(1L)
                    .idP(1L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(2L)
                    .idA(2L)
                    .idP(2L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(3L)
                    .idA(3L)
                    .idP(3L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(4L)
                    .idA(4L)
                    .idP(4L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(5L)
                    .idA(5L)
                    .idP(5L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(6L)
                    .idA(6L)
                    .idP(6L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(7L)
                    .idA(7L)
                    .idP(7L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(8L)
                    .idA(8L)
                    .idP(8L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(9L)
                    .idA(9L)
                    .idP(9L)
                    .build());

            venteRepository.save(Vente.builder()
                    .idVente(10L)
                    .idA(10L)
                    .idP(10L)
                    .build());
        };
}
}
