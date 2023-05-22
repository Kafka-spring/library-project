package com.kafka.libraryeventsconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.libraryeventsconsumer.config.KafkaConsumerProperties;
import com.kafka.libraryeventsconsumer.service.LibraryEventsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @PROJECT library-events-consumer
 * @Author Elimane on 20/05/2023
 */

// Used to reprocessed the message after failure
@Component
@Slf4j
@RequiredArgsConstructor
public class LibraryEventRetryConsumer {

  private final LibraryEventsService service;

  @KafkaListener(topics ={"${topics.retry}"}, autoStartup = "${retryListener.startup:false}", groupId = "retry-listener-group")
  public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
    log.info("ConsumerRecord in retry Consumer : {}", consumerRecord);
    consumerRecord.headers().forEach(header -> log.info("Key : {}, value : {}", header.key(),new String(header.value(), StandardCharsets.UTF_8)));
    service.processLibraryEvent(consumerRecord);
  }
}
