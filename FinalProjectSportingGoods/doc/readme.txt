
CREATE TABLE USER
(
id INTEGER IDENTITY, 
name VARCHAR(32) NOT NULL,
password VARCHAR(32) NOT NULL,
address VARCHAR(32) NOT NULL
) ;


Class.forName("org.hsqldb.jdbcDriver");



format of url
jdbc:hsqldb:hsql://localhost/oneDB"