package model;

public class BoardGame extends Toy {
    private int minOfPlayers;
    private int maxOfPlayers;
    private String author;
    
    
    // Constructor
    public BoardGame(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate, int numOfPlayers, String author) {
        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
        this.minOfPlayers = minOfPlayers;
        this.maxOfPlayers = maxOfPlayers;
        this.author = author;
    }

    // Getters and setters
//    public void setminOfPlayers(int minOfPlayers) {
//        this.minOfPlayers = minOfPlayers;
//    }
//    public void setmaxOfPlayers(int maxOfPlayers) {
//        this.maxOfPlayers = maxOfPlayers;
//    }
    public int getminOfPlayers() {
        return minOfPlayers;
    }
    public int getmaxOfPlayers() {
        return maxOfPlayers;
    }

    public String getAuthor() {
        return author;
    }

    // Override formatToyInfo method
//    @Override
//    public String formatToyInfo(String category, String[] fields) {
//        return String.format(
//            "Category: BoardGame, Serial Number: %s, Name: %s, Brand: %s, Price: %s, Available Count: %s, Age Appropriate: %s, Num Of Players: %s, Author: %s",
//            serialNumber, toyName, brand, price, availableCount, ageAppropriate, minOfPlayers, maxOfPlayers, author
//        );
//    }
    public String formatToyInfo() {
        String category = "BoardGame";
        String[] fields = {
                String.valueOf(getSerialNumber()),
                getToyName(),
                getBrand(),
                String.valueOf(getPrice()),
                String.valueOf(getAvailableCount()),
                String.valueOf(getAgeAppropriate()),
                String.valueOf(getminOfPlayers()),
                String.valueOf(getAuthor())
        };
        return FormatToyInfo.format(category, fields);
    }
}

// Subclass representing a board game toy
//public class BoardGame extends Toy {
//    // Additional fields specific to BoardGame
//    private int minNumOfPlayers;
//    private int maxNumOfPlayers;
//    private String designerNames;
//
//    // Constructors
//    public BoardGame(long serialNumber, String toyName, String brand, double price, int availableCount, int ageAppropriate,
//                     int minNumOfPlayers, int maxNumOfPlayers, String designerNames) {
//        // Call the constructor of the superclass (Toy)
//        super(serialNumber, toyName, brand, price, availableCount, ageAppropriate);
//        this.minNumOfPlayers = minNumOfPlayers;
//        this.maxNumOfPlayers = maxNumOfPlayers;
//        this.designerNames = designerNames;
//    }
//
//    // Getters
//    public int getMinNumOfPlayers() {
//        return minNumOfPlayers;
//    }
//
//    public int getMaxNumOfPlayers() {
//        return maxNumOfPlayers;
//    }
//
//    public String getDesignerNames() {
//        return designerNames;
//    }
//
//    // Setters
//    public void setMinNumOfPlayers(int minNumOfPlayers) {
//        this.minNumOfPlayers = minNumOfPlayers;
//    }
//
//    public void setMaxNumOfPlayers(int maxNumOfPlayers) {
//        this.maxNumOfPlayers = maxNumOfPlayers;
//    }
//
//    public void setDesignerNames(String designerNames) {
//        this.designerNames = designerNames;
//    }
//
//    // Other necessary methods
//    // TODO: Add other methods as needed
//    @Override
//    public String toString() {
//        return "BoardGame{" +
//                "serialNumber=" + getSerialNumber() +
//                ", toyName='" + getToyName() + '\'' +
//                ", brand='" + getBrand() + '\'' +
//                ", price=" + getPrice() +
//                ", availableCount=" + getAvailableCount() +
//                ", ageAppropriate=" + getAgeAppropriate() +
//                ", numOfMinPlayers=" + getMinNumOfPlayers() +
//                ", numOfMaxPlayers=" + getMaxNumOfPlayers() +
//                ", author='" + getDesignerNames() + '\'' +
//                '}';
//    }
//    
//    public String formatToyInfo() {
//        return String.format(
//            "Category: BoardGame, Serial Number: %s, Name: %s, Brand: %s, Price: %s, Available Count: %s, Age Appropriate: %s, Num Of Players: %s, Author: %s",
//            getSerialNumber(), getToyName(), getBrand(), getPrice(), getAvailableCount(), getAgeAppropriate(), getMinNumOfPlayers() , getMaxNumOfPlayers(),  getDesignerNames()
//        );
//    }
//}
