drop table department
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);


INSERT INTO department (department_id, department_name) VALUES
(1, 'Computer Science'),
(2, 'Mechanical Engineering'),
(3, 'Electrical Engineering'),
(4, 'Civil Engineering'),
(5, 'Mathematics'),
(6, 'Biology');


CREATE TABLE address (
    address_id INT PRIMARY KEY,
    street_address VARCHAR(150) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10) NOT NULL
);

INSERT INTO address (address_id, street_address, city, state, postal_code) VALUES
(1, '123 Elm St', 'Springfield', 'IL', '62701'),
(2, '456 Oak St', 'Decatur', 'IL', '62521'),
(3, '789 Pine St', 'Champaign', 'IL', '61820'),
(4, '102 Birch Rd', 'Peoria', 'IL', '61602'),
(5, '205 Cedar Ave', 'Chicago', 'IL', '60601'),
(6, '310 Maple Dr', 'Urbana', 'IL', '61801'),
(7, '415 Oak Blvd', 'Champaign', 'IL', '61821'),
(8, '520 Pine Rd', 'Carbondale', 'IL', '62901');


CREATE TABLE student (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    department_id INT,
    address_id INT,
    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
        REFERENCES department(department_id)
        ON DELETE SET NULL,
    CONSTRAINT fk_address
        FOREIGN KEY (address_id)
        REFERENCES address(address_id)
        ON DELETE SET NULL
);

INSERT INTO student (student_id, first_name, last_name, birthdate, department_id, address_id) VALUES
(1, 'John', 'Doe', '1995-04-15', 1, 1),
(2, 'Jane', 'Smith', '1996-07-22', 2, 2),
(3, 'Alice', 'Johnson', '1994-11-30', 3, 3),
(4, 'Michael', 'Brown', '1997-02-19', 4, 4),
(5, 'Sophia', 'Davis', '1998-01-05', 5, 5),
(6, 'Daniel', 'Wilson', '1995-06-10', 6, 6),
(7, 'Olivia', 'Martinez', '1997-11-25', 1, 7),
(8, 'Ethan', 'Miller', '1996-03-30', 2, 8);

--3
select count(*) as "Students Count" from student

--4
select s.first_name, d.department_name from department d
right join 
student s
where s.first_name = 'John'

--5
select d.department_name, count(s.student_id) from department d
left join student s
on s.department_id = d.department_id
group by d.department_id

--6
select s.*, d.department_name, a.*
from student s
left join 
department d
on s.department_id = d.department_id
left join address a
on s.address_id = a.address_id


--7
select s.student_id, s.first_name, s.last_name from student s left join department d
on s.department_id = d.department_id
where d.department_name = 'Computer Science'


--8
update address a 
set city = 'New York' 
from student s
where s.address_id = a.address_id
and s.first_name = 'Jane'

--9
delete from student s where student_id = 6

--10
select a.city, s.*, d.department_name
from student s 
right join address a
on a.address_id = s.address_id
left join department d
on s.department_id = d.department_id
where a.city = 'New York'


--11
select d.department_name, count(s.student_id) 
from department d
left outer join 
student s
on s.department_id = d.department_id
group by d.department_id

--12
select s.first_name,a.city
from student s 
right join address a
on a.address_id = s.address_id
where a.city = 'Springfield'

--13
SELECT *
FROM student
WHERE EXTRACT(MONTH FROM birthdate) = 2;

--14
select s.*, d.department_name, a.*
from student s 
left join address a
on a.address_id = s.address_id
left join department d
on s.department_id = d.department_id
where s.first_name = 'John'

--15
SELECT *
FROM student
WHERE EXTRACT(YEAR FROM birthdate) BETWEEN 1995 AND 1998;

--16
select s.*, d.department_name
from department d
left outer join 
student s
on s.department_id = d.department_id
order by d.department_name


--17
select count(s.student_id)
from student s 
right join address a
on a.address_id = s.address_id
where a.city = 'Champaign'

--18
select count(s.student_id)
from student s 
right join address a
on a.address_id = s.address_id
where a.street_address like '%Pine%'

--19th one in doubt

--20
select s.first_name, s.last_name, d.department_name, a.city
from student s 
left join address a
on a.address_id = s.address_id
left join department d
on s.department_id = d.department_id
where d.department_name = 'Mathematics'
and a.city = 'Chicago'

-- 21
SELECT s.*
FROM Student s
JOIN Address a ON s.address_id = a.address_id
WHERE a.city IN ('Urbana', 'Peoria');

-- 22
SELECT *
FROM Student
ORDER BY student_id DESC
LIMIT 1;

-- 23
SELECT s.*
FROM Student s
JOIN Department d ON s.department_id = d.department_id
WHERE d.department_name <> 'Computer Science';

-- 24
SELECT COUNT(*)
FROM Address
WHERE city = 'Champaign';

-- 25
SELECT s.first_name, s.last_name
FROM Student s
JOIN Address a ON s.address_id = a.address_id
WHERE a.street_address = '520 Pine Rd';

-- 26
SELECT AVG(EXTRACT(YEAR FROM AGE(CURRENT_DATE, s.birthdate))) AS average_age
FROM Student s
JOIN Department d ON s.department_id = d.department_id
WHERE d.department_name = 'Electrical Engineering';

-- 27
SELECT s.first_name, s.last_name, d.department_name, a.city
FROM Student s
JOIN Department d ON s.department_id = d.department_id
JOIN Address a ON s.address_id = a.address_id
WHERE d.department_name LIKE 'M%';

-- 28
DELETE FROM Student
WHERE department_id = (
    SELECT department_id
    FROM Department
    WHERE department_name = 'Mechanical Engineering'
)
LIMIT 1;
