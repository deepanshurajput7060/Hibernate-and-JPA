insert into course(id, name, created_date, last_updated_date) 
values(10001, "learning spring", sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002, "learning spring boot",sysdate(),sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003, "learning spring data JPA",sysdate(),sysdate());

insert into passport(id, number) values(40001, 'E123');
insert into passport(id, number) values(40002, 'A123');
insert into passport(id, name) values(40003, 'D123');

insert into student(id, name, passport_id) 
values(20001, "Dee", 40001);
insert into student(id, name, passport_id) 
values(20002, "raj", 40002);
insert into student(id, name, passport_id) 
values(20003, "sid", 40003);

insert into review(id, rating, description, course_id) 
values(50001, '5', 'Great Course', 10001);
insert into review(id, rating, description, course_id) 
values(50002, '4', 'Awesome Course', 10002);
insert into review(id, rating, description, course_id) 
values(50003, '5', 'Nice Course', 10003);

insert into student_course(student_id, course_id)
values(20001, 10001);
insert into student_course(student_id, course_id)
values(20002, 10002);
insert into student_course(student_id, course_id)
values(20003, 10003);
insert into student_course(student_id, course_id)
values(20001, 10003);







