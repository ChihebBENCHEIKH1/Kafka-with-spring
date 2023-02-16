package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableKafka
public class KafkaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringApplication.class, args);
	}
	

}
@RestController
 class kafka{
	private KafkaTemplate<String, String> kafkaTemplate;

	public kafka(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	@GetMapping({"/send/{message}/{topic}"})
	public String send(@PathVariable String message,@PathVariable String topic)
	{
		kafkaTemplate.send(topic,message);
		return "message sent ......";
	}
}