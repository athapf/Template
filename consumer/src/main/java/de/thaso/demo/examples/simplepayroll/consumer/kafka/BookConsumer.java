package de.thaso.demo.examples.simplepayroll.consumer.kafka;

import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;
import java.util.Collections;

public class BookConsumer {

    private static final Logger LOGGER = Logger.getLogger("BookConsumer");

    public static final String TOPIC = "values";

    @Inject
    KafkaConsumer<String, BookDto> consumer;

    @Inject
    private LibraryService libraryService;

    volatile boolean done = false;

    public void initialize(@Observes StartupEvent ev) {
        consumer.subscribe(Collections.singleton(TOPIC));
        new Thread(() -> {
            while (!done) {
                final ConsumerRecords<String, BookDto> consumerRecords = consumer.poll(Duration.ofSeconds(1));

                consumerRecords.forEach(record -> {
                    LOGGER.info("==> book event arrived");
                    final BookDto value = record.value();
                    process(value);
                });
            }
            consumer.close();
        }).start();
    }

    private void process(final BookDto bookDto) {
        LOGGER.info("process book event");
        libraryService.consumeBook(BookMapper.INSTANCE.bookDtoToBook(bookDto));
    }

    public void terminate(@Observes ShutdownEvent ev) {
        done = false;
    }
}
