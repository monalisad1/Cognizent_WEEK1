// Define the component interface
interface Notifier {
    void send(String message);
}

// Implement the concrete component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Abstract decorator class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete decorator for SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // Call the original notifier
        sendSMS(message);     // Add additional functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Concrete decorator for Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);     // Call the original notifier
        sendSlackMessage(message); // Add additional functionality
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

// Test class to demonstrate the Decorator Pattern
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        
        // Decorate with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Decorate with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        
        // Send notifications using the decorated notifier
        System.out.println("Sending notifications with multiple channels:");
        slackNotifier.send("Hello, this is a test message!");
    }
}
