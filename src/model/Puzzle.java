package model;



public class Puzzle extends Toy {
    private String puzzleType;

    public Puzzle(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.puzzleType = puzzleType;
    }
    
    public String getPuzzleType() {
    	return puzzleType;
    }

    @Override
    public String toString() {
        return "Puzzle: " + name + " (Serial Number: " + serialNumber + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Puzzle Type: " + puzzleType + ")";
    }
}


