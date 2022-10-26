package de.thaso.demo.examples.simplepayroll.consumer.rest.utils;

import de.thaso.demo.examples.simplepayroll.consumer.rest.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> bookListToBookDtoList(List<Book> bookList);

    List<Book> bookDtoListToBookList(List<BookDto> bookDtoList);
}
