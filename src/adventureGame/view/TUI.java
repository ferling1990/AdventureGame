/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventureGame.view;

import java.util.Scanner;

public class TUI implements UI{
    Scanner sc;
    
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
        System.out.println("Goal is to reach the end of the maze.");
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
        System.out.println("Type 'n' to go north");
        System.out.println("Type 'e' to go east");
        System.out.println("Type 's' to go south");
        System.out.println("Type 'w' to go west");
        // add loot, combat, etcetc
    }
    
}
