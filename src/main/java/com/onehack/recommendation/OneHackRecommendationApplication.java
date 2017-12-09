package com.onehack.recommendation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onehack.recommendation.controller.ProductsController;

/**
 * Team ("Inbytes") Members:
 * 
 * @author Prakash Pandey : 9403678957 (Backend) 
 * @author Ashutosh Mishra : 8585953359 (Android)
 * 
 * How to run.
 * 
 * This is a spring boot application build on the top of microservice
 * architecture.
 * 
 * Test cases are present in test package (they are test cases written for
 * keeping clocks in mind. Please bear with me.).
 * 
 * Their is scope of lot of improvement in this code. I tried best for the given
 * time constraint.
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */
@SpringBootApplication
public class OneHackRecommendationApplication {

	private static Logger log = LoggerFactory.getLogger(ProductsController.class);

	public static void main(String[] args) {
		SpringApplication.run(OneHackRecommendationApplication.class, args);
		log.info("================ Started microservice ================");
	}
}
