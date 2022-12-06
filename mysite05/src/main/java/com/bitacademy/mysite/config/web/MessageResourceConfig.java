package com.bitacademy.mysite.config.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageResourceConfig {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages/message_ko");
		messageSource.setBasename("com/bitacademy/mysite.config/web/message");
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}
}