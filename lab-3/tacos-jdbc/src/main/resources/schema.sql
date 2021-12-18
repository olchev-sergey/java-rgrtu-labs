create table if not exists Hobby (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(30) not null
);

create table if not exists Person (
  id identity,
  name varchar(50) not null,
  createdAt timestamp not null
);

create table if not exists Person_Hobbies (
  person bigint not null,
  hobby varchar(4) not null
);

alter table Person_Hobbies
    add foreign key (person) references Person(id);
alter table Person_Hobbies
    add foreign key (hobby) references Hobby(id);

create table if not exists Person_Order (
	id identity,
	deliveryName varchar(50) not null,
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null,
	ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Person_Order_Hobbies (
	personOrder bigint not null,
	person bigint not null
);

alter table Person_Order_Hobbies
    add foreign key (personOrder) references Person_Order(id);
alter table Person_Order_Hobbies
    add foreign key (person) references Person(id);
