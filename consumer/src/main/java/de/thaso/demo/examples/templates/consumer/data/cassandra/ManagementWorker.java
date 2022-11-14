package de.thaso.demo.examples.templates.consumer.data.cassandra;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;

import java.util.List;

@Dao
public interface ManagementWorker {

  @Insert
  void insertEmployee(EmployeeEntity value);

  @Update
  void updateEmployee(EmployeeEntity value);

  @Delete
  void deleteEmployee(EmployeeEntity value);

  @Delete(entityClass = EmployeeEntity.class)
  void deleteEmployee(Long key);

  @Select
  EmployeeEntity findEmployeeById(Long key);

  @Select
  List<EmployeeEntity> findAllEmployee();
}
