//TUI only scanner and system out print.

package adventureGame.view;

//Group 20
//Lau, Mark, Jonatan og Mads

import java.util.Scanner;

public class TUI implements UI{
    private Scanner sc;
    
    public TUI() {
        sc = new Scanner(System.in);
    }

    @Override
    public String askDirection() {
        System.out.println("What is your next action?");
        return sc.nextLine().toLowerCase();
    }

    @Override
    public void winningMessage() {
        System.out.println("You have won the game");
    }

    @Override
    public void deathMessage() {
        System.out.println("YOU ARE DEAD!");
    }

    @Override
    public void startMessage() {
        System.out.println("After waking up, you find yourself in a room with a ");
        System.out.println("very dim light coming from a torch on one side of the wall.");
        System.out.println("You scout the room, behind you is an elevator which isn't powered.");
        System.out.println("There's a note hanging on the elevator door, it reads:");
        System.out.println("\"Welcome.  This is the skull cavern, to prove your worth to the king, you must complete this trail.");
        System.out.println("You have to find the right door in this maze, and with that you will find your freedom.");
        System.out.println("The king has given you a compass, don't disappoint us!\"");
        System.out.println("Type 'help' to get help");
        
    }

    @Override
    public void invalidCommand() {
        System.out.println("Invalid command, try something else.");
    }

    @Override
    public void noDoorMessage() {
        System.out.println("You tried to walk through a wall. Ouch!");
    }
    
    @Override
    public void listOfCommands() {
        System.out.println("");
        System.out.println("Type 'n' to go north");
        System.out.println("Type 'e' to go east");
        System.out.println("Type 's' to go south");
        System.out.println("Type 'w' to go west");
        System.out.println("Type 'quit' to quit game");
        System.out.println("");
        // add loot, combat, etcetc
    }
    
}
