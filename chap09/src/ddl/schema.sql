use test;

drop table user;

create table user (
  id varchar(20) not null,
  password varchar(255) not null,
  email varchar(255),
  primary key (id)
) engine = InnoDB charset utf8;