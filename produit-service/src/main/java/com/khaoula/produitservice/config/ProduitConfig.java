package com.khaoula.produitservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "produit.params")
@Getter @Setter
public class ProduitConfig {
    int a;
    int b;
}
