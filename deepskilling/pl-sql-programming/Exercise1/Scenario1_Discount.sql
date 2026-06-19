-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_customers IS
        SELECT customer_id, age FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.age > 60 THEN
            UPDATE Loans
            SET interest_rate = interest_rate - 1
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
