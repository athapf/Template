package de.thaso.demo.examples.simplepayroll.producer.kafka.utils;

import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class BookSerializer implements Serializer<BookDto> {
    @Override
    public byte[] serialize(String s, BookDto value) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(value);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
