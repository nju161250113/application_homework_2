package com.example.homework_2.configure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlTransactionManager", basePackages = {
        "com.example.homework_2.mysql.repository"})
public class MySqlDataSourceConfig {

    @Autowired
    private HibernateProperties hibernateProperties;
    @Resource
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;


    @Resource
    private JpaProperties jpaProperties;
    @Primary
    @Bean(name = "entityManagermysql")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return mysqlEntityManagerFactory(builder).getObject().createEntityManager();
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String,Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());
        return builder.dataSource(mysqlDataSource)
                .packages("com.example.homework_2.mysql.entity")
                .persistenceUnit("mysqlPersistenceUnit")
                .properties(properties)
                .build();
    }

    //private Map<String, Object> getProperties() {
    //     return jpaProperties.getHibernateProperties(new HibernateSettings());
    // }
    //private Map<String, Object> getVendorProperties() {
   //     return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),new HibernateSettings());
   // }
    @Primary
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(mysqlEntityManagerFactory(builder).getObject());
    }
}