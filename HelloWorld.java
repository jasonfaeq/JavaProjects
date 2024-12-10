package helloworld;

import java.util.Scanner; // For Scanner
import java.io.FileWriter; // File Writer
import java.io.IOException; // Error Handling
import java.time.LocalTime; // For Current Time

public class HelloWorld {

    public static void main(String[] args) {
        // Call the menu method to start the program
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in); // Create a single Scanner object
        while (true) {
            System.out.println("\n=== Greeting Menu ===");
            System.out.println("1. Classic Hello, World!");
            System.out.println("2. Greet Based on Time");
            System.out.println("3. Multi-Language Greeting");
            System.out.println("4. Styled Greeting");
            System.out.println("5. Loop Greetings");
            System.out.println("6. Write Greeting to File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Parse the input as an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue; // Go back to the menu
            }

            // Call the corresponding method based on the user's choice
            switch (choice) {
                case 1 -> classicHelloWorld();
                case 2 -> greetWithTime(scanner); // Pass Scanner as an argument
                case 3 -> multiLanguageGreeting(scanner); // Pass Scanner as an argument
                case 4 -> greetWithStyle(scanner); // Pass Scanner as an argument
                case 5 -> loopGreetings(scanner); // Pass Scanner as an argument
                case 6 -> writeGreetingToFile(scanner); // Pass Scanner as an argument
                case 7 -> {
                    System.out.println("Goodbye!");
                    scanner.close(); // Close the scanner before exiting
                    return; // Exit the menu loop
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    public static void classicHelloWorld() {
        System.out.println("Hello, World!");
    }

    public static void greetWithTime(Scanner scanner) {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        String greeting;
        if (hour < 12) {
            greeting = "Good Morning";
        } else if (hour < 18) {
            greeting = "Good Afternoon";
        } else {
            greeting = "Good Evening";
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println(greeting + ", " + name + "!");
    }

    public static void multiLanguageGreeting(Scanner scanner) {
        System.out.println("Choose a language:");
        System.out.println("1. English");
        System.out.println("2. German");
        System.out.println("3. French");
        System.out.print("Enter your choice (1-3): ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine()); // Parse the input as an integer
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to English.");
            choice = 1; // Default to English if invalid input
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1 -> System.out.println("Hello, " + name + "!");
            case 2 -> System.out.println("Guten Tag, " + name + "!");
            case 3 -> System.out.println("Bonjour, " + name + "!");
            default -> System.out.println("Invalid choice. Hello, " + name + "!");
        }
    }

    public static void greetWithStyle(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        String greeting = "Hello, " + name + "!";
        String border = "*".repeat(greeting.length() + 4);

        System.out.println(border);
        System.out.println("* " + greeting + " *");
        System.out.println(border);
    }

    public static void loopGreetings(Scanner scanner) {
        while (true) {
            System.out.print("Enter your name (or type 'exit' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Hello, " + name + "!");
        }
        System.out.println("Goodbye!");
    }

    public static void writeGreetingToFile(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String greeting = "Hello, " + name + "!";

        try (FileWriter writer = new FileWriter("greeting.txt")) {
            writer.write(greeting);
            System.out.println("Greeting saved to greeting.txt!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
