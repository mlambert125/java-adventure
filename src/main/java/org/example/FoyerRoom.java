package org.example;

public class FoyerRoom extends Room {
    public FoyerRoom() {
        this.Name = "Foyer";
        this.Description = "You are standing in the foyer of a large mansion";
    }

    public boolean Enter() {
        super.Enter();
        return true;
    }

    public boolean ProcessCommand(String command) {
        return false;
    }
}
