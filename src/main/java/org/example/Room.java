package org.example;

public class Room {
    public String Name;
    public String Description;

    public boolean Enter() {
        System.out.println("----------------------------------------");
        System.out.println(Name);
        System.out.println("----------------------------------------");
        System.out.println(Description);
        return true;
    }

    public boolean ProcessCommand(String command) {
        return false;
    }
}
