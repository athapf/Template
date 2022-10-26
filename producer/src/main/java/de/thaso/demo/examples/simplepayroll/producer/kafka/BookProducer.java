package de.thaso.demo.examples.simplepayroll.producer.kafka;

import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import io.quarkus.runtime.ShutdownEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BookProducer {

    private static final Logger LOGGER = Logger.getLogger("BookProducer");

    public static final String TOPIC = "values";

    @Inject
    KafkaProducer<String, BookDto> producer;

    public void terminate(@Observes ShutdownEvent ev) {
        producer.close();
    }

    public Book sendBook(final Book value)
        throws ExecutionException, InterruptedException, TimeoutException {
        LOGGER.info("==> sendBook ...");

        producer.send(new ProducerRecord<>(TOPIC, "value",
                BookMapper.INSTANCE.bookToBookDto(value)))
            .get(5, TimeUnit.SECONDS);
        return value;
    }
}
