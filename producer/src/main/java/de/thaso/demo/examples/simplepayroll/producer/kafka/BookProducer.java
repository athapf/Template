package de.thaso.demo.examples.simplepayroll.producer.kafka;

import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookProducer {

    private static final Logger LOGGER = Logger.getLogger("BookProducer");

    @Channel("values")
    Emitter<BookDto> bookDtoEmitter;

    public Book sendBook(final Book value) {
        LOGGER.info("==> sendBook ...");

        bookDtoEmitter.send(BookMapper.INSTANCE.bookToBookDto(value));
        return value;
    }
}
