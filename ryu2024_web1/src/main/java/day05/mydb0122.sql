drop database if exists mydb0122;
create database mydb0122;
use mydb0122;

-- create table member(
--  mno int auto_increment ,
--  mid varchar(20) unique,
--  mpw varchar(20),
--   constraint primary key(mno)
-- );
create table board(         
   bno int auto_increment ,        
    btitle varchar(100) ,              
    bcontent longtext ,             
    bwriter varchar(10) ,            
    bpw varchar(10) ,            
    bview int default 0 ,
    bdate datetime default now() ,
    primary key( bno )             
);


-- insert into member(mid,mpw) values (bear,0305);
-- insert into member(mid,mpw) values (heart,1219);
-- insert into member(mid,mpw) values (yena,0305);
-- insert into member(mid,mpw) values (wsws,0423);

-- insert into board(btitle,bcontent,bwriter,bpw,bview,bdate) values('안녕하세요','내용입니다','bear','0305');
-- insert into board(btitle,bcontent,bwriter,bpw) values('안녕하세요1','내용입니다1','eses','0122');
-- insert into board(btitle,bcontent,bwriter,bpw) values('안녕하세요2','내용입니다2','wsws','0423');
-- insert into board(btitle,bcontent,bwriter,bpw) values('안녕하세요3','내용입니다3','yjyj','1113');

select * from board ;


update board set btitle="수정제목",bcontent="수정안녕"where bno =1 and bpw="1234";
delete from board where bno=6;