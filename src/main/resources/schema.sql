CREATE TABLE PUBLIC.TEST (
  id   INTEGER GENERATED BY DEFAULT AS IDENTITY ( START WITH 1) NOT NULL PRIMARY KEY,
  name VARCHAR(30)
)