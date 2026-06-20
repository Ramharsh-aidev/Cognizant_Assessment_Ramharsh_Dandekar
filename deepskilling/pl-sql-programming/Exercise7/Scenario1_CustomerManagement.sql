CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id IN NUMBER, p_name IN VARCHAR2, p_dob IN DATE, p_balance IN NUMBER);
    PROCEDURE UpdateCustomer(p_id IN NUMBER, p_name IN VARCHAR2);
    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id IN NUMBER, p_name IN VARCHAR2, p_dob IN DATE, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) 
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    END AddCustomer;
    
    PROCEDURE UpdateCustomer(p_id IN NUMBER, p_name IN VARCHAR2) IS
    BEGIN
        UPDATE Customers 
        SET Name = p_name, LastModified = SYSDATE 
        WHERE CustomerID = p_id;
        COMMIT;
    END UpdateCustomer;
    
    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetCustomerBalance;
END CustomerManagement;
/
