SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 	id int PRIMARY KEY auto_increment,
 	departmentname VARCHAR,
 	description VARCHAR
);

CREATE TABLE IF NOT EXISTS staff (
 	id int PRIMARY KEY auto_increment,
 	name VARCHAR,
	staffId VARCHAR,
	email VARCHAR,
	phone VARCHAR,
	role VARCHAR,
	department int,
);

CREATE TABLE IF NOT EXISTS news (
 	id int PRIMARY KEY auto_increment,
 	title VARCHAR,
	author int,
	type VARCHAR,
	contenturl VARCHAR,
	department int,
);