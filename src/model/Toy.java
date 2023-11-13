package model;
import model.FormatToyInfo;
public abstract class Toy {
    protected long serialNumber;
    protected String toyName;
    protected String brand;
    protected double price;
    protected int availableCount;
    protected int ageAppropriate;

    // Constructor
    public Toy(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate) {
        this.serialNumber = serialNumber;
        this.toyName = toyName;
        this.brand = brand;
        this.price = price;
        this.availableCount = availableCount;
        this.ageAppropriate = ageAppropriate;
    }
    

    // Getters and setters
//    public void setSerialNumber(long serialNumber) {
//        this.serialNumber = serialNumber;
//    }
//
//    public void setToyName(String toyName) {
//        this.toyName = toyName;
//    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public void setAgeAppropriate(int ageAppropriate) {
        this.ageAppropriate = ageAppropriate;
    }
    
    public long getSerialNumber() {
        return serialNumber;
    }

    public String getToyName() {
        return toyName;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public int getAgeAppropriate() {
        return ageAppropriate;
    }

    // Abstract method for formatting toy information
    public String formatToyInfo(String category) {
        String[] fields = {
                String.valueOf(serialNumber),
                toyName,
                brand,
                String.valueOf(price),
                String.valueOf(availableCount),
                String.valueOf(ageAppropriate)
        };
        return FormatToyInfo.format(category, fields);
    }

}

//package model;
//import controller.AppManager;
//// Base class representing a generic toy
//public abstract class Toy {
//    // Fields
//    private long serialNumber;        // Unique identifier for the toy
//    private String toyName;           // Name of the toy
//    private String brand;             // Brand of the toy
//    private double price;             // Price of the toy
//    private int availableCount;       // Number of available units in inventory
//    private int ageAppropriate;       // Age appropriateness of the toy
//
//    // Constructors
//    public Toy(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate) {
//        this.serialNumber = serialNumber;
//        this.toyName = toyName;
//        this.brand = brand;
//        this.price = price;
//        this.availableCount = availableCount;
//        this.ageAppropriate = ageAppropriate;
//    }
//
//    // Getters
//    public long getSerialNumber() {
//        return serialNumber;
//    }
//
//    public String getToyName() {
//        return toyName;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public int getAvailableCount() {
//        return availableCount;
//    }
//
//    public int getAgeAppropriate() {
//        return ageAppropriate;
//    }
//
//    // Setters
//    public void setSerialNumber(long serialNumber) {
//        this.serialNumber = serialNumber;
//    }
//
//    public void setToyName(String toyName) {
//        this.toyName = toyName;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setAvailableCount(int availableCount) {
//        this.availableCount = availableCount;
//    }
//
//    public void setAgeAppropriate(int ageAppropriate) {
//        this.ageAppropriate = ageAppropriate;
//    }
//
//    // Other necessary methods
//    // TODO: Add other methods as needed
//    public String toString() {
//        return "Toy{" +
//                "serialNumber=" + serialNumber +
//                ", toyName='" + toyName + '\'' +
//                ", brand='" + brand + '\'' +
//                ", price=" + price +
//                ", availableCount=" + availableCount +
//                ", ageAppropriate=" + ageAppropriate +
//                '}';
//    }
//    public abstract String formatToyInfo();
//    	
//    
//}
