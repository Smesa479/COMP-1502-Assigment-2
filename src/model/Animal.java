package model;


public class Animal extends Toy {
    private String material;
    private String size;

    // Constructor
    
    public Animal(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String material, String size) {
        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
        this.material = material;
        this.size = size;
    }
    
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//    public void setSize(String size) {
//        this.size = size;
//    }

    // Getters and setters
    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    // Override formatToyInfo method
    public String formatToyInfo() {
        String category = "Animal";
        String[] fields = {
                String.valueOf(getSerialNumber()),
                getToyName(),
                getBrand(),
                String.valueOf(getPrice()),
                String.valueOf(getAvailableCount()),
                String.valueOf(getAgeAppropriate()),
                material,
                size
        };
        return FormatToyInfo.format(category, fields);
    }
}

// Subclass representing an animal toy
//public class Animal extends Toy {
//    // Additional fields specific to Animal
//    private String material;
//    private String size;
//
//    // Constructors
//    public Animal(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String material, String size) {
//        // Call the constructor of the superclass (Toy)
//        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
//        this.material = material;
//        this.size = size;
//    }
//
//    // Getters
//    public String getMaterial() {
//        return material;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    // Setters
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    // Other necessary methods
//    // TODO: Add other methods as needed
//    public String toString() {
//        return "Animal{" +
//                "serialNumber=" + getSerialNumber() +
//                ", toyName='" + getToyName() + '\'' +
//                ", brand='" + getBrand() + '\'' +
//                ", price=" + getPrice() +
//                ", availableCount=" + getAvailableCount() +
//                ", ageAppropriate=" + getAgeAppropriate() +
//                ", material='" + getMaterial() + '\'' +
//                ", size='" + getSize() + '\'' +
//                '}';
//    }
//}
