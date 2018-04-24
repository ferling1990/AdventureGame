/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventureGame.data;

import adventureGame.logic.Player;

/**
 *
 * @author jonab
 */
public class Shield extends Item {
    
    private int defense = 20;
    private boolean equipped = false;

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    
    

    @Override
    public void use(Player player) {

        if (equipped) {
            return;
        }
        player.setDefense(defense);
        equipped = true;

    }

    @Override
    public String toString() {
        return "Shield";
    }

}
