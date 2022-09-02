select * from JOIN_USERS;

insert into join_users values('hi123', 54321, 'hihi', 100);

create table loan(
user_id varchar2(10), 
point number(10), 
count number(10), 
constraint loan_user_id_pk primary key(user_id), 
constraint loan_count_ch check(count in(1,2,3)));

select * from LOAN;

drop table join_users;

create table join_users( 
user_id varchar2(10), 
user_password varchar2(10) not null,
nickname varchar2(100) not null, 
point number(10) default 100, 
constraint user_user_id_pk primary key(user_id)
);

select * from JOIN_USERS;

