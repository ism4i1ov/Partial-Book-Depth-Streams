package com.example.partialbookdepthstreams.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.hostname}")
    private String hostname;
    @Value("${dataSource.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(hostname)
                .driverClassName(driverClassName)
                .build();
    }

    public String getUsername() {
        return username;
    }

    public DataSourceConfiguration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataSourceConfiguration setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHostname() {
        return hostname;
    }

    public DataSourceConfiguration setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public DataSourceConfiguration setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }
}
