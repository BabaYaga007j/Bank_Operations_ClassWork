create database bank_management_system;
use bank_management_system;
create table customerDetails(CustomerID int auto_increment primary key,
FirstName varchar(30),
MiddleName varchar(30),
LastName varchar(30),
MobileNumber int (12) unique );
insert into customerDetails(CustomerId,FirstName,MiddleName,LastName,MobileNumber) values ('001', 'Durga','Prasad','Pradhan','96969696'),
('002', 'Dur','Pra','dhan','96969695'),
('003', 'Som','Prasad','Pradhan','96969152'),
('004', 'Soumya','Prasad','Pradhan','96969785');

select * from customerDetails;

create table accountDetails(Customer_Id int , Account_Number int (15), Account_Type varchar(10), Account_Balance int (10), Branch_Code int (10),foreign key (Customer_Id) references customerDetails (CustomerId) on delete cascade);
insert into accountDetails(Customer_Id, Account_Number,Account_Type,Account_Balance,Branch_Code) values ('001','123','savings','10000','112'),
('002','456','savings','20000','113'),
('003','235','current','30000','114'),
('004','789','current','40000','112');
select * from accountDetails;
drop table accountDetails;

select Account_Number from accountDetails;