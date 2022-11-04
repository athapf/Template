package de.thaso.demo.examples.templates.producer.service;

import java.util.List;

public interface BookService {

    public List<MyBook> findAllBooks();

    public void updateBook(final MyBook content);

    public void createBook(final MyBook content);

    public MyBook findBookById(final Long id);
}
