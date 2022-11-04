package de.thaso.demo.examples.templates.producer;

import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class AppLifeCycleBean {

    private static final Logger LOGGER = Logger.getLogger(AppLifeCycleBean.class);

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("==> The application is starting ...");
    }
}
