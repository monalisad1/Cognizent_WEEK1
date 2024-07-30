// Define the Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
        // In a real application, add code to process credit card payment
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
        // In a real application, add code to process PayPal payment
    }
}

// Implement the Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");

        // Create payment context
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        
        // Execute payment using Credit Card
        System.out.println("Selecting Credit Card Payment:");
        paymentContext.executePayment(100.00);

        // Change strategy to PayPal
        paymentContext = new PaymentContext(payPalPayment);
        
        // Execute payment using PayPal
        System.out.println("\nSelecting PayPal Payment:");
        paymentContext.executePayment(200.00);
    }
}
