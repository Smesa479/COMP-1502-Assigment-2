package model;

public class Figure extends Toy {
    private String classification;

    // Constructor
    
    public Figure(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String classification) {
        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
        this.classification = classification;
    }

    // Getters and setters
//    public void setClassification(String classification) {
//        this.classification = classification;
//    }
    public String getClassification() {
        return classification;
    }

    // Override formatToyInfo method
    
    public String formatToyInfo() {
        String category = "Figure";
        String[] fields = {
                String.valueOf(getSerialNumber()),
                getToyName(),
                getBrand(),
                String.valueOf(getPrice()),
                String.valueOf(getAvailableCount()),
                String.valueOf(getAgeAppropriate()),
                classification
        };
        return FormatToyInfo.format(category, fields);
    }
}

//// Subclass representing a figure toy
//public class Figure extends Toy {
//    // Additional field specific to Figure
//    private String classification;
//
//    // Constructors
//    public Figure(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String classification) {
//        // Call the constructor of the superclass (Toy)
//        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
//        this.classification = classification;
//    }
//
//    // Getters
//    public String getClassification() {
//        return classification;
//    }
//
//    // Setters
//    public void setClassification(String classification) {
//        this.classification = classification;
//    }
//
//    // Other necessary methods
//    // TODO: Add other methods as needed
//    public String toString() {
//        return "Figure{" +
//                "serialNumber=" + getSerialNumber() +
//                ", toyName='" + getToyName() + '\'' +
//                ", brand='" + getBrand() + '\'' +
//                ", price=" + getPrice() +
//                ", availableCount=" + getAvailableCount() +
//                ", ageAppropriate=" + getAgeAppropriate() +
//                ", classification='" + getClassification() + '\'' +
//                '}';
//    }
//}
