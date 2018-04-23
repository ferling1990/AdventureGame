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
public class Sword extends Item {

    Player player;
    int attackPower = 50;
    private boolean equipped = false;

    @Override
    public void use(Player player) {
        if (equipped) {
            return;
        }
        player.setAttackPower(attackPower);
        equipped = true;
    }

    @Override
    public String toString() {
        return "Sword";
    }


}
