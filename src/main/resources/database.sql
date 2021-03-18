#Table: userss
create table if not exists userss(
                                     id bigint not null  auto_increment PRIMARY KEY ,
                                     username varchar(255) not null unique,
                                     password varchar(255) not null,
                                     first_name varchar(50) not null,
                                     last_name varchar(50) not null);



#Table: roless
create table if not exists roless(
                                     id bigint not null auto_increment PRIMARY KEY ,
                                     role varchar(255) not null );

#Table: userss_roless
create table if not exists userss_roless(
                                            user_id bigint not null ,
                                            roles_id bigint not null ,
                                            FOREIGN KEY (user_id) REFERENCES userss(id),
                                            FOREIGN KEY (roles_id) REFERENCES roless(id),
                                            UNIQUE (user_id, roles_id));

insert into userss values (7,	'user',	'user',	'Fedya',	'Fedorov');
insert into userss values (8,	'admin',	'admin',	'Jora',	'Ruchkin');

insert into roless values (1, 'ROLE_USER');
insert into roless values (2, 'ROLE_ADMIN');

insert into userss_roless values (7, 1);
insert into userss_roless values (8, 2);



