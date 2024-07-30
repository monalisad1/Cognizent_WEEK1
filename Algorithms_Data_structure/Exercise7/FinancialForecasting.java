// Define a class for financial forecasting
public class FinancialForecasting {

    // Recursive method to calculate the future value
    static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case: if years is 0, return the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: calculate the future value for the next year
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        // Example values
        double initialInvestment = 1000.0; // Initial investment amount
        double annualGrowthRate = 0.05;    // Annual growth rate (5%)
        int forecastYears = 10;            // Number of years to forecast

        // Calculate the future value using the recursive method
        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);

        // Display the result
        System.out.printf("Initial Investment: $%.2f\n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.2f%%\n", annualGrowthRate * 100);
        System.out.printf("Forecast Years: %d\n", forecastYears);
        System.out.printf("Future Value: $%.2f\n", futureValue);
    }
}
