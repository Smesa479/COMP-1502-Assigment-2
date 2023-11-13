package model;

public class Puzzle extends Toy {
    private String puzzleType;

    // Constructor
    
    public Puzzle(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
        this.puzzleType = puzzleType;
    }

    // Getters and setters
//    public void setPuzzleType(String puzzleType) {
//        this.puzzleType = puzzleType;
//    }

    public String getPuzzleType() {
        return puzzleType;
    }

    // Override formatToyInfo method
    
    public String formatToyInfo() {
        String category = "Puzzle";
        String[] fields = {
                String.valueOf(getSerialNumber()),
                getToyName(),
                getBrand(),
                String.valueOf(getPrice()),
                String.valueOf(getAvailableCount()),
                String.valueOf(getAgeAppropriate()),
                puzzleType
        };
        return FormatToyInfo.format(category, fields);
    }
}

// Subclass representing a puzzle toy
//public class Puzzle extends Toy {
//    // Additional field specific to Puzzle
//    private String puzzleType;
//
//    // Constructors
//    public Puzzle(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
//        // Call the constructor of the superclass (Toy)
//        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
//        this.puzzleType = puzzleType;
//    }
//
//    // Getters
//    public String getPuzzleType() {
//        return puzzleType;
//    }
//
//    // Setters
//    public void setPuzzleType(String puzzleType) {
//        this.puzzleType = puzzleType;
//    }
//
//    // Other necessary methods
//    // TODO: Add other methods as needed
//    public String toString() {
//        return "Puzzle{" +
//                "serialNumber=" + getSerialNumber() +
//                ", toyName='" + getToyName() + '\'' +
//                ", brand='" + getBrand() + '\'' +
//                ", price=" + getPrice() +
//                ", availableCount=" + getAvailableCount() +
//                ", ageAppropriate=" + getAgeAppropriate() +
//                ", puzzleType='" + getPuzzleType() + '\'' +
//                '}';
//    }
//}
