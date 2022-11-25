package com.bitacademy.mysite.config.app;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisconfig {

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSorce ,ApplicationContext applicationContext ) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory =new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSorce);
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("com.bitacademy.mysite.config.app"));
		
		return sqlSessionFactory.getObject();
		
	}
	@Bean
	public SqlSession SqlsessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);	
	}
}
