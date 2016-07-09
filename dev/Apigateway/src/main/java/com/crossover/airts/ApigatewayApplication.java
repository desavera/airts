package com.crossover.airts;

import java.security.Principal;

import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
@RestController
public class ApigatewayApplication {

  @RequestMapping("/")
  public String home(Principal user) {
    return "Hello " + user.getName();
  }
	public static void main(String[] args) {		
		new SpringApplicationBuilder(ApigatewayApplication.class)
        	.properties("spring.config.name=client").run(args);
	}
}
