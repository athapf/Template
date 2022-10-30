package de.thaso.demo.examples.simplepayroll.consumer.rest.utils;

import de.thaso.demo.examples.simplepayroll.consumer.rest.dto.StockDto;
import de.thaso.demo.examples.simplepayroll.consumer.service.Stock;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface StockMapper {

    StockDto stockToStockDto(Stock stock);

    Stock stockDtoToStock(StockDto stockDto);
}
