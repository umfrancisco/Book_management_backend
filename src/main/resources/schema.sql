CREATE TABLE IF NOT EXISTS book (
	book_id int primary key,
	title varchar(250) not null,
	author varchar(250) not null,
	publisher varchar(250) not null,
	publication_year int not null,
	price float not null,
	stock int not null
);