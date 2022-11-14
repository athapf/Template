package de.thaso.demo.examples.templates.consumer.rest.utils;

import de.thaso.demo.examples.templates.consumer.rest.dto.StockDto;
import de.thaso.demo.examples.templates.consumer.service.MyStock;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface StockMapper {

    StockDto myStockToStockDto(MyStock myStock);

    MyStock stockDtoToMyStock(StockDto stockDto);

    List<StockDto> myStockListToStockDtoList(List<MyStock> myStockList);

    List<MyStock> stockDtoListToMyStockList(List<StockDto> stockDtoList);
}
