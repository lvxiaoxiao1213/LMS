create database lms;
drop database lms;
use lms;

drop table User;
drop table Book;
drop table category;
drop table Issuance;
drop table Receiving;
drop table Supplier;

/* User表 */
create table if not exists User(
        id  int primary key auto_increment,
        name varchar(30),
        tell varchar(30),
        idcard  varchar(30),
        address varchar(30),
        email varchar(20),
        password varchar(30),
        role int default 1,
		status int default 0,
		lendNumber int default 0
 );

insert into User(name,tell,idcard,address,email,password,role,status) values
("admin","tell","idcard","address","email","admin",0,0);
insert into User(name,tell,idcard,address,email,password,role,status) values
("tom","tell","idcard","address","email","tom",1,0);
insert into User(name,tell,idcard,address,email,password,role,status) values
("linda","tell","idcard","address","email","linda",1,0);
insert into User(name,tell,idcard,address,email,password,role,status) values
("darling","tell","idcard","address","ebmail","darling",2,0);

/* 类别表*/
create table  Category(
	catId int primary key auto_increment,
    catName varchar(100),
    description varchar(100)
);

insert into Category(catName,description)value("教材教辅","描述1");
insert into Category(catName,description)value("少儿","描述2");
insert into Category(catName,description)value("生活","描述3");
insert into Category(catName,description)value("科技","描述4");
insert into Category(catName,description)value("经济","描述5");
insert into Category(catName,description)value("人文社科","描述6");
insert into Category(catName,description)value("文学艺术","描述7");


/* Book表 */
create table Book(
    bookId int primary key auto_increment,
    bookName varchar(100),
    auth varchar(100),
    publisher varchar(100),
    catId int, 
    status int default 0,
    remark varchar(100),
    constraint foreign key(catId) references Category(catId)
);

insert into Book(bookName,auth,publisher,catId,remark) 
values("java编程思想","Bruce Eckel","北京邮电大学出版社",1,"good");
insert into Book(bookName,auth,publisher,catId,remark) 
values("三体","刘慈欣","重庆出版社",6,"good");
insert into Book(bookName,auth,publisher,catId,remark) 
values("中国近代史","徐中约","世界文学出版社",6,"good");


/* 借出表*/
drop table Issuance;
create table Issuance(
     IssuanceID int primary key auto_increment,
	 id int  ,
	 bookId int,
	 IssuanDate date,
	 ReturnDate date,
     IssuanStatus int default 0,
	 constraint foreign key(id) references User(id),
     constraint foreign key(bookId) references Book(bookId)
      
);

insert into Issuance(id, bookId,IssuanDate) values (4,1,"2016-10-01");
insert into Issuance(id, bookId,IssuanDate) values (2,2,"2016-10-01");
insert into Issuance(id, bookId,IssuanDate) values (3,3,"2016-10-01");

drop table Receiving;
create table Receiving(
		
        bookId int,
        recId int primary key auto_increment,
		RMB int ,
        fine int,
		IssuanceID int,
        ReturnDate date,
        constraint foreign key(bookId) references Book(bookId),
        constraint foreign key(IssuanceId) references Issuance(IssuanceId)
         
);
insert into Receiving(bookId,RMB,fine,IssuanceID,ReturnDate) values(1,100,0,1,"2016-01-05");

create table Supplier(

     supId int  primary key auto_increment,
     supName varchar(100) ,
     supTell varchar(30)
);

insert into  Supplier(supName,supTell) values("新华书店","183639955555"),("文轩书店","183639955556"),
("书城","183639955557");

create table messageCat(
	messageCatId int primary key auto_increment,
    messageCatContent varchar(100)
);
insert into messageCat(messageCatContent)values("亲~请及时还书，我们有罚款规定哦~");
insert into messageCat(messageCatContent)values("您预定的书本还没有被现在持有人归还。");
insert into messageCat(messageCatContent)values("您申请的书已经被归还，自动分配给已预定的用户，请耐心等待。");

create table message(
  messageId INT primary key auto_increment,
  messageCatId int,
  receiveId int,
  receiveTime date,
  ifRead int default 0,
   constraint foreign key(receiveId) references User(id),
    constraint foreign key(receiveId) references User(id)
);
insert into message(messageCatId,receiveId,receiveTime) values(1,2,"2016-10-03");
insert into message(messageCatId,receiveId,receiveTime) values(2,3,"2016-10-03");
insert into message(messageCatId,receiveId,receiveTime) values(3,2,"2016-10-03");


select count(*) from message where ifRead=0 and receiveId=2;
create table requestCat(
	requestCatId int primary key auto_increment,
    requestCatContent varchar(100)
);

insert into requestCat(requestCatContent)values("请求借书");
insert into requestCat(requestCatContent)values("请求续借");

create table request(
	requestId int primary key auto_increment,
    id int,
    requestCatId int,
    bookId int,
    requestTime date,
    requestStatus int default 0,
    constraint foreign key(id) references User(id),
    constraint foreign key(bookId) references Book(bookId),
    constraint foreign key(requestCatId) references requestCat(requestCatId)
);
insert into request(id,requestCatId,bookId,requestTime)values(2,1,1,"2016-10-05");
insert into request(id,requestCatId,bookId,requestTime)values(3,2,2,"2016-10-05");

create table income(
	incomeId int primary key auto_increment,
    id int,
    incomeCat int,
    money int,
    incomeStatus int default 0,
    constraint foreign key(id) references User(id)
);
insert into income(id,incomeCat,money,incomeStatus)values(3,1,10,1);
insert into income(id,incomeCat,money,incomeStatus)values(2,2,50,1);
insert into income(id,incomeCat,money,incomeStatus)values(3,3,10,1);
insert into income(id,incomeCat,money,incomeStatus)values(2,3,10,0);

select * from income;
select * from User;
select * from Book;
select * from Category;
select * from  Issuance;
select * from  Receiving;
select * from Supplier;
select * from message;
select * from request;
select * from income;
select * from User where role=1 or role=2;
select messageId,messageContent,name,receiveTime,ifRead from message join User on message.receiveId=User.id;

select requestId,name,requestCatContent,requestTime,requestStatus from request left join User on request.id=User.id left join requestCat on request.requestCatId=requestCat.requestCatId;

select requestId,name,requestCatId,bookName,requestTime,requestStatus from request left join User on request.id=User.id left join Book on request.bookId=Book.bookId;
update Book set status=0 where bookName='java编程思想';
update request set requestStatus=0 ;
select incomeId,name,incomeCat,money from income join User on income.id=User.id;