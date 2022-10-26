package de.thaso.demo.examples.simplepayroll.producer.service;

import java.util.List;

public interface BookService {

    public List<Book> findAllBooks();

    public void updateBook(final Book content);

    public void createBook(final Book content);

    public Book findBook(final Long id);
}
