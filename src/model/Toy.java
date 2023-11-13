package model;
import model.FormatToyInfo;
import controller.AppManager;



public abstract class Toy {
    protected long serialNumber;
    protected String name;
    protected String brand;
    protected double price;
    protected int availableCount;
    protected int ageAppropriate;

    public Toy(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.availableCount = availableCount;
        this.ageAppropriate = ageAppropriate;
    }
    public void setSerialNumber(long size) {
        this.serialNumber = serialNumber;
    }
    
    public long getSerialNumber() {
        return serialNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    public String getBrand() {
    	return brand;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
    
    public int getAvailableCount() {
        return availableCount;
    }
    
    public void setAgeAppropriate(int ageAppropriate) {
        this.ageAppropriate = ageAppropriate;
    }
    
    public int getAgeAppropriate() {
        return ageAppropriate;
    }

    // Abstract method to be implemented by subclasses
    public abstract String toString();
}

