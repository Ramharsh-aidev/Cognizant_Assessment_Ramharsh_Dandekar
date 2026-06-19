-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';
    
    COMMIT;
END ProcessMonthlyInterest;
/
