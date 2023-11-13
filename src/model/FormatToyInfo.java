package model;

public class FormatToyInfo {
    public static String format(String category, String[] fields) {
        StringBuilder formattedInfo = new StringBuilder("Category: " + category + ", ");

        switch (category.toLowerCase()) {
            case "boardgame":
                formattedInfo.append("Serial Number: ").append(fields[0])
                        .append(", Name: ").append(fields[1])
                        .append(", Brand: ").append(fields[2])
                        .append(", Price: ").append(fields[3])
                        .append(", Available Count: ").append(fields[4])
                        .append(", Age Appropriate: ").append(fields[5])
                        .append(", Num Of Players: ").append(fields[6])
                        .append(", Author: ").append(fields[7]);
                break;
            case "figure":
                formattedInfo.append("Serial Number: ").append(fields[0])
                        .append(", Name: ").append(fields[1])
                        .append(", Brand: ").append(fields[2])
                        .append(", Price: ").append(fields[3])
                        .append(", Available Count: ").append(fields[4])
                        .append(", Age Appropriate: ").append(fields[5])
                        .append(", Classification: ").append(fields[6]);
                break;
            case "animal":
                formattedInfo.append("Serial Number: ").append(fields[0])
                        .append(", Name: ").append(fields[1])
                        .append(", Brand: ").append(fields[2])
                        .append(", Price: ").append(fields[3])
                        .append(", Available Count: ").append(fields[4])
                        .append(", Age Appropriate: ").append(fields[5])
                        .append(", Material: ").append(fields[6])
                        .append(", Size: ").append(fields[7]);
                break;
            case "puzzle":
                formattedInfo.append("Serial Number: ").append(fields[0])
                        .append(", Name: ").append(fields[1])
                        .append(", Brand: ").append(fields[2])
                        .append(", Price: ").append(fields[3])
                        .append(", Available Count: ").append(fields[4])
                        .append(", Age Appropriate: ").append(fields[5])
                        .append(", Puzzle Type: ").append(fields[6]);
                break;
            default:
                // Handle unknown category
                formattedInfo.append("Unknown category. Additional details not provided.");
                break;
        }

        return formattedInfo.toString();
    }
}
