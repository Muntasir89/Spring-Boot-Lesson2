package com.practice.firstproject.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.practice.firstproject.demo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
