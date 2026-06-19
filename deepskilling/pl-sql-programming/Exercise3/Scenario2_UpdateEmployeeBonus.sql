-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    
    COMMIT;
END UpdateEmployeeBonus;
/
