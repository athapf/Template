-- liquibase formatted sql

-- changeset liquibase:1
CREATE KEYSPACE IF NOT EXISTS employee WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};
