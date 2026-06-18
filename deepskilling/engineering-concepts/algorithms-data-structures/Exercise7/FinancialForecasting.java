public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }

        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);

        System.out.printf("Present Value: $%.2f\n", presentValue);
        System.out.printf("Growth Rate: %.2f%%\n", growthRate * 100);
        System.out.printf("Periods: %d\n", periods);
        System.out.printf("Predicted Future Value: $%.2f\n", futureValue);
    }
}
