#SCHEMA for MySQL DB
drop table if exists developer CASCADE;
drop table if exists game CASCADE;
drop table if exists genre CASCADE;
drop table if exists platform CASCADE;
drop table if exists producer CASCADE;
create table developer (id bigint not null auto_increment, name varchar(255) not null, primary key (id));
create table game (id bigint not null auto_increment, name varchar(255) not null, description blob(255), image_url varchar(255),
                release_date date, developer_id bigint, genre_id bigint, platform_id bigint, producer_id bigint, primary key (id));
create table genre (id bigint not null auto_increment, name varchar(255) not null, primary key (id));
create table platform (id bigint not null auto_increment, brand varchar(255) not null, name varchar(255) not null, primary key (id));
create table producer (id bigint not null auto_increment, name varchar(255) not null, primary key (id));
alter table game add constraint FKgpenvlwr21y1g95uq6lv8of0u foreign key (developer_id) references developer (id);
alter table game add constraint FK7apnaiiiguf11ti5ivin5grd9 foreign key (genre_id) references genre (id);
alter table game add constraint FKqbkf2002dfk9drnxmwxiqix6h foreign key (platform_id) references platform (id);
alter table game add constraint FKm81vgm2u4b0lm8bxwi4aq4mxx foreign key (producer_id) references producer (id);
