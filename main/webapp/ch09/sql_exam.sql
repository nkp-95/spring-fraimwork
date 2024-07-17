CREATE TABLE student (
    id INT NOT NULL Primary Key AUTO_INCREMENT,
    username VARCHAR(20),
    univ VARCHAR(40),
    birth DATE,
    email VARCHAR(40)
)

INSERT INTO student(username, univ, birth, email) values('김길동','AA대학교','1999-10-21','kim@mail.com');
INSERT INTO student(username, univ, birth, email) values('아무개','BB대학교','2000-2-1','amg@kkk.com');
INSERT INTO student(username, univ, birth, email) values('김사랑','AA대학교','2000-3-15','ksr@kmail.com');
INSERT INTO student(username, univ, birth, email) values('김길동','CC대학교','2001-01-12','mol@bmail.com');
INSERT INTO student(username, univ, birth, email) values('이리와','BB대학교','2000-5-5','lee@nn.com');


create table product(
id int not null Primary key auto_increment,
name varchar(20),
maker varchar(40),
price int ,
date date
);


insert into product(name, maker, price, date)
values('애플사과폰 12', '애플전자',1200000, "2020-12-12");


update product set id = 101 where id = 1;
select * from product;

delete form product where id 2;

 "삼전우주폰21", "삼전전자",1300000, "2021.2.2"
 
 "앨스듀얼폰", "앨스전자",1500000, "2021.3.2"
 
 insert into product (name, maker, price, date)
values('애플사과폰 12', '애플전자', 1200000, '2020-12-12');

update product set id = 101 where id = 1;

delete from  product where id = 2; 


insert into product (name, maker, price, date)
values('삼전우주폰21', '삼전전자', 1300000, '2021-2-2');

insert into product (name, maker, price, date)
values('엘스듀얼폰', '엘스전자', 1500000, '2021-3-2');


SHOW COLUMNS FROM STUDENT;
--DESC PRODUCT;
SELECT USERNAME, EMAIL FROM STUDENT;

SELECT * FROM STUDENT WHERE USERNAME = '김길동';


SELECT * FROM STUDENT WHERE USERNAME = '김길동' AND UNIV = 'AA대학교';

SELECT * FROM PRODUCT;

SELECT * FROM PRODUCT WHERE PRICE BETWEEN 1250000 AND 1300000;

SELECT ABS(-20) FROM DUAL;


SELECT * FROM STUDENT WHERE  UNIV='AA대학교' OR UNIV='CC대학교';

ALTER TABLE PRODUCT ALTER COLUMN ID RESTART WITH 103;

SELECT * FROM PRODUCT;
DELETE FROM PRODUCT WHERE ID = 103;

insert into product (name, maker, price, date)
values('엘스듀얼폰', '엘스전자', 1500000, '2021-3-2');

SHOW COLUMNS FROM STUDENT;
--DESC PRODUCT;
SELECT USERNAME, EMAIL FROM STUDENT;

SELECT * FROM STUDENT WHERE USERNAME = '김길동';


SELECT * FROM STUDENT WHERE USERNAME = '김길동' AND UNIV = 'AA대학교';

ALTER TABLE PRODUCT ALTER COLUMN ID RESTART WITH 103;

SELECT * FROM PRODUCT;
DELETE FROM PRODUCT WHERE ID = 103;

insert into product (name, maker, price, date)
values('엘스듀얼폰', '엘스전자', 1500000, '2021-3-2');


SELECT * FROM PRODUCT;

SELECT * FROM PRODUCT WHERE PRICE BETWEEN 1250000 AND 1300000;

SELECT ABS(-20) FROM DUAL;


SELECT * FROM STUDENT WHERE  UNIV='AA대학교' OR UNIV='CC대학교';

SELECT CEILING(20.25)AS CE , ROUND(20.25), FLOOR(20.25) , SQRT(4) FROM DUAL;

SELECT NOW(), CURRENT_TIMESTAMP() 
, PARSEDATETIME('10-01-2020', 'MM-dd-yyyy', 'GMT')
FROM DUAL;

SELECT * FROM STUDENT WHERE USERNAME LIKE '김%';

SELECT * FROM STUDENT ORDER BY USERNAME DESC;

SELECT * FROM STUDENT ORDER BY USERNAME ASC, UNIV DESC;

SELECT DISTINCT USERNAME FROM STUDENT;

SELECT COUNT(ID), SUM(ID), AVG(ID), MAX(ID), MIN(ID) FROM STUDENT;

--DDL (Data Definition Language)

SHOW COLUMNS FROM STUDENT;

ALTER TABLE STUDENT ALTER USERNAME VARCHAR(40);

ALTER TABLE STUDENT ADD(TEL VARCHAR(30));

DROP TABLE STUDENT;




