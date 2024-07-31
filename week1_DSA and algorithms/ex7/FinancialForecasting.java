package financialForecasting;

public class FinancialForecasting {

    // Iterative method to calculate future value
    public static double predictFutureValueIteratively(double currentValue, double growthRate, int years) {
        double futureValue = currentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double currentValue = 10000; // Current value
        double growthRate = 0.05; // 5% growth rate
        int years = 5; // Predict 5 years into the future

        double futureValue = predictFutureValueIteratively(currentValue, growthRate, years);

        System.out.println("Predicted future value after " + years + " years: rs " + futureValue);
    }
}
