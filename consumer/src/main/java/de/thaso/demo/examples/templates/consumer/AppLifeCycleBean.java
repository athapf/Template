package de.thaso.demo.examples.templates.consumer;

import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AppLifeCycleBean {
    private static final Logger LOGGER = Logger.getLogger(AppLifeCycleBean.class);

    @Inject
    private MigrationService migrationService;

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("==> The application is starting ...");
        //migrationService.checkMigration();
    }
}
