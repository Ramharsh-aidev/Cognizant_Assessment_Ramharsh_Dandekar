CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (log_id, transaction_id, log_date, description)
    VALUES (AuditLog_SEQ.NEXTVAL, :NEW.transaction_id, SYSDATE, 'Transaction of ' || :NEW.amount || ' processed for account ' || :NEW.account_id);
END;
/
