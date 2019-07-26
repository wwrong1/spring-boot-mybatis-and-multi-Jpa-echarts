package com.wwr.echarts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryThird",
        transactionManagerRef="transactionManagerThird"
        )
public class ThirdConfig {

    @Autowired
    @Qualifier("thirdDataSource")
    private DataSource thirdDataSource;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactoryThird")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryThird (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(thirdDataSource)
                .properties(vendorProperties)
                .packages("com.wwr.echarts.model")
                .persistenceUnit("thirdPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerThird")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryThird(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerThird")
    PlatformTransactionManager transactionManagerThird(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryThird(builder).getObject());
    }

}