package de.thaso.demo.examples.simplepayroll.consumer.kafka.utils;

import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
