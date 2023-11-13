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

/**
 * Class responsible for managing the application logic.
 */
public class AppManager {
    private final String FILE_PATH = "res/toys.txt";
    private AppMenu appMenu;
    private Toy toy;
    private Scanner scanner;
    
    /**
     * Constructor for the AppManager class.
     *
     * @param scanner The Scanner object for user input.
     */
    public AppManager(Scanner scanner) {
        this.appMenu = new AppMenu(scanner);
        this.scanner = scanner;
        
        launchApplication();
    }
    
    /**
     * Launches the main application loop.
     */
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
    /**
     * Searches for toys based on their type.
     */
    private void searchByType() {
        List<String> searchResults = new ArrayList<>();
        boolean returnToSearch = true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the type of toy to search for: ");
            String typeToSearch = input.nextLine().toLowerCase();

            String line;
            int resultIndex = 1;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 7) { // Assuming type is stored in the 7th field
                    String toyType = fields[6].toLowerCase();
                    if (toyType.contains(typeToSearch)) {
                        // Categorize the toy based on its serial number
                        long serialNumber = Long.parseLong(fields[0]);
                        String category = categorizeSerialNumber(serialNumber);

                        // Create the corresponding toy object based on its category
                        Toy toy = createToy(category, fields);

                        // Format the toy information using FormatToyInfo
                        String formattedInfo = FormatToyInfo.format(category, toy);
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
            } else {
                System.out.println("No toys found with the specified type.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to search for toys by type.");
        }
    }

    

    /**
     * Searches for toys based on their name.
     */
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
                        // Categorize the toy based on its serial number
                        String category = categorizeSerialNumber(serialNumber);

                        // Create the corresponding toy object based on its category
                        Toy toy = createToy(category, fields);

                        // Format the toy information using FormatToyInfo
                        String formattedInfo = FormatToyInfo.format(category, toy);
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
    /**
     * Searches for toys based on their serial number.
     */
    private void searchBySerialNumber() {
        List<String> searchResults = new ArrayList<>();
        boolean returnToSearch = true;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
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

                    String line;
                    int resultIndex = 1;

                    while ((line = reader.readLine()) != null) {
                        String[] fields = line.split(";");
                        if (fields.length >= 1) {
                            long currentSerialNumber = Long.parseLong(fields[0]);
                            if (currentSerialNumber == serialNumber) {
                                // Categorize the toy based on its serial number
                                String category = categorizeSerialNumber(serialNumber);

                                // Creating the corresponding toy object based on its category
                                Toy toy = createToy(category, fields);

                                // Format the toy information using FormatToyInfo
                                String formattedInfo = FormatToyInfo.format(category, toy);
                                searchResults.add("(" + resultIndex + ") " + formattedInfo);
                                System.out.println(searchResults.get(resultIndex - 1));
                                resultIndex++;
                            }
                        }
                    }

                    if (!searchResults.isEmpty()) {
                        searchResults.add("(" + resultIndex + ") Back to Main Menu");
                        System.out.println("(" + resultIndex + ") Back to Main Menu");

                        // Now, you can handle the user's selection for purchase or going back to the main menu
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
                    } else {
                        System.out.println("No such Toy in Inventory.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter exactly 10 digits.");
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to search for toys by serial number.");
        }
    }

    /**
     * Adds a new toy to the inventory.
     *
     * @return True if the toy is successfully added, false otherwise.
     */
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
            writer.write(serialnumber + ";" + toyname + ";" + brand + ";" + price + ";" + count + ";" + age + ";" + num_of_min_players + "-" + num_of_max_players + ";" + author);
            writer.close();
            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to add the toy to the inventory.");
        }
    }

    /**
     * Checks if a given serial number is unique in the inventory.
     *
     * @param serialNumber The serial number to check.
     * @return True if the serial number is unique, false if it already exists in the inventory.
     */
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
    
    
    /**
     * Removes a toy from the inventory based on its serial number.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void removeToy() {
        Scanner input = new Scanner(System.in);
        System.out.println("Removing a Toy");

        long serialNumberRemoval;

        // Keep prompting until a valid serial number is entered
        while (true) {
            System.out.print("Enter the Serial Number of the toy to remove: ");
            String serialInput = input.nextLine();

            // Validate that the input consists only of digits and has exactly 10 digits
            if (Pattern.matches("\\d{10}", serialInput)) {
                serialNumberRemoval = Long.parseLong(serialInput);
                break; // Exit the loop if a valid serial number is entered
            } else {
                System.out.println("Invalid input. Please enter a 10-digit serial number.");
            }
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            List<String> lines = new ArrayList<>();
            String line;
            boolean toyFound = false;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 2) {
                    long serialNumber = Long.parseLong(fields[0]);
                    if (serialNumber == serialNumberRemoval) {
                        // Display the details of the toy to be removed
                        toyFound = true;
                        String category = categorizeSerialNumber(serialNumber);
                        Toy toy = createToy(category, fields);
                        String formattedInfo = FormatToyInfo.format(category, toy);
                        System.out.println("This Item Found:");
                        System.out.println(formattedInfo);

                        // Confirm removal
                        System.out.print("Do you want to remove it (Y/N)? ");
                        char confirmation = input.next().charAt(0);
                        if (Character.toLowerCase(confirmation) == 'y') {
                            System.out.println("Item Removed!");
                        } else {
                            System.out.println("Removal Cancelled.");
                            return; // Exit the method if removal is cancelled
                        }
                    } else {
                        lines.add(line);
                    }
                }
            }

            reader.close();

            if (!toyFound) {
                System.out.println("No toy found with the specified serial number.");
                return; // Exit the method if the toy is not found
            }

            // Write the updated contents back to the file
            FileWriter writer = new FileWriter(FILE_PATH);
            for (String updatedLine : lines) {
                writer.write(updatedLine + System.lineSeparator());
            }
            writer.close();

            // Display a message and wait for Enter key press
            System.out.println("Press Enter to continue...");
            input.nextLine(); // Consume the newline character
            input.nextLine(); // Wait for Enter key press

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to remove the toy from the inventory.");
        }
    }




    /**
     * Categorizes a serial number into a toy category based on its first digit.
     *
     * @param serialNumber The serial number to categorize.
     * @return The category of the toy (e.g., "Figure", "Animal", "Puzzle", "BoardGame", or "Unknown").
     */
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
    
    /**
     * Creates a toy object based on the specified category and field values.
     *
     * @param category The category of the toy.
     * @param fields   The array of fields containing toy information.
     * @return A toy object representing the specified category, or null if the category is unknown.
     */
    private Toy createToy(String category, String[] fields) {
        switch (category.toLowerCase()) {
            case "boardgame":
                return createBoardGame(fields);
            case "figure":
                return createFigure(fields);
            case "animal":
                return createAnimal(fields);
            case "puzzle":
                return createPuzzle(fields);
            default:
                return null; // Handle unknown category
        }
    }
    
    /**
     * Creates a Puzzle object from the given array of fields.
     *
     * @param fields The array of fields containing puzzle information.
     * @return A Puzzle object with the specified information.
     */
	private Toy createPuzzle(String[] fields) {
		return new Puzzle(
                Long.parseLong(fields[0]),
                fields[1],
                fields[2],
                Double.parseDouble(fields[3]),
                Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]),
                fields[6]
        );
	}
	/**
	 * Creates an Animal object from the given array of fields.
	 *
	 * @param fields The array of fields containing animal information.
	 * @return An Animal object with the specified information.
	 */
	private Toy createAnimal(String[] fields) {
		return new Animal(
                Long.parseLong(fields[0]),
                fields[1],
                fields[2],
                Double.parseDouble(fields[3]),
                Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]),
                fields[6],
                fields[7]
        );
	}
	/**
	 * Creates a Figure object from the given array of fields.
	 *
	 * @param fields The array of fields containing figure information.
	 * @return A Figure object with the specified information.
	 */
	private Toy createFigure(String[] fields) {
		return new Figure(
                Long.parseLong(fields[0]),
                fields[1],
                fields[2],
                Double.parseDouble(fields[3]),
                Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]),
                fields[6]
        );
	}
	/**
	 * Creates a BoardGame object from the given array of fields.
	 *
	 * @param fields The array of fields containing board game information.
	 * @return A BoardGame object with the specified information.
	 */
	private Toy createBoardGame(String[] fields) {
		
		  return new BoardGame(
	                Long.parseLong(fields[0]),
	                fields[1],
	                fields[2],
	                Double.parseDouble(fields[3]),
	                Integer.parseInt(fields[4]),
	                Integer.parseInt(fields[5]),
	                fields[6],
	                fields[7]
	        );
	}




}
