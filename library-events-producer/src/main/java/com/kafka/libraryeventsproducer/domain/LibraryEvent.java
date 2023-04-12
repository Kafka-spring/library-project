package com.kafka.libraryeventsproducer.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @PROJECT library-events-producer
 * @Author Elimane on 26/03/2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvent {

  private Integer libraryEventId;
  private LibraryEventType libraryEventType;
  private Book book;

}
