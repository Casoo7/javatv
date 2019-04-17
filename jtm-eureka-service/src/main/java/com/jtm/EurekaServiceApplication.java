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
public class EurekaServiceApplication
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
