package com.gno.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = { "com.gno.mapper" })
public class GnoConfig {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/faas;create=true");
        dataSource.setUsername("app");
        dataSource.setPassword("1234");        
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				dataSource());
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setTypeAliasesPackage("com.gno.mapper");
		return sessionFactoryBean.getObject();
	}
}
