package com.kafka.libraryeventsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class LibraryEventsProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibraryEventsProducerApplication.class, args);
  }

}
