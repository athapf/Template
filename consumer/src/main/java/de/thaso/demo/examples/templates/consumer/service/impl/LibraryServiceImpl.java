package de.thaso.demo.examples.templates.consumer.service.impl;

import de.thaso.demo.examples.templates.consumer.data.ManagementDao;
import de.thaso.demo.examples.templates.consumer.service.LibraryService;
import de.thaso.demo.examples.templates.consumer.service.MyBook;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class LibraryServiceImpl implements LibraryService {
    private static final Logger LOGGER = Logger.getLogger(LibraryService.class);

    @Override
    public void doReset() {
    }
}
