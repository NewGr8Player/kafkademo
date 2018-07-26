package com.xavier;

import com.xavier.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于Canal抓取数据，将数据转为Json存入Kafka
 */
@EnableCanalClient
@SpringBootApplication
public class JsonProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(JsonProviderApp.class, args);
	}
}