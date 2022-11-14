package de.thaso.demo.examples.templates.consumer.kafka;

import de.thaso.demo.examples.templates.consumer.data.ManagementDao;
import de.thaso.demo.examples.templates.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.templates.consumer.kafka.utils.BookMapper;
import de.thaso.demo.examples.templates.consumer.service.LibraryService;
import de.thaso.demo.examples.templates.consumer.service.MyBook;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class RegisteredBooksConsumer {
    private static final Logger LOGGER = Logger.getLogger(RegisteredBooksConsumer.class);

    @Inject
    private BookMapper bookMapper;

    @Channel("work")
    @OnOverflow(OnOverflow.Strategy.DROP)
    private Emitter<String> stringEmitter;

    @Inject
    private ManagementDao managementDao;

    @Blocking
    @Incoming("registeredBooks")
    public CompletionStage<Void> consumeBook(final KafkaRecord<Long, BookDto> kafkaRecord) {

        final MyBook book = bookMapper.bookDtoToMyBook(kafkaRecord.getPayload());
        managementDao.insertEmployee(book);
        stringEmitter.send(book.getId().toString());

        return kafkaRecord.ack();
    }
}
