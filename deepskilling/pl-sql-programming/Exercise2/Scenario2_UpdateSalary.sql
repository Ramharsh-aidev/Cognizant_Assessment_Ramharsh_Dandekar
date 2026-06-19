-- Scenario 2: Manage errors when updating employee salaries.
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_count NUMBER;
    employee_not_found EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE employee_id = p_employee_id;
    
    IF v_count = 0 THEN
        RAISE employee_not_found;
    END IF;
    
    UPDATE Employees
    SET salary = salary + (salary * p_percentage / 100)
    WHERE employee_id = p_employee_id;
    
    COMMIT;
EXCEPTION
    WHEN employee_not_found THEN
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Employee ID ' || p_employee_id || ' not found.');
        COMMIT;
    WHEN OTHERS THEN
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Unexpected error updating salary: ' || SQLERRM);
        COMMIT;
END UpdateSalary;
/
