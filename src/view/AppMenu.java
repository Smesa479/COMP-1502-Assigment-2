package view;

import java.util.Scanner;

// Class responsible for displaying the application menu
public class AppMenu {
    private Scanner input;

    // Constructor
    public AppMenu(Scanner input) {
        this.input = input;
    }

    // Display the main menu and get the user's choice
    public int mainMenu() {
        int option = -1;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.println("How can we help you?");
                System.out.println("(1) Search Inventory And Purchase Toy");
                System.out.println("(2) Add a New Toy");
                System.out.println("(3) Remove a Toy");
                System.out.println("(4) Save & Exit");
                System.out.print("Enter Option: ");
                option = input.nextInt();
                validInput = true; // Valid input; exit the loop
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Consume the invalid input
            }
        }
        return option;
    }

    // Display the submenu and get the user's choice
    public int subMenu() {
        System.out.println("Find Toys With: ");
        System.out.println("(1) Serial Number(SN)");
        System.out.println("(2) Toy Name");
        System.out.println("(3) Type");
        System.out.println("(4) Back To Main Menu");
        System.out.print("Enter Option: ");
        return input.nextInt();
    }

    // Close the Scanner
    public void closeScanner() {
        input.close();
    }
}
