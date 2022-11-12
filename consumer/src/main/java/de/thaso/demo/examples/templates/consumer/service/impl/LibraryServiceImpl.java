package de.thaso.demo.examples.templates.consumer.service.impl;

import de.thaso.demo.examples.templates.consumer.data.ManagementDao;
import de.thaso.demo.examples.templates.consumer.service.LibraryService;
import de.thaso.demo.examples.templates.consumer.service.MyBook;
import de.thaso.demo.examples.templates.consumer.service.MyStock;
import de.thaso.demo.examples.templates.consumer.service.channel.WorkChannel;
import io.smallrye.mutiny.Multi;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class LibraryServiceImpl implements LibraryService {
    private static final Logger LOGGER = Logger.getLogger(LibraryService.class);

    @Inject
    private ManagementDao managementDao;

    @Inject
    private WorkChannel workChannel;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void doReset() {
    }

    @Override
    public void consumeBook(final Long key, final MyBook book) {
        LOGGER.info("consumeBook ...\n" + book.toString());
        managementDao.insertEmployee(book);
        workChannel.send(book.getId().toString());
    }

    @Override
    public Multi<MyStock> stockInfo(String pos) {
        return workChannel.firstOf(pos, id -> MyStock.builder()
            .withPos(id)
            .withCount(random.nextInt(900) + 100)
            .build());
    }
}
