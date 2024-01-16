package com.khaoula.venteservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vente.params")
@Getter @Setter
public class VenteConfig {
    int z;
    int t;
}
