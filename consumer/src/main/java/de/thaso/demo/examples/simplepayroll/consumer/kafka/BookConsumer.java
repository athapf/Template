package de.thaso.demo.examples.simplepayroll.consumer.kafka;

import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.kafka.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookConsumer {

    private static final Logger LOGGER = Logger.getLogger("BookProducer");

    @Inject
    private LibraryService libraryService;

    @Incoming("values")
    public void process(final BookDto bookDto) {
        LOGGER.info("process book event");
        libraryService.consumeBook(BookMapper.INSTANCE.bookDtoToBook(bookDto));
    }
}
