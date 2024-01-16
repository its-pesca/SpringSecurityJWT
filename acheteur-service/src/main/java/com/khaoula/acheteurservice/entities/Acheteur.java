package com.khaoula.acheteurservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Acheteur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idA;
    private String nom;
    private String ville;

}
