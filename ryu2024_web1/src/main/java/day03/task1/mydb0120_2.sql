drop database if exists mydb0120_2;
create database mydb0120_2;
use mydb0120_2;
create table waiting(
   num int auto_increment ,
    phoneNum longtext , 
    pNum int ,
    constraint primary key(num)
);
select * from waiting;