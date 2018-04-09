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
        return sc.nextLine();
    }
    
}
