package com.khaoula.venteservice.Modele;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Acheteur {

    private Long idA;
    private String nom;
    private String ville;
}
