package com.wwr.echarts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.wwr.echarts.mapper")
public class MultiJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiJpaApplication.class, args);
	}
}
