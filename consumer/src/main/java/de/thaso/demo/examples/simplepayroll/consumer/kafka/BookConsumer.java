package de.thaso.demo.examples.simplepayroll.consumer.kafka;

import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class BookConsumer {

    private static final Logger LOGGER = Logger.getLogger(BookConsumer.class);

    @Inject
    private BookMapper bookMapper;

    @Inject
    private LibraryService libraryService;

    @Incoming("values")
    public CompletionStage<Void> consume(KafkaRecord<String, BookDto> bookDtoRecord) {
        LOGGER.info("process book event: " + bookDtoRecord.getKey());
        libraryService.consumeBook(bookMapper.bookDtoToBook(bookDtoRecord.getPayload()));
        return bookDtoRecord.ack();
    }
}
