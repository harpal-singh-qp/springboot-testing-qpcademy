create schema surveyapp;
use surveyapp;
create table if not exists books
(
	id bigint auto_increment
		primary key,
	title varchar(255) not null,
	isbn varchar(13) not null,
	author varchar(255) null,
	genre varchar(255) null,
	thumbnail_url varchar(255) null,
	description text null,
	publisher varchar(255) null,
	pages bigint null,
	constraint isbn
		unique (isbn)
);

create table course
(
	id int auto_increment
		primary key,
	course_name varchar(100) null,
	course_duration varchar(100) null,
	rating int null,
	coach_name varchar(100) null,
	course_category varchar(100) null,
	book_id varchar(100) null,
	user_id varchar(100) null,
	content longblob null,
	created_at timestamp null,
	title varchar(100) null
);


create table course_rating
(
	id int auto_increment
		primary key,
	course_id int null,
	rated_by varchar(11) null,
	rating int null,
	detailed_review varchar(200) null,
	constraint course_rating_course_rating_id_fk
		foreign key (course_id) references bookapp.course_rating (id)
);

create table movies
(
	id int auto_increment,
	imdb_id varchar(100) null,
	year double null,
	runtime varchar(100) null,
	genre varchar(100) null,
	director varchar(100) null,
	writer varchar(100) null,
	actors varchar(100) null,
	plot varchar(100) null,
	rated varchar(100) null,
	language varchar(100) null,
	awards varchar(100) null,
	poster varchar(100) null,
	metascore varchar(100) null,
	imdb_rating varchar(100) null,
	imdb_votes varchar(100) null,
	country varchar(100) null,
	type varchar(100) null,
	dvd varchar(100) null,
	box_office varchar(100) null,
	title varchar(100) null,
	released varchar(100) null,
	constraint movie_imdb_id_uindex
		unique (imdb_id),
	constraint movies_id_uindex
		unique (id)
);

alter table movies
	add primary key (id);



create table reviews
(
	id bigint auto_increment
		primary key,
	title varchar(255) not null,
	content text not null,
	rating int not null,
	created_at timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
	book_id bigint null,
	user_id bigint null
);

create table users
(
	id bigint auto_increment
		primary key,
	name varchar(255) not null,
	email varchar(255) not null,
	created_at timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
	constraint email
		unique (email)
);



