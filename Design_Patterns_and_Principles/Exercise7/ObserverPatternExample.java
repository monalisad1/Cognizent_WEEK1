import java.util.ArrayList;
import java.util.List;

// Define the Subject interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Implement the Concrete Subject class
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Define the Observer interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Implement Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App Notification: " + stockName + " stock price updated to $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App Notification: " + stockName + " stock price updated to $" + stockPrice);
    }
}

// Test class to demonstrate the Observer Pattern
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create the stock market (subject)
        StockMarket stockMarket = new StockMarket("TechCorp", 100.00);

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price
        System.out.println("Updating stock price to $120.00");
        stockMarket.setStockPrice(120.00);

        // Deregister one observer and update stock price
        stockMarket.deregisterObserver(mobileApp);
        System.out.println("\nUpdating stock price to $140.00");
        stockMarket.setStockPrice(140.00);
    }
}
