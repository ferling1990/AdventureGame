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
        System.out.println("Which direction do you wish to go? (type n/e/s/w)");
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
        System.out.println("Goal is to reach the end of the maze. Read descriptions and type commands like n to move north or loot");
    }
    
}
