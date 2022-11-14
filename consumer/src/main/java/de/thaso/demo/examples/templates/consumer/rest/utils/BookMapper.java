package de.thaso.demo.examples.templates.consumer.rest.utils;

import de.thaso.demo.examples.templates.consumer.rest.dto.BookDto;
import de.thaso.demo.examples.templates.consumer.service.MyBook;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface BookMapper {

    BookDto myBookToBookDto(MyBook myBook);

    MyBook bookDtoToMyBook(BookDto bookDto);

    List<BookDto> myBookListToBookDtoList(List<MyBook> myBookList);

    List<MyBook> bookDtoListToMyBookList(List<BookDto> bookDtoList);
}
