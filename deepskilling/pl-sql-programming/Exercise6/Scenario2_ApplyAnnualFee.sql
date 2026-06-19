DECLARE
    CURSOR c_accounts IS
        SELECT account_id, balance FROM Accounts;
    v_fee NUMBER := 50.00;
BEGIN
    FOR acc IN c_accounts LOOP
        UPDATE Accounts
        SET balance = balance - v_fee
        WHERE account_id = acc.account_id;
        
        DBMS_OUTPUT.PUT_LINE('Applied annual fee to account ' || acc.account_id);
    END LOOP;
    COMMIT;
END;
/
