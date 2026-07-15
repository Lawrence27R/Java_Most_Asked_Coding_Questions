
-- =============================================================================
-- SQLInterviewQuestions.sql
-- Most Asked SQL Interview Questions
-- =============================================================================

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
--SUBSTRING(string, start_position, length) length of substring to return
--Extract the domain from an email
SELECT SUBSTRING(email, LOCATE('@', email) + 1)
FROM Users;

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

| Join                              | One-sentence explanation                                                                                                 |
| --------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **INNER JOIN**                    | Returns only the rows that have matching values in both tables.                                                          |
| **LEFT JOIN (LEFT OUTER JOIN)**   | Returns all rows from the left table and the matching rows from the right table; unmatched right-side values are `NULL`. |
| **RIGHT JOIN (RIGHT OUTER JOIN)** | Returns all rows from the right table and the matching rows from the left table; unmatched left-side values are `NULL`.  |
| **FULL JOIN (FULL OUTER JOIN)**   | Returns all rows from both tables, matching where possible and filling unmatched columns with `NULL`.                    |
| **CROSS JOIN**                    | Returns every possible combination of rows from both tables (Cartesian product).                                         |
| **SELF JOIN**                     | Joins a table with itself to compare or relate rows within the same table.                                               |

What is an Index?
An Index is a database object that improves the speed of data retrieval operations (SELECT) by creating a fast lookup structure.
Without Index
Suppose Employee table has 10 lakh records.
This is called a Full Table Scan.
Faster Searches
Faster Sorting
Most databases use a B-Tree (Balanced Tree) structure.
O(log n)
CREATE INDEX idx_employee_name
ON Employee(name);

What is Clustered Index?
A Clustered Index determines the physical order of data in the table.(stored on disk)
A clustered index physically sorts and stores the table's data according to the indexed column(s).
If no clustered index exists, the table is stored as a heap (no guaranteed physical order).
Only ONE Clustered Index per table
Because data can be physically sorted only one way.
Most databases automatically create a Clustered Index on the Primary Key.

PostgreSQL does not have true clustered indexes like SQL Server.
Instead, PostgreSQL has a CLUSTER command that reorders the table once based on an existing index.

What is Non-Clustered Index?
A non-clustered index is a separate structure that stores the indexed values and pointers to the corresponding table rows.
It speeds up searches without changing the physical order of the data.
Unlike a clustered index, a table can have multiple non-clustered indexes.
PostgreSQL indexes are non-clustered by default.

CREATE INDEX idx_name
ON Employee(name);
The table stays physically the same:
Follows the pointer to the actual row in the table.

What is Composite Index?
An index created on multiple columns.
CREATE INDEX idx_emp_dept
ON Employee(name, dept_id);