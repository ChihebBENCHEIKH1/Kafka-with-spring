package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	@KafkaListener(topics = "bddcTopic",groupId = "group1")
	public void onMessage(ConsumerRecord<String, String> e)
	{
			System.out.println("*************************");
			System.out.println("KEY => "+e.key()+" VALUE => "+e.value());
			System.out.println("*************************");
	}

}
