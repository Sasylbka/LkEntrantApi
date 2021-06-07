package ru.esstu.entrant.lk;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "ru.esstu")
public class PersistenceConfig {
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "aicstoragesDataSource")
    @ConfigurationProperties("spring.aicstoragesdatasource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}
