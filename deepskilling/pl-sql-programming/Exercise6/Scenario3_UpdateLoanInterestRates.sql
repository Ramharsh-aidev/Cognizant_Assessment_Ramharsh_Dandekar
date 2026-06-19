DECLARE
    CURSOR c_loans IS
        SELECT loan_id, interest_rate FROM Loans;
BEGIN
    FOR loan IN c_loans LOOP
        UPDATE Loans
        SET interest_rate = interest_rate + 0.5
        WHERE loan_id = loan.loan_id;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('All loan interest rates have been updated based on the new policy.');
END;
/
