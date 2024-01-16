package com.khaoula.produitservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Data @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {

    int p1;

    int p2;
}
