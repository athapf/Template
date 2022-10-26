package de.thaso.demo.examples.simplepayroll.consumer.rest.utils;

import de.thaso.demo.examples.simplepayroll.consumer.rest.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    List<BookDto> bookListToBookDtoList(List<Book> bookList);

    List<Book> bookDtoListToBookList(List<BookDto> bookDtoList);
}
