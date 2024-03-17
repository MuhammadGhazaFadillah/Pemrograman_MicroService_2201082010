package com.ghaza.order;

import com.ghaza.order.vo.Responses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
        
        @Bean
        public Responses responses(){
            return new Responses();
        }

}
