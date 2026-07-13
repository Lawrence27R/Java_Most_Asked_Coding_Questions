
-- =============================================================================
-- SQLInterviewQuestions.sql
-- Most Asked SQL Interview Questions (Java Developers - 2 to 3 Years Experience)
-- =============================================================================

-- ============================================================================
-- Sample Schema
-- ============================================================================

CREATE TABLE Department(
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

CREATE TABLE Employee(
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    salary INT,
    dept_id INT,
    manager_id INT,
    joining_date DATE
);

-- Sample Data

INSERT INTO Department VALUES
(1,'IT'),
(2,'HR'),
(3,'Finance'),
(4,'Sales');

INSERT INTO Employee VALUES
(101,'Alice',60000,1,NULL,'2022-01-10'),
(102,'Bob',75000,1,101,'2021-04-15'),
(103,'Charlie',50000,2,101,'2023-02-20'),
(104,'David',90000,1,102,'2020-06-18'),
(105,'Eva',75000,3,104,'2022-11-01'),
(106,'Frank',45000,4,104,'2023-03-10'),
(107,'Grace',90000,3,104,'2021-09-12'),
(108,'Henry',55000,NULL,104,'2024-01-08');

-- ============================================================================
-- Question: Find Highest Salary
-- ============================================================================
SELECT MAX(salary) AS highest_salary FROM Employee;

-- ============================================================================
-- Question: Find Second Highest Salary
-- ============================================================================
SELECT MAX(salary)
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);

-- ============================================================================
-- Question: Find Third Highest Salary
-- ============================================================================
SELECT DISTINCT salary
FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 2;

-- ============================================================================
-- Question: Find Nth Highest Salary (using DENSE_RANK)
-- ============================================================================
SELECT salary
FROM (
    SELECT salary,
           DENSE_RANK() OVER(ORDER BY salary DESC) rnk
    FROM Employee
) t
WHERE rnk = 3;

-- ============================================================================
-- Question: Employees Earning More Than Average Salary
-- ============================================================================
SELECT *
FROM Employee
WHERE salary > (SELECT AVG(salary) FROM Employee);

-- ============================================================================
-- Question: Group Employees By Department
-- ============================================================================
SELECT dept_id, COUNT(*) total_employees
FROM Employee
GROUP BY dept_id;

-- ============================================================================
-- Question: Group Employees By Salary
-- ============================================================================
SELECT salary, COUNT(*) total
FROM Employee
GROUP BY salary;

-- ============================================================================
-- Question: Highest Salary In Each Department
-- ============================================================================
SELECT dept_id, MAX(salary) highest_salary
FROM Employee
GROUP BY dept_id;

-- ============================================================================
-- Question: Average Salary Per Department
-- ============================================================================
SELECT dept_id, AVG(salary) avg_salary
FROM Employee
GROUP BY dept_id;

-- ============================================================================
-- Question: Departments Having More Than One Employee
-- ============================================================================
SELECT dept_id, COUNT(*)
FROM Employee
GROUP BY dept_id
HAVING COUNT(*) > 1;

-- ============================================================================
-- Question: Employees With Department Name
-- ============================================================================
SELECT e.emp_name, d.dept_name
FROM Employee e
INNER JOIN Department d
ON e.dept_id = d.dept_id;

-- ============================================================================
-- Question: Employees Without Department
-- ============================================================================
SELECT *
FROM Employee
WHERE dept_id IS NULL;

-- ============================================================================
-- Question: Departments Without Employees
-- ============================================================================
SELECT d.*
FROM Department d
LEFT JOIN Employee e
ON d.dept_id = e.dept_id
WHERE e.emp_id IS NULL;

-- ============================================================================
-- Question: Find Duplicate Salaries
-- ============================================================================
SELECT salary, COUNT(*)
FROM Employee
GROUP BY salary
HAVING COUNT(*) > 1;

-- ============================================================================
-- Question: Find Duplicate Employee Names
-- ============================================================================
SELECT emp_name, COUNT(*)
FROM Employee
GROUP BY emp_name
HAVING COUNT(*) > 1;

-- ============================================================================
-- Question: Top 3 Highest Salaries
-- ============================================================================
SELECT DISTINCT salary
FROM Employee
ORDER BY salary DESC
LIMIT 3;

-- ============================================================================
-- Question: Lowest Salary
-- ============================================================================
SELECT MIN(salary)
FROM Employee;

-- ============================================================================
-- Question: Employees Joined After 2022
-- ============================================================================
SELECT *
FROM Employee
WHERE joining_date >= '2023-01-01';

-- ============================================================================
-- Question: Count Employees In Each Department
-- ============================================================================
SELECT d.dept_name,
       COUNT(e.emp_id) employee_count
FROM Department d
LEFT JOIN Employee e
ON d.dept_id = e.dept_id
GROUP BY d.dept_name;

-- ============================================================================
-- Question: Rank Employees By Salary
-- ============================================================================
SELECT emp_name,
       salary,
       DENSE_RANK() OVER(ORDER BY salary DESC) salary_rank
FROM Employee;

-- ============================================================================
-- Question: Top 3 Salaries Department Wise
-- ============================================================================
SELECT *
FROM (
    SELECT emp_name,
           dept_id,
           salary,
           DENSE_RANK() OVER(PARTITION BY dept_id ORDER BY salary DESC) rnk
    FROM Employee
) t
WHERE rnk <= 3;

-- ============================================================================
-- Question: Running Salary Total
-- ============================================================================
SELECT emp_name,
       salary,
       SUM(salary) OVER(ORDER BY emp_id) running_total
FROM Employee;

-- ============================================================================
-- Question: Find Employees Having Same Salary
-- ============================================================================
SELECT *
FROM Employee
WHERE salary IN (
    SELECT salary
    FROM Employee
    GROUP BY salary
    HAVING COUNT(*) > 1
);

-- ============================================================================
-- Question: Employee Manager Details (Self Join)
-- ============================================================================
SELECT e.emp_name Employee,
       m.emp_name Manager
FROM Employee e
LEFT JOIN Employee m
ON e.manager_id = m.emp_id;

-- ============================================================================
-- Question: Count Employees
-- ============================================================================
SELECT COUNT(*) FROM Employee;

-- ============================================================================
-- Question: Find Maximum Salary Department Wise Using Window Function
-- ============================================================================
SELECT emp_name,
       dept_id,
       salary,
       MAX(salary) OVER(PARTITION BY dept_id) dept_max_salary
FROM Employee;


-- Find employee names longer than 5 characters
SELECT *
FROM Employee
WHERE LENGTH(emp_name) > 5;

-- Find first 3 characters
SELECT SUBSTRING(emp_name,1,3)
FROM Employee;

-- Last 3 characters
SELECT RIGHT(emp_name,3)
FROM Employee;

-- Replace 'a' with '*'
SELECT REPLACE(emp_name,'a','*')
FROM Employee;

-- Reverse employee names
SELECT REVERSE(emp_name)
FROM Employee;

DELETE FROM employee
WHERE id NOT IN (
    SELECT MIN(id)
    FROM employee
    GROUP BY name
);

DELETE FROM employee
WHERE ctid NOT IN (
    SELECT MIN(ctid)
    FROM employee
    GROUP BY id
);

ctid is PostgreSQL-specific

-- Convert names to uppercase LOWER
SELECT UPPER(emp_name)
FROM Employee;

-- Concatenate employee name and salary
SELECT CONCAT(emp_name,' - ',salary)
FROM Employee;

-- Find employees whose 3rd character is 'r'
SELECT *
FROM Employee
WHERE SUBSTRING(emp_name,3,1)='r';
-- ============================================================================
-- Question: Delete Duplicate Rows (keep lowest emp_id)
-- ============================================================================
-- Example pattern:
-- DELETE FROM Employee
-- WHERE emp_id NOT IN (
--   SELECT MIN(emp_id)
--   FROM Employee
--   GROUP BY emp_name, salary, dept_id
-- );

-- ============================================================================
-- Practice Topics
-- ============================================================================
-- 1. INNER JOIN
-- 2. LEFT JOIN
-- 3. RIGHT JOIN
-- 4. FULL OUTER JOIN
-- 5. SELF JOIN
-- 6. GROUP BY
-- 7. HAVING
-- 8. Subqueries
-- 9. EXISTS / NOT EXISTS
-- 10. ROW_NUMBER
-- 11. RANK
-- 12. DENSE_RANK
-- 13. LEAD / LAG
-- 14. CASE
-- 15. CTE (WITH)
-- 16. Window Functions
-- 17. Aggregate Functions
-- 18. Date Functions
-- 19. String Functions
-- 20. Common Interview Salary Problems
