package com.crossover.airts.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.crossover.airts.service.booking.BookingApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookingApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8080")
public class BookingServiceTest {

	
   
    final String uri = "http://localhost:8080/bsearch";
	final Logger logger = Logger.getLogger(BookingServiceTest.class);
	
	RestTemplate template = new TestRestTemplate();
	
	@Autowired
    private WebApplicationContext wac;


	@Test
	public void testRequest() throws Exception {
        String result = template.getForObject(uri, String.class);
        
        logger.debug(result);
	}
	
    
 }