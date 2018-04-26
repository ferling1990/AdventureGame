//Health pot class, inherites from Item. This is a subclass.

package adventureGame.data;

//Group 20

import adventureGame.logic.Player;


public class HealthPot extends Item {

    //Max health for a player is 100, so if the players health is 80 or above 
    // it is set to 100, otherwise +20. After consumption it removes itself from
    // inventory list.
    @Override
    public void use(Player player) {
        if (player.getHealth() > 80) {
            player.setHealth(100);
        } else {
            player.setHealth(player.getHealth() + 20);
        }
        player.removeItem(this);
    }

    // This string is important, as it is used to search for different items in
    // in the players inventory.
    @Override
    public String toString() {
        return "HealthPot";
    }
    
    
}
