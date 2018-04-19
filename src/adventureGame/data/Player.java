//Player class, most important info in player is the currentRoom.

package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private Room currentRoom;
    public ArrayList<Item> inventory;

    // Constructor
    public Player(String name, Room startRoom) {
        inventory = new ArrayList();
        this.name = name;
        this.health = 50;
        this.currentRoom = startRoom;
    }
    
    //Searches inventory for specific item, if it is there it is used.
    public void useItem(String itemName){
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).toString().equals(itemName)) {
                inventory.get(i).use(this);
                break;
            }
        }
    }
    
    //Checks if there is a door north with checkDirection(), moves to room north if there is.
    //Otherwise it throws an exception.
    public void goNorth() throws NoDoorException {
        if (checkForDoor("north")) {
            setCurrentRoom(getCurrentRoom().getNorth()); //set current room to the room north
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    //Otherwise it throws an exception.
    public void goEast() throws NoDoorException {
        if (checkForDoor("east")) {
            setCurrentRoom(getCurrentRoom().getEast()); //set current room to the room east
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    //Otherwise it throws an exception.
    public void goSouth() throws NoDoorException {
        if (checkForDoor("south")) {
            setCurrentRoom(getCurrentRoom().getSouth()); //set current room to the room south
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    //Otherwise it throws an exception.
    public void goWest() throws NoDoorException {
        if (checkForDoor("west")) {
            setCurrentRoom(getCurrentRoom().getWest()); //set current room to the room west
        } else {
            throw new NoDoorException();
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is null.
    private boolean checkForDoor(String direction) {
        switch (direction) {
            case "north":
                return getCurrentRoom().getNorth() != null;
            case "east":
                return getCurrentRoom().getEast() != null;
            case "south":
                return getCurrentRoom().getSouth() != null;
            case "west":
                return getCurrentRoom().getWest() != null;
            default:
                return false;
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
