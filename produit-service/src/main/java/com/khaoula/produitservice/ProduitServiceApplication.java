package com.khaoula.produitservice;

import com.khaoula.produitservice.config.GlobalConfig;
import com.khaoula.produitservice.config.ProduitConfig;
import com.khaoula.produitservice.entities.Produit;
import com.khaoula.produitservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class , ProduitConfig.class})
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

@Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            produitRepository.save(Produit.builder()
                    .marque("HP")
                    .desc("pc portable")
                    .prix((float)6550.90)
                    .quantite(100)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("iPhone")
                    .desc("Telephone")
                    .prix((float)5450)
                    .quantite(50)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("Samsung")
                    .desc("Tablette")
                    .prix((float)12550.90)
                    .quantite(20)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("HUAWEI")
                    .desc("pc portable")
                    .prix((float)7050.50)
                    .quantite(60)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("ASUS")
                    .desc("pc portable")
                    .prix((float)9500)
                    .quantite(15)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("HUAWEI")
                    .desc("Telephone")
                    .prix((float)3000.90)
                    .quantite(40)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("MacBook")
                    .desc("pc portable")
                    .prix((float)106700.99)
                    .quantite(30)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("Apple")
                    .desc("Smart Watch")
                    .prix((float)2000)
                    .quantite(70)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("Samsung")
                    .desc("Telephone Z Flip 5")
                    .prix((float)12050.90)
                    .quantite(25)
                    .build());

            produitRepository.save(Produit.builder()
                    .marque("Samsung")
                    .desc("pc portable")
                    .prix((float)9000)
                    .quantite(7)
                    .build());


            //Affichage de la base de donnees
            List<Produit> liste = produitRepository.findAll();

            for (Produit p:liste){
                System.out.println("*************************");
                System.out.println(p.getMarque());
                System.out.println(p.getDesc());
                System.out.println(p.getPrix());
                System.out.println(p.getQuantite());
            }
        };
}

}
