package com.isn.network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class IsnNetworkKafkaApplication {

	public static void main(String[] args) {

		SpringApplication.run(IsnNetworkKafkaApplication.class, args);
	}
}