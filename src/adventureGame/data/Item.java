// Item is an abstract class. This is the super class.

package adventureGame.data;

//Group 20

import adventureGame.logic.Player;

//Lau, Mark, Jonatan og Mads

public abstract class Item {
      
    public abstract void use(Player player);
    
    @Override
    public abstract String toString();
    
}
