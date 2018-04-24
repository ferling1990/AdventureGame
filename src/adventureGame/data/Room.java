//Contains a description of room as well as pointers to neighboor rooms.

package adventureGame.data;

//Group 20

import adventureGame.data.monsters.Monster;
import exceptions.NoItemException;

//Lau, Mark, Jonatan og Mads

public class Room {

    private Room north, east, south, west;
    private String feelOfRoom, itemDescription, monsterDescription;
    private Item item;
    private Monster monster;
    private boolean isFinalRoom; // This should only be true for the room that wins you the game to enter.

    //Constructor with description, a null value on a direction means there is no door
    //so a room as standard has no doors when first instantiated.
    public Room(String feelOfRoom) {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.feelOfRoom = feelOfRoom;
        isFinalRoom = false;
        item = null;
        itemDescription = "";
        monster = null;
    }

    //Constructor with description and item, a null value on a direction means there is no door
    //so a room as standard has no doors when first instantiated.
    public Room(String feelOfRoom, Item item, String itemDescription) {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.feelOfRoom = feelOfRoom;
        this.item = item;
        this.itemDescription = itemDescription;
        isFinalRoom = false;
        monster = null;
    }

    public void setIsFinalRoom(boolean isFinalRoom) {
        this.isFinalRoom = isFinalRoom;
    }

    //Connects the north door to "other" room and changes the "other" rooms south to match the connection
    public void setNorth(Room other) {
        other.south = this;
        this.north = other;
    }

    public void setEast(Room other) {
        other.west = this;
        this.east = other;
    }

    public void setSouth(Room other) {
        other.north = this;
        this.south = other;
    }

    public void setWest(Room other) {
        other.east = this;
        this.west = other;
    }

    public String getFeelOfRoom() {
        return feelOfRoom;
    }

    public boolean getIsFinalRoom() {
        return isFinalRoom;
    }

    //if there is an item in the room it returns it. If there isn't 
    //it throws an exception.
    public Item getItem() throws NoItemException {
        if (item != null) {
            return item;
        }
        else {
            throw new NoItemException();
        }
    }

    //removes the item from the room. Should always be done after succesfully 
    //using the "getItem()" method.
    public void removeItem() {
        item = null;
        itemDescription = "";
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    //Method to add extra descriptions
    public void addStringToDescription(String description) {
        feelOfRoom += description;
        feelOfRoom += "\n";
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    
    public void removeMonster() {
        item = null;
        itemDescription = "";
    }
    
    

    //toString method adds a string for each door(if there is one) and adds with the description string feelOfRoom.
    @Override
    public String toString() {
        String viewOfRoom = feelOfRoom + "\n";
        if (north != null) {
            viewOfRoom += "There is a door North. ";
        }
        if (east != null) {
            viewOfRoom += "There is a door East. ";
        }
        if (south != null) {
            viewOfRoom += "There is a door South. ";
        }
        if (west != null) {
            viewOfRoom += "There is a door West. ";
        }
        viewOfRoom += itemDescription;
        return viewOfRoom;
    }

}
