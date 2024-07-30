// The main class that demonstrates the Factory Method Pattern
public class FactoryMethodPatternExample {

    // Abstract Product class
    public interface Document {
        void open();
    }

    // Concrete Products
    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Abstract Creator class
    public abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete Creators
    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Test class
    public static void main(String[] args) {
        // Factory instances
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Creating documents using factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Opening documents
        wordDoc.open();
        pdfDoc.open();
        excelDoc.open();
    }
}
