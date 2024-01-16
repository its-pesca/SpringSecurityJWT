package com.khaoula.produitservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Produit {
@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idP;
    private String marque;
    private String desc;
    private Float prix;
    private Integer quantite;
}
