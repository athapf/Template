package de.thaso.demo.examples.templates.consumer.service;

import io.smallrye.mutiny.Multi;

public interface LibraryService {

    void doReset();

    void consumeBook(Long key, MyBook book);

    Multi<MyStock> stockInfo(String pos);
}
