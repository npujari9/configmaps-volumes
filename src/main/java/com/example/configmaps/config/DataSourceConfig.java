package com.example.configmaps.config;

import com.example.configmaps.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
       return DataSourceBuilder.create()
               .type(HikariDataSource.class)
               .url(dataSourceProperties.getJdbcUrl())
               .username(dataSourceProperties.getUserName())
               .password(dataSourceProperties.getPassword())
               .driverClassName(dataSourceProperties.getDriverClassName())
               .build();
    }

    @Bean(name = "departmentJdbcTemplate")
    public NamedParameterJdbcTemplate departmentJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
