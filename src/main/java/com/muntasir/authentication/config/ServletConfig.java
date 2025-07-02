package com.muntasir.authentication.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("com.muntasir.authentication.servlet")
public class ServletConfig {
    // This enables automatic detection of @WebServlet, @WebFilter, and @WebListener
}