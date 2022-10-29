package de.thaso.demo.examples.simplepayroll.producer.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookProducer {

    @Inject
    private BookMapper bookMapper;

    private static final Logger LOGGER = Logger.getLogger("BookProducer");

    @Channel("values")
    Emitter<Record<Long, byte[]>> bookDtoEmitter;

    public Book sendBook(final Book book) {
        LOGGER.info("==> sendBook ...");

        ObjectMapper mapper = new ObjectMapper();
        final BookDto bookDto = bookMapper.bookToBookDto(book);
        LOGGER.info("send in Topic: " + bookDto.toString());
        try {
            bookDtoEmitter.send(Record.of(bookDto.getId(), mapper.writeValueAsBytes(bookDto)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
