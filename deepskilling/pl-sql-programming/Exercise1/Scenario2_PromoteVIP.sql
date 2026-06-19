-- Scenario 2: A customer can be promoted to VIP status based on their balance.
DECLARE
    CURSOR c_customers IS
        SELECT customer_id, balance FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
