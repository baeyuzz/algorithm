drop table product;

create table product (
isbn char(8) primary key,
pname varchar(10) not null,
price int not null);

insert product values ('123-001','삼성50TV',1000000);
insert product values ('234-002','LGTV',980000);
insert product values ('123-010','삼성노트북',1300000);
insert product values ('234-020','그램노트북',1500000);
insert product values ('321-001','맥노트북',1800000);

update product set price = price * 0.85;
select * from product;

update product set price = price * 0.8 where pname like '%TV%';
select * from product;

select sum(price) from product;