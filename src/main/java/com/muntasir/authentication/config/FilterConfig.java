package com.muntasir.authentication.config;

import com.muntasir.authentication.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private JwtFilter jwtFilter; // Spring will inject the component here

    @Bean
    public FilterRegistrationBean<JwtFilter> registerJwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        // Apply filter to a specific path, e.g., /api/*
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
