CREATE table family
(
    id int AUTO_INCREMENT not null,
    family_name varchar(255) null,
    nr_of_adults int null,
    nr_of_children int null,
    nr_of_infants int null,
    constraint family_pk primary key (id)
)