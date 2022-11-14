package de.thaso.demo.examples.templates.consumer.service;

import io.smallrye.mutiny.Multi;

public interface LibraryService {

    void doReset();
    Multi<MyStock> stockInfo(final String pos);
    void consumeBook(final Long key, final MyBook payload);
}
