package application;

import controller.AppManager;

import java.util.Scanner;

// Class responsible for starting the application
public class AppDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            new AppManager(scanner);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred. Please check your input and try again.");
        } finally {
            scanner.close();
        }
    }
}
