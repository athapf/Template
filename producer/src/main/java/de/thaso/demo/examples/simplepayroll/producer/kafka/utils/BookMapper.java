package de.thaso.demo.examples.simplepayroll.producer.kafka.utils;

import de.thaso.demo.examples.simplepayroll.producer.kafka.dto.BookDto;
import de.thaso.demo.examples.simplepayroll.producer.service.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
