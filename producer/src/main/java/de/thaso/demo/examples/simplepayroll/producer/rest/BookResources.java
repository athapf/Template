package de.thaso.demo.examples.simplepayroll.producer.rest;

import de.thaso.demo.examples.simplepayroll.producer.rest.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.rest.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.producer.service.BookService;
import org.jboss.logging.Logger;

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

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResources {
    private static final Logger LOGGER = Logger.getLogger("BookResources");

    @Inject
    private BookService bookService;

    @Inject
    private BookMapper bookMapper;

    @GET
    public List<BookDto> findAllBooks() {
        LOGGER.info("findAllBooks ...");

        return bookMapper.bookListToBookDtoList(bookService.findAllBooks());
    }

    @POST
    public void updateBook(final BookDto bookDto) {
        LOGGER.info("updateBook ...");

        bookService.updateBook(bookMapper.bookDtoToBook(bookDto));
    }

    @PUT
    public void createBook(final BookDto bookDto) {
        LOGGER.info("createBook: " + bookDto.toString());

        bookService.createBook(bookMapper.bookDtoToBook(bookDto));
    }

    @GET
    @Path("{id}")
    public BookDto findBook(final Long id) {
        LOGGER.info("findBook ...");

        return bookMapper.bookToBookDto(bookService.findBook(id));
    }
}
