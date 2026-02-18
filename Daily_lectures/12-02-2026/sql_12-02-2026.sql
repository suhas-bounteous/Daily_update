select count(*) from (
select "EmpId", count(*) from "Employee" group by "EmpId" having count(*) > 1
)


-- add column manager

alter table "Employee" add column manager_id int;


-- update the values

update "Employee" set "manager_id" = 5 where "EmpId" = 4

select * from "Employee"
order by "EmpId"

--display emps having salary greater than their managers

select * 
from "Employee" a 
left join 
"Employee" b 
on a."manager_id" = b."EmpId"
where a."Salary" > b."Salary"
and a."manager_id" is not null

--dept id addition

alter table "Employee" add column "dept_id" int;

--update values

update "Employee" set "dept_id" = 30 where "EmpId" = 5

--select

select * from "Employee"

--count of dept having more than 2 emps

select "dept_id", count("dept_id") from "Employee" group by "dept_id" having count("dept_id")>2


-- add column join date

alter table "Employee" add column joining_date date

--update values

update "Employee" set joining_date = '2025-06-30' where "EmpId" = 5

--list of emps who joined last 6 months

select "EmpName" from "Employee" where "joining_date" >= current_date - Interval '6 months'

--dept table creation

create table Dept(
	dept_id int primary key,
	dept_name varchar(50)
)

-- insert values

insert into dept(dept_id, dept_name) values(10, 'Employee'),(20,'Manager'),(30,'Director'),(40,'Leader')

--dept with no emps

select a."dept_id","dept_name" from "dept" a left join "Employee" b on a.dept_id = b.dept_id where b."EmpId" is null

--return running salary for each dept

select "EmpName", "dept_id", "Salary", sum("Salary") over (partition by "dept_id" order by "EmpId") as "running salary", sum("Salary")
from "Employee" group by "dept_id", "EmpName", "Salary", "EmpId"

--rank employees salary wise
select "EmpId", "EmpName","Salary" from (select "EmpId","EmpName","Salary", dense_rank() over (partition by "dept_id" order by "Salary" desc) as rank from "Employee") where rank = 1

--add gender column
alter table "Employee" add column gender varchar(10);

--update values
update "Employee" set gender = 'F' where "EmpId" in (2,4)

--no of gender in each dept
select "dept_id", 
	sum(case when "gender" = 'M' then 1 else 0 end) as male_count,
	sum(case when "gender" = 'F' then 1 else 0 end) as female_count
from "Employee" group by dept_id;


--diff of salary bw 2 emps
select "EmpName","Salary", "Salary" - lag("Salary") over (order by "EmpId") as salary_diffence from "Employee"

--diff of salary with next emp
select "EmpName","Salary", "Salary" + lead("Salary") over (order by "EmpId") as salary_diffence from "Employee"

--find dept with highest average salary
select max(avg_salary), "dept_id" from(
select distinct "dept_id", avg("Salary") over (partition by "dept_id") as avg_salary
from "Employee" order by avg_salary) group by "dept_id"

--another way with cte
WITH avg_sal AS (
    SELECT "dept_id", AVG("Salary") as dept_avg
    FROM "Employee" 
    GROUP BY "dept_id"
)
SELECT * FROM avg_sal 
WHERE "dept_avg" = (SELECT MAX(dept_avg) FROM avg_sal);