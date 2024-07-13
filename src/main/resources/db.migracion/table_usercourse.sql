create table userscourse (
    id bigint not null auto_increment,
    user_id bigint not null,
    course_id bigint not null,
    enrolled datetime not null,
    active boolean not null,

    primary key(id),

    constraint fk_userscourse_user_id foreign key(user_id) references users(id),
    constraint fk_userscourse_course_id foreign key(course_id) references course(id)
)