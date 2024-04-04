package com.example.configmaps.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "h2.database")
@Data
public class DataSourceProperties {
    private String jdbcUrl;
    private String userName;
    private String password;
    private String driverClassName;
}
