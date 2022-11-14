package de.thaso.demo.examples.templates.consumer.rest;

import de.thaso.demo.examples.templates.consumer.rest.dto.StockDto;
import de.thaso.demo.examples.templates.consumer.rest.utils.BookMapper;
import de.thaso.demo.examples.templates.consumer.rest.utils.StockMapper;
import de.thaso.demo.examples.templates.consumer.service.LibraryService;
import de.thaso.demo.examples.templates.consumer.service.MyStock;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class LibraryResource {

private static final Logger LOGGER = Logger.getLogger(LibraryResource.class);

    @Inject
    private LibraryService libraryService;

    @Inject
    private StockMapper stockMapper;

    @GET
    @Path("reset")
    public void doReset() {
        LOGGER.info("doReset ...");

        libraryService.doReset();
    }

    @Channel("work")
    private Multi<String> stringConsumer;

    private Random random = new Random(System.currentTimeMillis());

    @GET
    @Path("{pos}/stock")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<StockDto> stockInfo(final String pos) {
        LOGGER.info("stockInfo ...");

        return stringConsumer.log().select().where(s -> s.equals(pos))
            .select().first()
            .onItem().transform(id -> MyStock.builder()
                .withPos(id)
                .withCount(random.nextInt(900) + 100)
                .build()).onItem().transform(
                item -> stockMapper.myStockToStockDto(item));
    }
}
