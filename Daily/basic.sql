select name, country from websites;
select distinct contury from websties;
select * from websties where country = 'CN';
select * from websites where country = 'CN' and alexa > 50;
select * from websties where country = 'USA' or country = 'CN';
select * from websites where alexa > 15 and (country = 'CN' or country = 'US');
select * from websites order by alexa;
select * from websites order by alexa DESC;
select * from websites order by country, alexa;
insert into websites (name, url, alexa, country) values ('Google','https://google.com', '4', 'USA');
update websites set alexa = '5000', country = 'USA' where name = 'Google';
delete from websites where name = 'Google' and country = 'USA';
delete * from websites;

select * from websites limit 2; 
select * from websites where rownum <= 2;
select top 50 percent * from websites;

select * from websites where name like 'G%';
select * from websites where name like '%k';
select * from websites where name like '%oo%';
select * from websites where name not like '%oo%';
select * from websites where url like 'https%';
select * from websies where url like '%oo%';
select * from websites where name like '_oogle';
select * from websites where name like 'G_o_le';
select * from websites where name REGEXP '^[GFs]';
select * from websites where name REGEXP '[A-H]';
select * from websites where name REGEXP '[^A-H]';

select * from websites where name in ('Google', 'USA');
select * from websites where alexa between 1 and 20;
select * from websites where alexa not between 1 and 20;
select * from websites where (alexa between 1 and 20) and not country in ('USA', 'IND');
select * from websites where name between 'A' and 'H';
select * from websites where data between '2016-05-10' and '2016-05-14';

select name as n, country as c from websites;
select name, concat(url, ', ', alexa, ', ', country) as site_info from websites;
select w.name, w.url, a.count, a.date from websites as w, access_log as a where a.site_id = w.site_id and w.name = 'Google';

select websites.id, websites.name, access_log.count, access_log.date from websites inner join access_log on websites.id = access_log.site_id;
select websites.name, access_log.count, access_log.date from websites left join access_log on websites.id = access_log.site_id order by access_log.count DESC;
select websites.name, access_log.count, access_log.date from access_log right join websites on access_log.site_id = websites.id order by access_log.count DESC;
select websites.name, access_log.count, access_log.data from websites full outer join access_log on website.id = access_log.site_id order by access_log.count DESC;

select * into websitesBackup2018 from websites;
select name, url into websitesBackup2018 from websites;
select * into websitesBackuo2018 from websites where country = 'CN';
select websites.name, access_log.count, access_log.date into websitesBackup2018 from websites left join access_log on websites.id = access_log.site_id;
select * into newtable from table1 where 1=0;

insert into websites (name, coungry) select app_name, country from apps;
insert into websites(name, country) select app_name, country from apps where id=1;

create database my_db;
create table Persons(
PersonID int NOT NULL PRIMARY KEY,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255)
);
alter table Persons add Primary Key (PersonID);
create table Persons(
PersonID int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINTS pk_PersonID PRIMARY KEY (PersonID, LastName)
);
alter table Person add CONSTRIANTS pk_PersonID PRIMARY KEY (PersonID, LastName);
alter table drop PRIMARY KEY;
alter table Persons add unique (PersonID);
alter table Persons drop CONSTRAINTS uc_PersonID;

create table Orders(
O_ID int NOT NULL PRIMARY KEY,
OrderNo int NOT NULL,
PersonID FOREIGN KEY references Persons(PersonID)
);
alter table Orders add foreign key (PersonID) references Persons (PersonID);
alter table Orders drop foreign key PersonID;

select country from websites union select country from apps order by country;
select country from websites union all select country from apps order by country;

alter table Persons add check 

create table EMPLOYY(
	id INT NOT NULL auto_increment,
	first_name VARCHAR(20) default NULL,
	last_name VARCHAR(20) default NULL,
	salary INT default NULL,
	PRIMARY KEY (id),
);

SELECT COUNT(CustomerID), country
FROM Customers
GROUP BY Country
ORDER BY COUNT(CustomerID) DESC;

SELECT Shippers,ShipperName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders 
LEFT JOIN Shippers
ON Orders.ShipperID = Shipper.ShipperID
GROUP BY ShipperName;

SELECT ID, NAME, AGE, AMOUNT
FROM CUSTOMERS, Orders
WHERE CUSTOMER.ID = ORDERS.CUSTOMER_ID;

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5
ORDER BY COUNT(CustomerID) DESC;


















