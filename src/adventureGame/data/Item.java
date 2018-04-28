// Item is an abstract class. This is the super class.

package adventureGame.data;

//Group 20

import adventureGame.logic.Player;


public abstract class Item {
    
    private boolean consumable;
    
    public Item (Boolean consumable) {
        this.consumable = consumable;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public abstract void use(Player player);
    
    @Override
    public abstract String toString();
    
}
