// Define the subject interface
interface Image {
    void display();
}

// Implement the real subject class
class RealImage implements Image {
    private String fileName;

    // Constructor to load an image from a remote server
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + fileName);
        // Simulate loading time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Implement the proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);  // Lazy initialization
        }
        realImage.display();  // Display the image
    }
}

// Test class to demonstrate the use of ProxyImage
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded and displayed on the first access
        System.out.println("Accessing image1:");
        image1.display();
        System.out.println("\nAccessing image2:");
        image2.display();

        // Image will be displayed without loading again
        System.out.println("\nAccessing image1 again:");
        image1.display();
    }
}
