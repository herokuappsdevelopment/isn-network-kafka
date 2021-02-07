package com.isn.network.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isn.network.model.ProductMetaData;
import com.isn.network.service.KafkaSender;

@RestController
@RequestMapping(value = "/kafka/")
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender;

	@GetMapping(value = "/v1/producer")
	public String producer(@RequestParam(name="message",required=false) String message) {
		
		if (message == null) {
			message= "ISN Network";
		}
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic - "+ProductMetaData.PRODUCT_INFO_TOPIC+" Successfully";
	}
	
	@GetMapping(value = "/v2/producer")
	public String producerV2() {
		
		ProductMetaData metadata = new ProductMetaData();
		metadata.setPrice(100.0);
		metadata.setProductName("Samsung");
		metadata.setSku("SMG SMART");
		try {
			kafkaSender.sendProductData(metadata);
		} catch (InterruptedException | ExecutionException e) {
			return "Sending message to kafka topic failed.";
		}

		return "Message sent to the Kafka Topic - "+ProductMetaData.TOPIC+" Successfully";
	}

}

