-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
DECLARE
    CURSOR c_loans IS
        SELECT l.loan_id, c.name, l.due_date 
        FROM Loans l
        JOIN Customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan.name || ', your loan ' || loan.loan_id || ' is due on ' || TO_CHAR(loan.due_date, 'YYYY-MM-DD'));
    END LOOP;
END;
/
