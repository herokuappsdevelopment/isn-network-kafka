/**
 * 
 */
package com.isn.network.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.isn.network.model.ProductMetaData;

/**
 * @author tcts-india
 *
 */
@Component
public class MessageConsumer {
	
	 private Logger logger = LoggerFactory.getLogger(getClass());

	    @KafkaListener(topics = ProductMetaData.PRODUCT_INFO_TOPIC,groupId = ProductMetaData.PRODUCT_INFO_TOPIC+"-group")
	    public void onMessage(String message) {
	    	// + "-" + "#{T(java.util.UUID).randomUUID()}"
	        logger.info("[onMessage][ Thread :{} ProductMetaData ：{}]", Thread.currentThread().getId(), message);
	    }
	    
	    
	    @KafkaListener(topics = ProductMetaData.TOPIC,groupId = ProductMetaData.TOPIC+"-group")
	    public void onMessageMetaData(ProductMetaData message) {
	    	// + "-" + "#{T(java.util.UUID).randomUUID()}"
	        logger.info("[onMessage][ Thread :{} ProductMetaData ：{}]", Thread.currentThread().getId(), message);
	    }

}
