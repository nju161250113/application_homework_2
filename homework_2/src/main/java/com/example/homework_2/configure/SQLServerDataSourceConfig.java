package com.example.homework_2.configure;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SQLServerDataSourceConfig {
    @Bean(name = "sqlserverTemplate")
    public JdbcTemplate sqlserverJdbcTemplate(
            @Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
