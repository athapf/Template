package de.thaso.demo.examples.simplepayroll.consumer.service.impl;

import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LibraryServiceImpl implements LibraryService {
    private static final Logger LOGGER = Logger.getLogger(LibraryService.class);

    @Override
    public void doReset() {
    }

    public void consumeBook(final Book book) {
        LOGGER.info("consumeBook: " + book.toString());
    }
}
