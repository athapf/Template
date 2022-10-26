package de.thaso.demo.examples.simplepayroll.consumer.kafka.utils;

import de.thaso.demo.examples.simplepayroll.consumer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.consumer.service.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
