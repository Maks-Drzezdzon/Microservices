package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@EnableEurekaClient
@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class MovieCatalogServiceApplication {
	
	@Bean
	@LoadBalanced
	// will look for service name in app.properties fill in url
	public RestTemplate getRestTemplte() {
		// setting connection timeouts 
		return new RestTemplate();
		
		/*HttpComponentsClientHttpRequestFactory clientHttpsRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpsRequestFactory.setConnectionRequestTimeout(3000);
		return new RestTemplate(clientHttpsRequestFactory);*/
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return  WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
