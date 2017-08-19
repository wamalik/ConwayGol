package com.conwaygol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.conwaygol")
@EnableAutoConfiguration
public class ConwayGolApplication extends SpringBootServletInitializer {
    private static Class applicationClass = ConwayGolApplication.class;
    public static void main(String[] args) {
        SpringApplication.run(ConwayGolApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}