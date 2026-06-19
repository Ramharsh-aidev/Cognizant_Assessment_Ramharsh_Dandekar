-- Scenario 1: Handle exceptions during fund transfers between accounts.
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SAVEPOINT before_transfer;
    
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_account_id FOR UPDATE;
    
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK TO before_transfer;
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Insufficient funds for transfer from account ' || p_from_account_id);
        COMMIT;
    WHEN OTHERS THEN
        ROLLBACK TO before_transfer;
        INSERT INTO ErrorLogs (log_date, error_message) VALUES (SYSDATE, 'Unexpected error: ' || SQLERRM);
        COMMIT;
END SafeTransferFunds;
/
