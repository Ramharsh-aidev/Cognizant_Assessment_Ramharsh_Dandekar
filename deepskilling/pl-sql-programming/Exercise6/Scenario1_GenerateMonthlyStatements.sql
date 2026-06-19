DECLARE
    CURSOR c_transactions IS
        SELECT c.name, t.transaction_date, t.amount, t.transaction_type
        FROM Customers c
        JOIN Accounts a ON c.customer_id = a.customer_id
        JOIN Transactions t ON a.account_id = t.account_id
        WHERE EXTRACT(MONTH FROM t.transaction_date) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.transaction_date) = EXTRACT(YEAR FROM SYSDATE);
          
    v_current_customer VARCHAR2(100) := '';
BEGIN
    FOR t IN c_transactions LOOP
        IF v_current_customer != t.name THEN
            DBMS_OUTPUT.PUT_LINE('--- Statement for ' || t.name || ' ---');
            v_current_customer := t.name;
        END IF;
        DBMS_OUTPUT.PUT_LINE(t.transaction_date || ' | ' || t.transaction_type || ' | $' || t.amount);
    END LOOP;
END;
/
