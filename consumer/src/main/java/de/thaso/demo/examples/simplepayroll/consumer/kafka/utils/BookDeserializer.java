package de.thaso.demo.examples.simplepayroll.consumer.kafka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class BookDeserializer implements Deserializer<BookDto> {

    @Override
    public BookDto deserialize(String topic, byte[] bytes) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(bytes, BookDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
