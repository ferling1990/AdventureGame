//Player class, most important info in player is the currentRoom.

package adventureGame.data;

//Group 20

import java.util.ArrayList;

//Lau, Mark, Jonatan og Mads

public class Player {
    private String name;
    private int health;
    private Room currentRoom;
    public ArrayList<Item> inventory;

    public Player(String name, Room startRoom) {
        inventory = new ArrayList();
        this.name = name;
        this.health = 50;
        this.currentRoom = startRoom;
    }
    
    public void useItem(String itemName){
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).toString().equals(itemName)) {
                inventory.get(i).use(this);
                break;
                //i = inventory.size() + 2;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }
    
}
