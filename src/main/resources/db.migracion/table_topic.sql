create table topic(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(2000) not null,
    created datetime not null,
    status varchar(100) not null,
    tag varchar(50),
    user_id bigint not null,
    course_id bigint not null,

    primary key(id),

    constraint fk_topics_course_id foreign key(course_id) references course(id),
    constraint fk_topics_user_id foreign key(user_id) references users(id)
)