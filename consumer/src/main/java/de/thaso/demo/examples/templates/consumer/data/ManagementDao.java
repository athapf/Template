package de.thaso.demo.examples.templates.consumer.data;

import de.thaso.demo.examples.templates.consumer.data.cassandra.ManagementWorker;
import de.thaso.demo.examples.templates.consumer.data.utils.EmployeeMapper;
import de.thaso.demo.examples.templates.consumer.service.MyBook;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ManagementDao {

@Inject
private ManagementWorker worker;

@Inject
private EmployeeMapper employeeMapper;

  public void insertEmployee(final MyBook value) {
    worker.insertEmployee(employeeMapper.myBookToEmployeeEntity(value));
  }

  public void updateEmployee(final MyBook value) {
    worker.updateEmployee(employeeMapper.myBookToEmployeeEntity(value));
  }

  public void deleteEmployee(final MyBook value) {
    worker.deleteEmployee(employeeMapper.myBookToEmployeeEntity(value));
  }

  public void deleteEmployee(final Long key) {
    worker.deleteEmployee(key);
  }

  public MyBook findEmployeeById(final Long key) {
    return employeeMapper.employeeEntityToMyBook(worker.findEmployeeById(key));
  }

  public List<MyBook> findAllEmployee() {
    return employeeMapper.employeeEntityListToMyBookList(worker.findAllEmployee());
  }
}
