package de.thaso.demo.examples.templates.consumer.data.utils;

import de.thaso.demo.examples.templates.consumer.data.cassandra.EmployeeEntity;
import de.thaso.demo.examples.templates.consumer.service.MyBook;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface EmployeeMapper {

    EmployeeEntity myBookToEmployeeEntity(MyBook myBook);

    MyBook employeeEntityToMyBook(EmployeeEntity employeeEntity);

    List<EmployeeEntity> myBookListToEmployeeEntityList(List<MyBook> myBookList);

    List<MyBook> employeeEntityListToMyBookList(List<EmployeeEntity> employeeEntityList);
}
