package com.jtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class MatchServiceApplication 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(MatchServiceApplication.class, args);
    }
}