package de.thaso.demo.examples.simplepayroll.producer.rest;

import de.thaso.demo.examples.simplepayroll.producer.rest.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.rest.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import de.thaso.demo.examples.simplepayroll.producer.service.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import org.jboss.logging.Logger;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResources {

    private static final Logger LOGGER = Logger.getLogger("BookResources");

    @Inject
    private BookService bookService;

    @GET
    public List<BookDto> findAllBooks() {
        LOGGER.info("findAllBooks ...");

        return BookMapper.INSTANCE.bookListToBookDtoList(bookService.findAllBooks());
    }

    @POST
    public void updateBook(final BookDto bookDto) {
        LOGGER.info("updateBook ...");

        bookService.updateBook(BookMapper.INSTANCE.bookDtoToBook(bookDto));
    }

    @PUT
    public void createBook(final BookDto bookDto) {
        LOGGER.info("createBook ...");

        bookService.createBook(BookMapper.INSTANCE.bookDtoToBook(bookDto));
    }

    @GET
    @Path("{number}")
    public BookDto findBook(final Long id) {
        LOGGER.info("findBook ...");

        return BookMapper.INSTANCE.bookToBookDto(bookService.findBook(id));
    }
}
