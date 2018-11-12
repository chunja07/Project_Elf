use mvc;
show tables;

select * from member;

create table post(
	no int primary key auto_increment,
    id varchar(50) not null,
    name varchar(50) not null,
    title varchar(100),
    content varchar(500),
    registerdate datetime 
);

drop table post;

insert into post(id, name, title, registerdate) values ('nak', 'kim', 'What the hack!!', current_time());

insert into post(id, name, title, registerdate) values ('mvc', 'Won', 'What the Shaq!!', current_time());

insert into post(id, name, title, registerdate) values ('kay', 'beu', 'What the Getter!!', current_time());
insert into post(id, name, title, registerdate) values ('kla', 'eda', 'What the Setter!!', current_time());
insert into post(id, name, title, registerdate) values ('met', 'seg', 'What the Vilian!!', current_time());
insert into post(id, name, title, registerdate) values ('age', 'zbe', 'What the Hero!!', current_time());

select * from post;

select no, id, name, title, registerdate from thread limit 0, 3;

desc member;

select * from member;