package com.example.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {
	 @Bean
	 public LocaleChangeInterceptor localeChangeInterceptor() {
		 LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		 localeChangeInterceptor.setParamName("lang");
		 localeChangeInterceptor.setIgnoreInvalidLocale(false);
		 return localeChangeInterceptor;
	 }
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(localeChangeInterceptor());
	 }
	 @Bean
	 public CookieLocaleResolver localeResolver() {
		 CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		 localeResolver.setCookieName("lang");
		 localeResolver.setDefaultLocale(Locale.UK);
		 return localeResolver;
	 }
}