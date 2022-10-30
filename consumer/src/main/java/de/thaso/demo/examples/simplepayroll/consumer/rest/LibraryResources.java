package de.thaso.demo.examples.simplepayroll.consumer.rest;

import de.thaso.demo.examples.simplepayroll.consumer.rest.dto.StockDto;
import de.thaso.demo.examples.simplepayroll.consumer.rest.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.rest.utils.StockMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
import de.thaso.demo.examples.simplepayroll.consumer.service.Stock;
import io.smallrye.mutiny.Multi;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class LibraryResources {
    private static final Logger LOGGER = Logger.getLogger("LibraryResources");

    @Inject
    private LibraryService libraryService;

    @Inject
    private BookMapper bookMapper;

    @Inject
    private StockMapper stockMapper;

    @GET
    @Path("/reset")
    public void doReset() {
        LOGGER.info("doReset ...");

        libraryService.doReset();
    }

    @GET
    @Path("{pos}/stock")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<StockDto> inStock(final String pos) {
        LOGGER.info("inStock: " + pos);
        return libraryService.stockInfo(pos).onItem().transform(
            stock -> stockMapper.stockToStockDto(stock));
    }
}
