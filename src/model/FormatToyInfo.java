package model;

/**
 * The FormatToyInfo class provides static methods to format information about different types of toys.
 */
public class FormatToyInfo {
	
	/**
     * Formats the information for a specific category of toy.
     *
     * @param category The category of the toy.
     * @param toy      The toy to format.
     * @return A formatted string containing information about the toy.
     */
    public static String format(String category, Toy toy) {

        switch (category.toLowerCase()) {
            case "boardgame":
                return formatBoardGame((BoardGame) toy);
            case "figure":
                return formatFigure((Figure) toy);
            case "animal":
                return formatAnimal((Animal) toy);
            case "puzzle":
                return formatPuzzle((Puzzle) toy);
            default:
                // Handle unknown category
                return "Unknown category. Additional details not provided.";
        }
    }
    
    /**
     * Formats the information for a BoardGame toy.
     *
     * @param toy The BoardGame toy to format.
     * @return A formatted string containing information about the BoardGame toy.
     */
    private static String formatBoardGame(BoardGame toy) {
        StringBuilder formattedInfo = new StringBuilder("Category: BoardGame, ");
        formattedInfo.append("Serial Number: ").append(toy.getSerialNumber())
                .append(", Name: ").append(toy.getName())
                .append(", Brand: ").append(toy.getBrand())
                .append(", Price: ").append(toy.getPrice())
                .append(", Available Count: ").append(toy.getAvailableCount())
                .append(", Age Appropriate: ").append(toy.getAgeAppropriate())
                .append(", Num of Players: ").append(toy.getNumOfPlayers())
                .append(", Author: ").append(toy.getAuthor());

        return formattedInfo.toString();
    }
    
    /**
     * Formats the information for a Figure toy.
     *
     * @param toy The Figure toy to format.
     * @return A formatted string containing information about the Figure toy.
     */
    private static String formatFigure(Figure toy) {
        StringBuilder formattedInfo = new StringBuilder("Category: Figure, ");
        formattedInfo.append("Serial Number: ").append(toy.getSerialNumber())
                .append(", Name: ").append(toy.getName())
                .append(", Brand: ").append(toy.getBrand())
                .append(", Price: ").append(toy.getPrice())
                .append(", Available Count: ").append(toy.getAvailableCount())
                .append(", Age Appropriate: ").append(toy.getAgeAppropriate())
                .append(", Classification: ").append(toy.getClassification());

        return formattedInfo.toString();
    }
    /**
     * Formats the information for an Animal toy.
     *
     * @param toy The Animal toy to format.
     * @return A formatted string containing information about the Animal toy.
     */
    private static String formatAnimal(Animal toy) {
        StringBuilder formattedInfo = new StringBuilder("Category: Animal, ");
        formattedInfo.append("Serial Number: ").append(toy.getSerialNumber())
                .append(", Name: ").append(toy.getName())
                .append(", Brand: ").append(toy.getBrand())
                .append(", Price: ").append(toy.getPrice())
                .append(", Available Count: ").append(toy.getAvailableCount())
                .append(", Age Appropriate: ").append(toy.getAgeAppropriate())
                .append(", Material: ").append(toy.getMaterial())
                .append(", Size: ").append(toy.getSize());

        return formattedInfo.toString();
    }
    /**
     * Formats the information for a Puzzle toy.
     *
     * @param toy The Puzzle toy to format.
     * @return A formatted string containing information about the Puzzle toy.
     */
    private static String formatPuzzle(Puzzle toy) {
        StringBuilder formattedInfo = new StringBuilder("Category: Puzzle, ");
        formattedInfo.append("Serial Number: ").append(toy.getSerialNumber())
                .append(", Name: ").append(toy.getName())
                .append(", Brand: ").append(toy.getBrand())
                .append(", Price: ").append(toy.getPrice())
                .append(", Available Count: ").append(toy.getAvailableCount())
                .append(", Age Appropriate: ").append(toy.getAgeAppropriate())
                .append(", Puzzle Type: ").append(toy.getPuzzleType());

        return formattedInfo.toString();
    }
}

