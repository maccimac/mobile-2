/*
This query text was retrieved from showplan XML, and may be truncated.
*/

use university;

--Using the university database, give the following queries in SQL (SQL Server 2022).

--select * from teaches order by course_id;


---- find how many teacher teach a certain course for a certain year
--select course_id, count(distinct id) as teacher_count
--from teaches
--group by course_id;

--2. Find the total number of (distinct) students who took at least one course with the
--instructor with ID 10101.
--select * from instructor where ID = 10101;
--select *
--	from teaches as tc join instructor as i on tc.ID=i.ID 
--		where tc.id=1010
--select distinct * from takes where course_id in (
--	select course_id from teaches as tc join instructor as i on tc.ID=i.ID where tc.id=10101
--	);


--3. Find the departments with a budget higher than the average budget of all departments.
--select * from department where budget > (select avg(budget) from department);


--4. Find the departments whose payroll (the total of all instructors’ salaries in the
--department) is greater than the average payroll of all departments. Consider valid
--dept_name values only.

--select * from instructor;
--select avg(salary) from instructor where dept_name = 'Comp. Sci.';
--select avg(salary) as ave_salary_per_dept from instructor as i group by dept_name;

--select avg(ave_salary) from (select avg(salary) as ave_salary from instructor as i group by dept_name) as subquery;

--select dept_name, avg(salary) as ave_salary from instructor as i group by dept_name
--	having ave_salary > (
--			select avg(ave_salary) from (select avg(salary) as ave_salary from instructor as i group by dept_name) as subquery
--		) as subquery;
	


--select avg( 
--	avg(salary) from instructor group by dept_name) ) ;

--5. Find the department(s) with the highest minimum salary among all departments. The
--result should display the department name and the minimum salary of the department.
--Consider valid dept_name values only. 


-- find minimym salary of all dept
--select salary, dept_name, name from instructor;
--select min(salary) from instructor group by dept_name;

--select i.salary from instructor as i join (
--	select min(salary) as min_salary, dept_name from instructor group by dept_name
--	) as subq on subq.dept_name=i.dept_name;

-- 
--6. Find the course sections (course_id and sec_id) with the maximum enrollment (number
--of enrolled students) in Fall 2017.
--select count(ID), course_id, year, sec_id from takes group by course_id, year, sec_id ;


--7. Find the name of each student who did not take any courses.
--select ID from student where student.ID not in (
--	select ID from takes
--);

--8. Find the title of each course that was not taught by any instructors.
--select * from course;
--select title, course_id from course where course_id not in (
--	select course_id from teaches
--);

--9. Find the ID and name of each instructor who earns more than the average salary of her
--or his department. Consider valid dept_name values only.
 -- ave salary
 --select dept_name, avg(salary) as ave_sal from instructor group by dept_name;
 
 --select name, salary, subq.ave_sal, i.dept_name from instructor as i
 --join ( select dept_name, avg(salary) as ave_sal from instructor group by dept_name ) as subq
 --on i.dept_name = subq.dept_name where i.salary > subq.ave_sal;



--10. Create a view for the enrollment of each section that was offered in Fall 2017.
--Insert, Delete, and Update (use BEGIN TRAN … ROLLBACK)


--11. Create a new course "CS-001", titled "Weekly Seminar", with 0 credits.
--select * from course;
--insert into course values(
--	'CS-001',
--	'Weekly Seminar',
--	'Comp. Sci.',
--	null
--);
--select * from course;

--12. Increase the salary of each instructor in the Comp. Sci. department by 10%.
--select * from instructor;
--update instructor set salary = salary*1.1;

--select * from instructor

--13. Insert every student whose tot_cred attribute is greater than 100 as an instructor in the same department, with a salary of 30,000. 
--insert into instructor (ID, name, dept_name, salary)
--	select ID, name, dept_name, 30000 from student 
--	where tot_cred>100;
select * from instructor;

--14. Delete all rows in the instructor table for those instructors associated with a department located in the Watson building. 

--15. Increase salaries of instructors whose salary is over $90,000 by 3%, and all others by 5%. 

