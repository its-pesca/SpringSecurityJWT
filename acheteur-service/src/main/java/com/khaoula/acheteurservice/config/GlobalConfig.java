package com.khaoula.acheteurservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Data @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {

    int p1;

    int p2;
}
