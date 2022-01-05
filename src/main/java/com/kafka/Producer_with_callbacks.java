package com.kafka;

import java.util.Properties;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;



public class Producer_with_callbacks implements Callback {
	
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
	            producer.send(record, new Producer_with_callbacks());

	            //flush and close
	            producer.flush();

	        }
	    }

	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		System.out.println("Callbacks !!!");
		if (exception != null){
			exception.printStackTrace();
		}
	}

}