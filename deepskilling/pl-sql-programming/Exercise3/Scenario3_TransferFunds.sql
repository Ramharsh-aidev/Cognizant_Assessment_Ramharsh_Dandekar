-- Scenario 3: Customers should be able to transfer funds between their accounts.
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_account_id FOR UPDATE;
    
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
