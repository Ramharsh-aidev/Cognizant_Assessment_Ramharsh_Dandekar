-- Scenario 3: Ensure data integrity when adding a new customer.
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_age IN NUMBER,
    p_balance IN NUMBER
) IS
    customer_exists EXCEPTION;

PRAGMA EXCEPTION_INIT (customer_exists, -1);

BEGIN
    INSERT INTO Customers (customer_id, name, age, balance)
    VALUES (p_customer_id, p_name, p_age, p_balance);
    
    COMMIT;
EXCEPTION
    WHEN customer_exists THEN
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Customer ID ' || p_customer_id || ' already exists.');
        COMMIT;
    WHEN OTHERS THEN
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Unexpected error adding customer: ' || SQLERRM);
        COMMIT;
END AddNewCustomer;
;
/