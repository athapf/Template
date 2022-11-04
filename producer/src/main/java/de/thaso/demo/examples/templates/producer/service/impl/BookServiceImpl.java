package de.thaso.demo.examples.templates.producer.service.impl;

import de.thaso.demo.examples.templates.producer.kafka.RegisteredBooksProducer;
import de.thaso.demo.examples.templates.producer.service.MyBook;
import de.thaso.demo.examples.templates.producer.service.BookService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

    @Inject
    private RegisteredBooksProducer bookProducer;

    public void createBook(final MyBook book) {
        LOGGER.info("createBook: " + book.toString());

        bookProducer.sendBook(book.getId(), book);
        LOGGER.info("... done");
    }

    public List<MyBook> findAllBooks() {
        LOGGER.info("findAllBooks ...");
        return new ArrayList<>();
    }

    @Override
    public void updateBook(final MyBook book) {

    }

    public MyBook findBookById(final Long id) {
        LOGGER.info("findBook ...");

        return null;
    }
}
