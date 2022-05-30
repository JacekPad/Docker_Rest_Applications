create table family_member
(
    id          bigint auto_increment
        primary key,
    age         int          not null,
    family_id   bigint       null,
    family_name varchar(255) null,
    given_name  varchar(255) null
);