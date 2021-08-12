create database estock;

create table estock.company(
NAME varchar(255),
CODE varchar(255),
CEO varchar(255),
TURNOVER varchar(255),
STOCKEXHANGE varchar(255),
WEBSITE varchar(255)
);
create table estock.stockprice(
ID int NOT NULL,
CODE varchar(255),
STOCKPRICE float,
CREATEDDATE timestamp(6),
primary key(ID)
);


select * from estock.stockprice;
desc estock.stockprice;

alter table estock.stockprice
 add column ID int;





