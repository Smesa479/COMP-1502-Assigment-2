package model;



public class Figure extends Toy {
    private String classification;

    public Figure(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String classification) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.classification = classification;
    }
    
    public String getClassification() {
    	return classification;
    }

    @Override
    public String toString() {
        return "Figure: " + name + " (Serial Number: " + serialNumber + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Classification: " + classification + ")";
    }
}


