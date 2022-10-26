package de.thaso.demo.examples.simplepayroll.producer.kafka.utils;

import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
