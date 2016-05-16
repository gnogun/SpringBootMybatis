package com.gno.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.gno")
@MapperScan(value = {"com.gno.mapper"})
public class GnoApplication {
	public static void main(String[] args) {
        SpringApplication.run(GnoApplication.class, args);
    }
}
