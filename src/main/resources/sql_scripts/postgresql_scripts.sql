create table person(
    id serial primary key,
    name char(60)
);

create table category(
    id serial primary key,
    name char(60)
);

create table product(
    id serial primary key,
    name char(60),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

create table user_group(
    id serial primary key,
    code char(10)
);

create table person_user_group(
    person_id int,
    user_group_id int,
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (user_group_id) REFERENCES user_group(id)
);
