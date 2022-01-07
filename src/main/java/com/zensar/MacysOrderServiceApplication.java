package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.zensar.config.SwaggerConfiguration;


@Import(SwaggerConfiguration.class)
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class MacysOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderServiceApplication.class, args);
	}

}
