create table profile(
    id bigint not null auto_increment,
    profile_name varchar(50) unique,

    primary key(id)
)