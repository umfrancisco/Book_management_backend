CREATE TABLE IF NOT EXISTS book (
	book_id int primary key,
	title varchar(250) not null,
	author varchar(250) not null,
	publisher varchar(250) not null,
	publicationYear int not null
);