// The main class demonstrating the Builder Pattern
public class BuilderPatternExample {

    // The Product class
    public static class Computer {
        // Attributes
        private final String CPU;
        private final int RAM;
        private final int storage;
        private final boolean hasGraphicsCard;
        private final boolean hasBluetooth;

        // Private constructor to be used by the Builder class
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasBluetooth = builder.hasBluetooth;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, Graphics Card=" + (hasGraphicsCard ? "Yes" : "No") + ", Bluetooth=" + (hasBluetooth ? "Yes" : "No") + "]";
        }

        // Static nested Builder class
        public static class Builder {
            // Required attributes
            private final String CPU;
            private final int RAM;

            // Optional attributes
            private int storage = 0;
            private boolean hasGraphicsCard = false;
            private boolean hasBluetooth = false;

            // Constructor for required attributes
            public Builder(String CPU, int RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            // Methods to set optional attributes
            public Builder setStorage(int storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean hasBluetooth) {
                this.hasBluetooth = hasBluetooth;
                return this;
            }

            // Build method to return an instance of Computer
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Test class
    public static void main(String[] args) {
        // Creating a Computer with minimum required attributes
        Computer basicComputer = new Computer.Builder("Intel i5", 8).build();
        System.out.println("Basic Computer:");
        System.out.println(basicComputer);

        // Creating a Computer with all attributes
        Computer advancedComputer = new Computer.Builder("AMD Ryzen 7", 16)
                .setStorage(512)
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        System.out.println("\nAdvanced Computer:");
        System.out.println(advancedComputer);
    }
}
