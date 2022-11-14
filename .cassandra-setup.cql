
CREATE KEYSPACE IF NOT EXISTS producer WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};

CREATE TABLE IF NOT EXISTS
    producer.book(
                     id bigint PRIMARY KEY,
                     title text,
                     isbn text,
                     author text);

CREATE KEYSPACE IF NOT EXISTS consumer WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};

CREATE TABLE IF NOT EXISTS
    consumer.employee(
                         id bigint PRIMARY KEY,
                         title text,
                         content text,
                         author text);
