package org.example;

public class MansionDoorRoom extends Room {
    boolean matMoved;
    boolean keyTaken;
    boolean doorUnlocked;

    public MansionDoorRoom() {
        this.Name = "Mansion Door";
        this.Description = "You are standing outside of the mansion, there is a mat at your feet";
    }

    public boolean Enter() {
        super.Enter();
        if (matMoved) {
            System.out.println("The mat has been moved");

            if (!keyTaken) {
                System.out.println("There is a key under the mat");
            }
        }
        return true;
    }

    public boolean ProcessCommand(String command) {
        // handle the key thing
        if (command.equals("move mat")) {
            System.out.println("You move the mat, revealing a key!");
            matMoved = true;
            return true;
        }
        if (command.equals("take key")) {
            if (matMoved) {
                if (App.inventory.contains("key")) {
                    System.out.println("You've already taken the key");
                } else {
                    System.out.println("You take the key from the ground");
                    App.inventory.add("key");
                }
            } else {
                System.out.println("What key?");
            }

            return true;
        }

        if (command.equals("unlock door")) {
            System.out.println("You unlock the door");
            doorUnlocked = true;
            return true;
        }

        if (command.equals("open door")) {
            if (doorUnlocked) {
                System.out.println("You open the door and step into the foyer");
                App.currentRoom = App.foyerRoom;
                App.currentRoom.Enter();
            } else {
                System.out.println("The door is locked");
            }
            return true;
        }

        return false;
    }
}
