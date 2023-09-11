package com.example.testparttwo.gfg;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigDataSource {
    @Bean
    public static DataSource source(){
        DataSourceBuilder<?> dataSourceBuilder
                =DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");

        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/ticketapi");

        dataSourceBuilder.username("postgres");

        dataSourceBuilder.password("postgres");

        return dataSourceBuilder.build();
    }
}
