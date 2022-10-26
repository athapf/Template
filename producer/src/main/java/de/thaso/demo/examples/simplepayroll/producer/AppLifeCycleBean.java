package de.thaso.demo.examples.simplepayroll.producer;

import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class AppLifeCycleBean {

    private static final Logger LOGGER = Logger.getLogger("AppLifeCycleBean");

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("==> The application is starting ...");
    }
}
