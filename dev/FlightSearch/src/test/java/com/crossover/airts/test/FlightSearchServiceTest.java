package com.crossover.airts.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.crossover.airts.service.flightsearch.FlightSearchApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlightSearchApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class FlightSearchServiceTest {

	
   
    final String uri = "http://localhost:8080/fsearch";
	final Logger logger = Logger.getLogger(FlightSearchServiceTest.class);
	
	RestTemplate template = new TestRestTemplate();
	
	
    @Value("${spring.datasource.url}")
    private String databaseUrl = new String("jdbc:mysql://localhost:3306/airtsdev");

    @Value("${spring.datasource.username}")
    private String databaseUser = new String("mvera");

    @Value("${spring.datasource.password}")
    private String databasePassword = new String("password");

    
    @Autowired
    private WebApplicationContext appContext;

	@Test
	public void testRequest() throws Exception {
        String result = template.getForObject(uri, String.class);
        
        logger.debug(result);
	}
	
    
 }