package com.xavier.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class ProviderService {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	/**
	 * @param topic   主题
	 * @param message 内容
	 * @return
	 */
	public ListenableFuture<SendResult<?, ?>> sendMessage(String topic, String message) {
		return this.kafkaTemplate.send(topic, message);
	}
}
