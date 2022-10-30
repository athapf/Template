package de.thaso.demo.examples.simplepayroll.consumer.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class BookConsumer {
    private static final Logger LOGGER = Logger.getLogger(BookConsumer.class);

    @Inject
    private LibraryService libraryService;

    @Inject
    private BookMapper bookMapper;

    @Incoming("values")
    public CompletionStage<Void> consume(KafkaRecord<Long, byte[]> kafkaRecord) {
        LOGGER.info("process book event: " + kafkaRecord.getKey());

        final ObjectMapper mapper = new ObjectMapper();
        try {
            final BookDto bookDto = mapper.readValue(kafkaRecord.getPayload(), BookDto.class);
            libraryService.consumeBook(bookMapper.bookDtoToBook(bookDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return kafkaRecord.ack();
    }
}
