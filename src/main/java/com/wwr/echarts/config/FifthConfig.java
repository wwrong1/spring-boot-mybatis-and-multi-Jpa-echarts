//package com.wwr.echarts.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactoryFifth",
//        transactionManagerRef="transactionManagerFifth"
//        /**basePackages= { "com.wwr.repository.test2" }**/)
//public class FifthConfig {
//
//    @Autowired
//    @Qualifier("fifthDataSource")
//    private DataSource fifthDataSource;
//
//    @Autowired
//    @Qualifier("vendorProperties")
//    private Map<String, Object> vendorProperties;
//
//    @Bean(name = "entityManagerFactoryFifth")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFifth (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(fifthDataSource)
//                .properties(vendorProperties)
//                .packages("com.wwr.echarts.model")
//                .persistenceUnit("fifthPersistenceUnit")
//                .build();
//    }
//
//    @Bean(name = "entityManagerFifth")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryFifth(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "transactionManagerFifth")
//    PlatformTransactionManager transactionManagerFifth(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryFifth(builder).getObject());
//    }
//
//}