delete from Person_Order_Hobbies;
delete from Person_Hobbies;
delete from Person;
delete from Person_Order;

delete from Hobby;

insert into Hobby (id, name, type)
                values ('S1', 'С понедельника', 'SUPPOSE_START_TIME');
insert into Hobby (id, name, type)
                values ('S2', 'Завтра точно начну', 'SUPPOSE_START_TIME');
insert into Hobby (id, name, type)
                values ('B1', '3 раза в неделю', 'BUSYNESS');
insert into Hobby (id, name, type)
                values ('B2', '1 раз в неделю', 'BUSYNESS');
insert into Hobby (id, name, type)
                values ('B3', '6 раз в нееделю', 'BUSYNESS');
insert into Hobby (id, name, type)
                values ('K1', 'Спорт', 'KIND');
insert into Hobby (id, name, type)
                values ('K2', 'Творчество', 'KIND');
insert into Hobby (id, name, type)
                values ('K3', 'Самообразование', 'KIND');
