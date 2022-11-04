package de.thaso.demo.examples.templates.consumer.service.channel;

import de.thaso.demo.examples.templates.consumer.service.MyStock;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.jboss.logging.Logger;

import java.util.function.Function;

public class WorkChannel {
    private static final Logger LOGGER = Logger.getLogger(WorkChannel.class);

    @Channel("work")
    @OnOverflow(OnOverflow.Strategy.DROP)
    private Emitter<String> stringEmitter;

    @Channel("work")
    private Multi<String> stringConsumer;

    public void send(final String value) {
        stringEmitter.send(value);
    }

    public Multi<String> stream() {
        return stringConsumer.log();
    }

    public Multi<MyStock> firstOf(final String pos, final Function<String, MyStock> stringStockFunction) {
        return stream().select().where(s -> s.equals(pos))
            .select().first()
            .onItem().transform(stringStockFunction);
    }
}
