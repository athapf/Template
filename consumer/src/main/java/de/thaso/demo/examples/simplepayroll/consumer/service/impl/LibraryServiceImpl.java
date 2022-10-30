package de.thaso.demo.examples.simplepayroll.consumer.service.impl;

import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import de.thaso.demo.examples.simplepayroll.consumer.service.Stock;
import de.thaso.demo.examples.simplepayroll.consumer.service.utils.LibraryEvent;
import io.smallrye.mutiny.Multi;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class LibraryServiceImpl implements LibraryService {
    private static final Logger LOGGER = Logger.getLogger(LibraryService.class);

    @Inject
    private LibraryEvent libraryEvent;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void doReset() {
    }

    @Override
    public void consumeBook(final Book book) {
        LOGGER.info("consumeBook: " + book.toString());
        libraryEvent.send(book.getId().toString());

    }

    @Override
    public Multi<Stock> stockInfo(String pos) {
        return libraryEvent.firstOf(pos, id -> Stock.builder()
            .withPos(id)
            .withCount(random.nextInt(900) + 100)
            .build());
    }
}
