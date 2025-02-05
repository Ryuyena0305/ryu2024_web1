 
 	
# 프로젝트 : jspweb DML 과 샘플 INSERT
# 1. DB 구성한다.
drop database if exists jspweb;                
create database jspweb;                           
use jspweb;                                                  
# 2. 테이블 생성  , PK 테이블 먼저 생성 한다. 적절하게 타입 과 제약조건을 고려한다.
# [1] 회원테이블 생성 
create table member(
    mno int unsigned auto_increment , 
    mid varchar(30) not null unique ,
    mpwd varchar(30) not null ,
    mname varchar(20) not null ,
    mphone varchar(13) not null unique , 
    mdate datetime default now() ,
  mimg varchar(255) default 'default.jpg',
    constraint primary key( mno )
); # table end 
# [1] 회원테이블 샘플 레코드 삽입
insert into member ( mid , mpwd , mname , mphone ) values( 'qwe123' , 'a123456' , '유재석' ,  '010-3333-3333' );
insert into member ( mid , mpwd , mname , mphone ) values( 'asd123' , 'b123456' , '강호동' ,  '010-4444-4444' );
insert into member ( mid , mpwd , mname , mphone ) values( 'zxc123' , 'c123456' , '신동엽' ,  '010-5555-5555' );
insert into member ( mid , mpwd , mname , mphone ) values( 'vbn123' , 'd123456' , '서장훈' ,  '010-6666-6666' );
insert into member ( mid , mpwd , mname , mphone ) values( 'rty123' , 'e123456' , '하하'   ,  '010-7777-7777' );

create table point(
pno int unsigned auto_increment,
pcontent varchar(30) not null,
pcount int not null,
pdate datetime default now(),
mno int unsigned,
constraint foreign key (mno) references member(mno),
constraint primary key( pno )
);

insert into point (pcontent, pcount, pdate, mno) values
('상품 구매 적립', 1000, '2025-02-01 10:30:00', 1),
('회원가입 축하 포인트', 500, '2025-02-01 12:00:00', 2),
('설날 이벤트 포인트', 2000, '2025-02-01 14:00:00', 3);


select * from member;
select * from point; 

