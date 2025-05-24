package com.practice.firstproject.config;

@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
