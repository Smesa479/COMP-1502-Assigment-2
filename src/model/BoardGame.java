package model;


public class BoardGame extends Toy {
	private int minNumOfPlayers;
    private int maxNumOfPlayers;
    private String numOfPlayers;
    private String author;

    public BoardGame(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate,  String numOfPlayers, String author) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.minNumOfPlayers = minNumOfPlayers;
        this.maxNumOfPlayers = maxNumOfPlayers;
        this.numOfPlayers = numOfPlayers;
        this.author = author;
    }
    
    public void setNumOfPlayers(String numOfPlayers) {
    	this.numOfPlayers = numOfPlayers;
    }
    public String getNumOfPlayers() {
    	return numOfPlayers;
    }
    public void setMinNumOfPlayers(int minNumOfPlayers) {
    	this.minNumOfPlayers = minNumOfPlayers;
    }
    public int getMinNumOfPlayers() {
    	return minNumOfPlayers;
    }
    
    public void setMaxNumOfPlayers(int maxNumOfPlayers) {
    	this.maxNumOfPlayers = maxNumOfPlayers;
    }
    public int getMaxNumOfPlayers() {
    	return maxNumOfPlayers;
    }
    
    public void setAuthor(String author) {
      this.author = author;
    }
    public String getAuthor() {
      return author;
    }
//    public void setSerialNumber(long size) {
//        this.serialNumber = serialNumber;
//    }
//    
//    public long getserialNumber() {
//        return serialNumber;
//    }

    @Override
    public String toString() {
        return "Board Game: " + name + " (Serial Number: " + serialNumber + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Min of Players: " +  ", Min of Players: " + ", Author: " + author + ")";
    }
}


