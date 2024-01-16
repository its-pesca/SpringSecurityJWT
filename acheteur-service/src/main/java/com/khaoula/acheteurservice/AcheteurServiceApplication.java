package com.khaoula.acheteurservice;

import com.khaoula.acheteurservice.config.AcheteurConfig;
import com.khaoula.acheteurservice.config.GlobalConfig;
import com.khaoula.acheteurservice.entities.Acheteur;
import com.khaoula.acheteurservice.repositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class , AcheteurConfig.class})
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }

@Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {
            acheteurRepository.save(Acheteur.builder()
                    .nom("Ali Mohammed")
                    .ville("Rabat")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Khaoula Jadimoussa")
                    .ville("Rabat")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Salem salem")
                    .ville("Sale")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Aya aya")
                    .ville("Tanger")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Jack Pattinson")
                    .ville("London")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Ahmad Khan")
                    .ville("Delhi")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Michel Duchamps")
                    .ville("Nice")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Julia Robert")
                    .ville("Munich")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Djamel ALI")
                    .ville("Tunis")
                    .build());

            acheteurRepository.save(Acheteur.builder()
                    .nom("Luisa Clarck")
                    .ville("Whales")
                    .build());

            List<Acheteur> liste = acheteurRepository.findAll();

            for (Acheteur a:liste){
                System.out.println("*************************");
                System.out.println(a.getNom());
                System.out.println(a.getVille());
            }

        };
}

}
