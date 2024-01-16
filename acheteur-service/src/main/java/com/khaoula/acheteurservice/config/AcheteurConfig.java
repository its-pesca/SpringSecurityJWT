package com.khaoula.acheteurservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "acheteur.params")
@Setter @Getter
public class AcheteurConfig {
    int x;
    int y;
}
