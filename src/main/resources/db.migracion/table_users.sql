create table users(
    id bigint not null auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    username varchar(20) unique,
    email varchar(100) unique,
    password varchar(300),

    primary key(id)
)