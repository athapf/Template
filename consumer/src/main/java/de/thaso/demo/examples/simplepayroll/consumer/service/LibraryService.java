package de.thaso.demo.examples.simplepayroll.consumer.service;

import io.smallrye.mutiny.Multi;

public interface LibraryService {

    void doReset();

    void consumeBook(final Book book);

    Multi<Stock> stockInfo(final String pos);
}
