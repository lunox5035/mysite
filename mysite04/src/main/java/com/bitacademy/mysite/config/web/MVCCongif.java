package com.bitacademy.mysite.config.web;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MVCCongif implements WebMvcConfigurer {

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JsrlView.class, SecurityConfig.class);
		viewResolver.
		
		<!-- 서블릿 컨테이너의 디폴트 서블릿 위임 핸들러 -->
		<mvc:default-servlet-handler />	
		
		return viewResolver;
	}
	
}
