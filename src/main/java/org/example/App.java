package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static String playerName = "";
    public static List<String> inventory = new ArrayList<>();
    public static MansionDoorRoom mansionDoorRoom = new MansionDoorRoom();
    public static FoyerRoom foyerRoom = new FoyerRoom();
    public static Room currentRoom;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        playerName = input.nextLine();

        // Keep track of which room is current
        currentRoom = mansionDoorRoom;

        currentRoom.Enter();
        while(true) {
            System.out.println("> ");
            String command = input.nextLine();

            // Global command processing
            if (command.equals("quit")) {
                break;
            } else if (command.equals("inventory")) {
                System.out.println("You currently possess: ");
                for (String item : inventory) {
                    System.out.println("- " + item);
                }
            } else if (command.equals("look")) {
                System.out.println(currentRoom.Description);
            } else {
                if (!currentRoom.ProcessCommand(command)) {
                    System.out.println("Invalid command");
                }
            }
        }
    }
}
