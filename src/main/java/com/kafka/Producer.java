package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;



public class Producer {
	
	 public static void main(String[] args) {
	        /* create a producer ProducerConfig */
	        Properties properties = new Properties();
	        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.236:9101");
	        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1");
	        properties.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
	        

	        /* create the producer */
	        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {

	            /* create producer record */
	            ProducerRecord<String, String> record =
	                    new ProducerRecord<>("kafka_topic101", "hello world from java");

	            /* send the data */
	            producer.send(record);

	            //flush and close
	            producer.flush();

	        }
	    }

}