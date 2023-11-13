package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Animal;
import model.Toy;
import model.BoardGame;
import model.Puzzle;
import model.Figure;
import model.FormatToyInfo;
import view.AppMenu;

// Class responsible for managing the application logic
public class AppManager {
    private final String FILE_PATH = "res/toys.txt";
    private AppMenu appMenu;
    private Toy toy;
    private Scanner scanner;

    public AppManager(Scanner scanner) {
        this.appMenu = new AppMenu(scanner);
        this.scanner = scanner;
        
        launchApplication();
    }

    private void launchApplication() {
        boolean flag = true;
        int option;

        while (flag) {
            option = appMenu.mainMenu();
            switch (option) {
                case 1:
                    int choice = appMenu.subMenu();
                    switch (choice) {
                        case 1:
                            searchBySerialNumber();
                            break;
                        case 2:
                            searchByToyName();
                            break;
                        case 3:
                            searchByType();
                            break;
                        case 4:
                            // The user wants to go back to the main menu, no action needed here
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                case 2:
                    addToy();
                    break;
                case 3:
                    removeToy();
                    break;
                case 4:
                    System.out.println("Saving Data into Data Base...");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    private void searchByType() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the type of toy to search for: ");
        String typeToSearch = input.nextLine().toLowerCase();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<String> searchResults = new ArrayList<>();

            String line;
            int resultIndex = 1;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 7) { // Assuming type is stored in the 7th field
                    String toyType = fields[6].toLowerCase();
                    if (toyType.contains(typeToSearch)) {
                        String category = categorizeSerialNumber(Long.parseLong(fields[0]));
                        String formattedInfo = FormatToyInfo.format(category, fields);
                        searchResults.add("(" + resultIndex + ") " + formattedInfo);
                        System.out.println(searchResults.get(resultIndex - 1));
                        resultIndex++;
                    }
                }
            }

            reader.close();

            if (!searchResults.isEmpty()) {
                searchResults.add("(" + resultIndex + ") Back to Main Menu");
                System.out.println("(" + resultIndex + ") Back to Main Menu");

                // Now, you can handle the user's selection for purchase or going back to the main menu
                System.out.print("Enter Option Number to Purchase or Back to Main Menu: ");
                int userOption = input.nextInt();

                if (userOption >= 1 && userOption <= searchResults.size() - 1) {
                    System.out.println("The Transaction Successfully Terminated!");
                    // You can add purchase logic here
                    System.out.print("\nPress Enter to Continue...");
                    input.nextLine(); // Consume the newline character
                    input.nextLine(); // Wait for Enter key press
                    appMenu.subMenu();
                } else if (userOption == searchResults.size()) {
                    // User selected "Back to Main Menu"
                    // The user wants to go back to the main menu, no action needed here
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } else {
                System.out.println("No toys found with the specified type.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to search for toys by type.");
        }
    }
    


    private void searchByToyName() {
        List<String> searchResults = new ArrayList<>();
        boolean returnToSearch = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Toy Name: ");
            String userInput = input.nextLine().toLowerCase();

            String line;
            int resultIndex = 1;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 2) {
                    String name = fields[1].toLowerCase();
                    long serialNumber = Long.parseLong(fields[0]);
                    if (name.startsWith(userInput)) {
                        String category = categorizeSerialNumber(serialNumber);
                        String formattedInfo = FormatToyInfo.format(category, fields);
                        searchResults.add("(" + resultIndex + ") " + formattedInfo);
                        System.out.println(searchResults.get(resultIndex - 1));
                        resultIndex++;
                    }
                }
            }
            reader.close();
            searchResults.add("(" + resultIndex + ") Back to Main Menu");
            System.out.println("(" + resultIndex + ") Back to Main Menu");

            while (returnToSearch) {
                System.out.print("Enter Option Number to Purchase or Back to Main Menu: ");
                int userOption = input.nextInt();

                if (userOption >= 1 && userOption <= searchResults.size() - 1) {
                    System.out.println("The Transaction Successfully Terminated!");
                    // You can add purchase logic here
                    System.out.print("\nPress Enter to Continue...");
                    input.nextLine(); // Consume the newline character
                    input.nextLine(); // Wait for Enter key press
                    appMenu.subMenu();
                    returnToSearch = false;
                } else if (userOption == searchResults.size()) {
                    // User selected "Back to Main Menu"
                    returnToSearch = false;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to search for toys by name.");
        }
    }

    private void searchBySerialNumber() {
    	 Scanner input = new Scanner(System.in);

    	    // Prompt the user to enter a valid serial number
    	    String userInput;
    	    boolean isValidInput = false;

    	    while (!isValidInput) {
    	        System.out.print("Enter Serial Number (10 digits only): ");
    	        userInput = input.nextLine();

    	        // Validate that the input consists of exactly 10 digits
    	        if (Pattern.matches("\\d{10}", userInput)) {
    	            isValidInput = true;
    	            long serialNumber = Long.parseLong(userInput);

    	            List<String> searchResults = new ArrayList<>();
    	            try {
    	                BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
    	                
    	                String line;
    	                int resultIndex = 1;

    	                while ((line = reader.readLine()) != null) {
    	                    String[] fields = line.split(";");
    	                    if (fields.length >= 2) {
    	                        long currentSerialNumber = Long.parseLong(fields[0]);
    	                        if (currentSerialNumber == serialNumber) {
    	                            String category = categorizeSerialNumber(serialNumber);
    	                            String formattedInfo = FormatToyInfo.format(category, fields);
    	                            searchResults.add("(" + resultIndex + ") " + formattedInfo);
    	                            System.out.println(searchResults.get(resultIndex - 1));
    	                            resultIndex++;
    	                        }
    	                    }
    	                }

    	                reader.close();

    	                if (!searchResults.isEmpty()) {
    	                    searchResults.add("(" + resultIndex + ") Back to Main Menu");
    	                    System.out.println("(" + resultIndex + ") Back to Main Menu");

    	                    // Now, you can handle the user's selection for purchase or going back to the main menu
    	                    System.out.print("Enter Option Number to Purchase or Back to Main Menu: ");
    	                    int userOption = input.nextInt();

    	                    if (userOption >= 1 && userOption <= searchResults.size() - 1) {
    	                        System.out.println("The Transaction Successfully Terminated!");
    	                        // You can add purchase logic here
    	                        System.out.print("\nPress Enter to Continue...");
    	                        input.nextLine(); // Consume the newline character
    	                        input.nextLine(); // Wait for Enter key press
    	                        appMenu.subMenu();
    	                    } else if (userOption == searchResults.size()) {
    	                        // User selected "Back to Main Menu"
    	                        // The user wants to go back to the main menu, no action needed here
    	                    } else {
    	                        System.out.println("Invalid input. Please try again.");
    	                    }
    	                } else {
    	                    System.out.println("No such Toy in Inventory.");
    	                }
    	            } catch (IOException e) {
    	                e.printStackTrace();
    	                System.err.println("Failed to search for toys by serial number.");
    	            }
    	        } else {
    	            System.out.println("Invalid input. Please enter exactly 10 digits.");
    	        }
    	    }
    	
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter Serial Number: ");
//        long serialNumberToSearch = input.nextLong();
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split(";");
//                if (fields.length >= 1) {
//                    long serialNumber = Long.parseLong(fields[0]);
//                    if (serialNumber == serialNumberToSearch) {
//                        String category = categorizeSerialNumber(serialNumber);
//                        String formattedInfo = FormatToyInfo.format(category, fields);
//                        System.out.println("Toy found:\n" + formattedInfo);
//                        reader.close();
//                        return;
//                    }
//                }
//            }
//
//            System.out.println("No toy found with the specified serial number.");
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("Failed to search for toys by serial number.");
//        }
    }
    private void addToy() {
        Scanner input = new Scanner(System.in);

        // Input validation flags
        boolean validSerialNumber = false;
        boolean validSerialFormat = false;
        boolean validSerialLength = false;

        long serialnumber = 0;

        // Keep prompting until a valid serial number is entered
        while (!validSerialNumber) {
            // Prompt the user to enter a serial number
            System.out.print("Enter Serial Number: ");
            String serialInput = input.nextLine();

            // Validate that the input consists only of digits
            validSerialFormat = Pattern.matches("\\d+", serialInput);

            // Validate the length of the serial number
            validSerialLength = serialInput.length() == 10;

            if (validSerialFormat && validSerialLength) {
                // Convert the valid input to a long
                serialnumber = Long.parseLong(serialInput);

                // Check if the serial number already exists
                if (!isSerialNumberUnique(serialnumber)) {
                    System.out.println("A Toy With This Serial Number Already Exists! Try Again.");
                } else {
                    validSerialNumber = true;
                }
            } else {
                // Display appropriate error messages
                if (!validSerialFormat) {
                    System.out.println("The Serial Number should only contain digits! Try again.");
                }
                if (!validSerialLength) {
                    System.out.println("The Serial Number's length MUST be 10 digits! Try again.");
                }
            }
        }

        // Continue with the rest of your toy input logic...
        System.out.println("Enter Toy Name: ");
        String toyname = input.nextLine().toLowerCase();
        System.out.println("Enter Toy Brand: ");
        String brand = input.nextLine().toLowerCase();
        System.out.println("Enter Toy Price: ");
        double price = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Available Counts: ");
        int count = input.nextInt();
        input.nextLine();
        System.out.println("Enter Appropriate Age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Enter Minimum Number Of Players: ");
        int num_of_min_players = input.nextInt();
        input.nextLine();
        System.out.println("Enter Maximum Number Of Players: ");
        int num_of_max_players = input.nextInt();
        input.nextLine();
        System.out.print("Enter Designer Names (Use ',' to separate the names if there is more than one name): ");
        String author = input.nextLine().toLowerCase();

        // Continue with the rest of your file writing logic...
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(System.lineSeparator());
            writer.write(serialnumber + ";" + toyname + ";" + brand + ";" + price + ";" + count + ";" + age + ";" + num_of_min_players + ";" + num_of_max_players + ";" + author);
            writer.close();
            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to add the toy to the inventory.");
        }
    }


    private boolean isSerialNumberUnique(long serialNumber) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 1) {
                    long existingSerialNumber = Long.parseLong(fields[0]);
                    if (existingSerialNumber == serialNumber) {
                        reader.close();
                        return false; // Serial number already exists
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true; // Serial number is unique
    }


	private void removeToy() {
        // Implement toy removal logic here
        // You may want to read the file, display a list of toys, and ask the user which one to remove
        // Then, update the file without the removed toy
        // Make sure to handle potential exceptions

        System.out.println("Remove Toy functionality is not implemented yet.");
    }

    private void writeToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(toy.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to write toy to file.");
        }
    }

    private String categorizeSerialNumber(long serialNumber) {
        String category;

        int firstDigit = Integer.parseInt(String.valueOf(serialNumber).substring(0, 1));

        switch (firstDigit) {
            case 0:
            case 1:
                category = "Figure";
                break;
            case 2:
            case 3:
                category = "Animal";
                break;
            case 4:
            case 5:
            case 6:
                category = "Puzzle";
                break;
            case 7:
            case 8:
            case 9:
                category = "BoardGame";
                break;
            default:
                category = "Unknown";
                break;
        }

        return category;
    }




}
