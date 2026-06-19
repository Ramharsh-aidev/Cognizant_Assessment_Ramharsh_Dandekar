CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.transaction_type = 'Withdrawal' THEN
        SELECT balance INTO v_balance FROM Accounts WHERE account_id = :NEW.account_id;
        IF :NEW.amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal.');
        END IF;
    ELSIF :NEW.transaction_type = 'Deposit' THEN
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
