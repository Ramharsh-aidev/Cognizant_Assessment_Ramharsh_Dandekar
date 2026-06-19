CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_loan_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_total_months NUMBER;
    v_installment NUMBER;
BEGIN
    v_monthly_rate := p_annual_interest_rate / 12 / 100;
    v_total_months := p_loan_duration_years * 12;
    
    IF v_monthly_rate = 0 THEN
        v_installment := p_loan_amount / v_total_months;
    ELSE
        v_installment := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months) / (POWER(1 + v_monthly_rate, v_total_months) - 1);
    END IF;
    
    RETURN ROUND(v_installment, 2);
END CalculateMonthlyInstallment;
/
