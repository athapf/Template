package de.thaso.demo.examples.simplepayroll.consumer.rest;

import de.thaso.demo.examples.simplepayroll.consumer.rest.utils.BookMapper;
import de.thaso.demo.examples.simplepayroll.consumer.service.LibraryService;
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

    @Inject
    private BookMapper bookMapper;

    private static final Logger LOGGER = Logger.getLogger("LibraryResources");

    @Inject
    private LibraryService libraryService;

    @GET
    @Path("/reset")
    public void doReset() {
        LOGGER.info("doReset ...");

        libraryService.doReset();
    }
}
