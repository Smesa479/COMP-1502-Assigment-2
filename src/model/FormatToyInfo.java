

package model;

public class FormatToyInfo {
    public static String format(String category, Toy toy) {
        // ... other code

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

//public class FormatToyInfo {
//    public static String format(String category, String[] fields) {
//        StringBuilder formattedInfo = new StringBuilder("Category: " + category + ", ");
//
//        switch (category.toLowerCase()) {
//            case "boardgame":
//                formattedInfo.append("Serial Number: ").append(fields[0])
//                        .append(", Name: ").append(fields[1])
//                        .append(", Brand: ").append(fields[2])
//                        .append(", Price: ").append(fields[3])
//                        .append(", Available Count: ").append(fields[4])
//                        .append(", Age Appropriate: ").append(fields[5])
//                        .append(", Num Of Players: ").append(fields[6])
//                        .append(", Author: ").append(fields[7]);
//                break;
//            case "figure":
//                formattedInfo.append("Serial Number: ").append(fields[0])
//                        .append(", Name: ").append(fields[1])
//                        .append(", Brand: ").append(fields[2])
//                        .append(", Price: ").append(fields[3])
//                        .append(", Available Count: ").append(fields[4])
//                        .append(", Age Appropriate: ").append(fields[5])
//                        .append(", Classification: ").append(fields[6]);
//                break;
//            case "animal":
//                formattedInfo.append("Serial Number: ").append(fields[0])
//                        .append(", Name: ").append(fields[1])
//                        .append(", Brand: ").append(fields[2])
//                        .append(", Price: ").append(fields[3])
//                        .append(", Available Count: ").append(fields[4])
//                        .append(", Age Appropriate: ").append(fields[5])
//                        .append(", Material: ").append(fields[6])
//                        .append(", Size: ").append(fields[7]);
//                break;
//            case "puzzle":
//                formattedInfo.append("Serial Number: ").append(fields[0])
//                        .append(", Name: ").append(fields[1])
//                        .append(", Brand: ").append(fields[2])
//                        .append(", Price: ").append(fields[3])
//                        .append(", Available Count: ").append(fields[4])
//                        .append(", Age Appropriate: ").append(fields[5])
//                        .append(", Puzzle Type: ").append(fields[6]);
//                break;
//            default:
//                // Handle unknown category
//                formattedInfo.append("Unknown category. Additional details not provided.");
//                break;
//        }
//
//        return formattedInfo.toString();
//    }
//
//	
//}
