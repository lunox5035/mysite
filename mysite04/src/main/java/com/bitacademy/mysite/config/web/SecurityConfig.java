package com.bitacademy.mysite.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@
@  EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {

	@Bean
	public HandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return
	}
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

	}

	
	
}
