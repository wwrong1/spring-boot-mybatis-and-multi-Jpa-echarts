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
//        entityManagerFactoryRef="entityManagerFactoryFourth",
//        transactionManagerRef="transactionManagerFourth"
//        /**basePackages= { "com.wwr.repository.test2" }**/)
//public class FourthConfig {
//
//    @Autowired
//    @Qualifier("fourthDataSource")
//    private DataSource fourthDataSource;
//
//    @Autowired
//    @Qualifier("vendorProperties")
//    private Map<String, Object> vendorProperties;
//
//    @Bean(name = "entityManagerFactoryFourth")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFourth(EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(fourthDataSource)
//                .properties(vendorProperties)
//                .packages("com.wwr.echarts.model")
//                .persistenceUnit("FourthPersistenceUnit")
//                .build();
//    }
//
//    @Bean(name = "entityManagerFourth")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryFourth(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "transactionManagerFourth")
//    PlatformTransactionManager transactionManagerFourth(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryFourth(builder).getObject());
//    }
//
//}