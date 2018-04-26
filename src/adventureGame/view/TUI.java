//TUI only scanner and system out print.

package adventureGame.view;

//Group 20
//Lau, Mark, Jonatan og Mads

import adventureGame.logic.Player;
import adventureGame.data.Room;
import adventureGame.logic.ActionType;
import java.util.Scanner;

public class TUI implements UI{
    private Scanner sc;
    
    public TUI() {
        sc = new Scanner(System.in);
    }

    @Override
    public String askForAction() {
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
        System.out.println("After waking up, you find yourself in a room with a very dim light coming from a torch");
        System.out.println("on one side of the wall. You scout the room, behind you is an elevator which isn't powered.");
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
        System.out.println("Type " +ActionType.north.toString() + " to go north");
        System.out.println("Type " +ActionType.east.toString() + " to go east");
        System.out.println("Type " +ActionType.south.toString() + " to go south");
        System.out.println("Type " +ActionType.west.toString() + " to go west");
        System.out.println("Type " +ActionType.loot.toString() + " to loot items");
        System.out.println("Type " +ActionType.pot.toString() + " to consume health potion");
        System.out.println("Type " +ActionType.attack.toString() + " to attack monster");
        System.out.println("Type " +ActionType.stats.toString() + " to see your stats");
        System.out.println("Type " +ActionType.quit.toString() + " to quit game");
        System.out.println("");
        // add loot, combat, etcetc
    }

    @Override
    public void printRoomDescription(Room room) {
        System.out.println(room); //Prints the room description
    }

    @Override
    public void noLootMessage() {
        System.out.println("There is nothing to loot in this room.");
    }

    @Override
    public void printStats(Player player) {
        System.out.println("Health: " +player.getHealth());
        System.out.println("Attackpower: " +player.getAttackPower());
        System.out.println("Defense: "+player.getDefense());
    }

    @Override
    public void noMonsterMessage() {
        System.out.println("Nothing to attack.");
    }

    @Override
    public void youCantRun() {
        System.out.println("You can't run away.");
    }
    
}
