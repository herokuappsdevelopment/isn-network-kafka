package com.isn.network.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.isn.network.model.ProductMetaData;

@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;

	public void send(String data) {

		kafkaTemplate.send(ProductMetaData.PRODUCT_INFO_TOPIC, data);
	}

	public SendResult<Object, Object> sendProductData(ProductMetaData metadata)
			throws InterruptedException, ExecutionException {

		return kafkaTemplate.send(ProductMetaData.TOPIC, metadata).get();

	}
}