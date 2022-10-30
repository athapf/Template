package de.thaso.demo.examples.simplepayroll.consumer.service.utils;

import de.thaso.demo.examples.simplepayroll.consumer.service.Stock;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.jboss.logging.Logger;

import java.util.function.Function;

public class LibraryEvent {
    private static final Logger LOGGER = Logger.getLogger(LibraryEvent.class);

    @Channel("event-in-memory")
    @OnOverflow(OnOverflow.Strategy.DROP)
    private Emitter<String> doWork;

    @Channel("event-in-memory")
    private Multi<String> work;

    public void send(final String pos) {
        doWork.send(pos);
    }

    public Multi<String> stream() {
        return work.log();
    }

    public Multi<Stock> firstOf(final String pos, final Function<String, Stock> stringStockFunction) {
        return stream().select().where(s -> s.equals(pos))
            .select().first()
            .onItem().transform(stringStockFunction);
    }
}
