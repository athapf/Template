package de.thaso.demo.examples.simplepayroll.producer.service.impl;

import de.thaso.demo.examples.simplepayroll.producer.kafka.BookProducer;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import de.thaso.demo.examples.simplepayroll.producer.service.BookService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = Logger.getLogger("BookControllerImpl");

    @Inject
    private BookProducer bookProducer;

    public void createBook(final Book book) {
        LOGGER.info("createBook ...");

        try {
            bookProducer.sendBook(book);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("... done");
    }

    public List<Book> findAllBooks() {
        LOGGER.info("findAllBooks ...");
        return new ArrayList<>();
    }

    @Override
    public void updateBook(final Book book) {

    }

    public Book findBook(final Long id) {
        LOGGER.info("findBook ...");

        return null;
    }
}
