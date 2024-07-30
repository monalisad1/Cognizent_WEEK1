// Define the target interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee class for Payment Gateway A
class PaymentGatewayA {
    void makePaymentA(double amount) {
        System.out.println("Processing payment through Payment Gateway A: $" + amount);
    }
}

// Adaptee class for Payment Gateway B
class PaymentGatewayB {
    void pay(double amount) {
        System.out.println("Processing payment through Payment Gateway B: $" + amount);
    }
}

// Adapter class for Payment Gateway A
class PaymentGatewayAAdapter implements PaymentProcessor {
    private PaymentGatewayA gatewayA;

    public PaymentGatewayAAdapter(PaymentGatewayA gatewayA) {
        this.gatewayA = gatewayA;
    }

    @Override
    public void processPayment(double amount) {
        gatewayA.makePaymentA(amount);
    }
}

// Adapter class for Payment Gateway B
class PaymentGatewayBAdapter implements PaymentProcessor {
    private PaymentGatewayB gatewayB;

    public PaymentGatewayBAdapter(PaymentGatewayB gatewayB) {
        this.gatewayB = gatewayB;
    }

    @Override
    public void processPayment(double amount) {
        gatewayB.pay(amount);
    }
}

// Test class to demonstrate the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of the payment gateways
        PaymentGatewayA gatewayA = new PaymentGatewayA();
        PaymentGatewayB gatewayB = new PaymentGatewayB();

        // Create adapter instances for the payment gateways
        PaymentProcessor processorA = new PaymentGatewayAAdapter(gatewayA);
        PaymentProcessor processorB = new PaymentGatewayBAdapter(gatewayB);

        // Use the adapters to process payments
        System.out.println("Using Adapter for Payment Gateway A:");
        processorA.processPayment(150.0);

        System.out.println("\nUsing Adapter for Payment Gateway B:");
        processorB.processPayment(250.0);
    }
}
