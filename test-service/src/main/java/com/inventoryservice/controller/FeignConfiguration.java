package com.inventoryservice.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration {

	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		   return new BasicAuthRequestInterceptor("testman", "testman");
		   
		   
}}
