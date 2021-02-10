                                                      # INTERNAL-ASSESSMENT #

#Q1) Write SECECT statement to achieve the following:             
-- 1. Display the Employee’s ID, Column with concatenation of First Name and Last Name, Salary who is living in ‘London’. 

SELECT employee_id, concat(first_name, ' ' , last_name) as name , salary FROM employees 
WHERE department_id=(SELECT department_id FROM departments WHERE location_id=(SELECT location_id FROM locations WHERE city='london'));

-- 2. Display the Employee’s Last name whose name starts with ‘s’. 

SELECT last_name FROM employees 
WHERE first_name LIKE 's%';

-- 3. Find the Employee Joining date in first Monday in October month. 

SELECT employee_id , hire_date FROM employees
WHERE month(hire_date)=10 AND dayname(hire_date)='monday' AND day(hire_date)<=7;

-- 4. Display the Employee name and city in capital letter. 

SELECT upper(concat(e.first_name, ' ', e.last_name)) as name , upper(l.city) as city FROM employees e
LEFT OUTER JOIN departments d ON  e.department_id=d.department_id 
JOIN locations l ON d.location_id=l.location_id;

-- 5. Display the department and there max salary of same department. 

SELECT d.department_id , d.department_name , max(e.salary) FROM departments d
LEFT OUTER JOIN employees e ON e.department_id=d.department_id 
GROUP BY d.department_id , d.department_name 
ORDER BY d.department_id;

#Q2) Find the second lowest salary among the employees, who are working in the same department.

SELECT e.department_id , min(e.salary) as second_lowest_sal FROM employees e
WHERE e.salary <> ALL (SELECT min(salary) FROM employees GROUP BY department_id HAVING count(*) > 1) AND department_id IS NOT NULL
GROUP BY e.department_id
ORDER BY e.department_id;

#Q3) Create a report have employees name, department name and job id have salary in range 10000 to 25000 and  department = 90.

use humanresource;
SELECT e.first_name, d.department_name , e.job_id FROM employees e
JOIN departments d ON e.department_id=d.department_id 
WHERE (e.department_id=90) AND (salary BETWEEN 10000 AND 25000);

#Q4)  Display job title, employee name, and the difference between salary of the employee and minimum salary for the job.

SELECT concat(e.first_name, ' ' , e.last_name)  as name , j.job_title , (e.salary-j.min_salary) as sal_diff 
FROM employees e
JOIN jobs j ON e.job_id=j.job_id; 

#Q5) Write a query to display department name, name (first_name, last_name), hire 	date, salary of the manager for all managers whose experience is more than 15 years.

SELECT d.department_name , concat(e.first_name,' ' , e.last_name) as name , e.hire_date , e.salary FROM employees e 
JOIN departments d ON d.manager_id =e.employee_id
WHERE datediff(now(),e.hire_date)/365>15;

#Q6) Create a report to display the manager number and the salary of the lowest-paid employee for that manager. Exclude anyone whose manager is not known. Exclude any groups where the minimum salary is $6,000 or less. Sort the output in descending order of salary.

SELECT e.manager_id , min(e.salary) as min_sal FROM employees e 
WHERE e.manager_id IS NOT NULL
GROUP BY e.manager_id
HAVING min(e.salary) >6000
ORDER BY min(e.salary) desc;

