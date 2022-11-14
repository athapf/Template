package de.thaso.demo.examples.templates.consumer.data.cassandra;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface ManagementDaoMapper {

    @DaoFactory
    ManagementWorker managementWorker();
}
