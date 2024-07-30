public class SingletonPatternExample {

    // Logger class that follows the Singleton design pattern
    public static class Logger {

        // The single instance of the Logger class
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            System.out.println("Logger instance created.");
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                // Synchronize to make the method thread-safe
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton implementation
    public static void main(String[] args) {
        // Obtain the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("This is a test message.");

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
