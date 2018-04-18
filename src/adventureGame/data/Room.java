//Contains a description of room as well as info about neighboor rooms.
//We have chosen to keep the data of neighboor rooms as integers that
//matches those rooms index-position in the room arraylist

package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

public class Room {
    private int north;
    private int east;
    private int south;
    private int west;
    private String feelOfRoom;
    private Item item;

    //Constructor with description and all room info, a -1 value on a direction means there is no door
    public Room(int north, int east, int south, int west, String feelOfRoom) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.feelOfRoom = feelOfRoom;
    }
    
    public Room(int north, int east, int south, int west, String feelOfRoom, Item item) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.feelOfRoom = feelOfRoom;
        this.item = item;
    }
    

    //Constructor without description and all room info, a -1 value on a direction means there is no door
    public Room(int north, int east, int south, int west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        feelOfRoom = "";
    }
    
    public Item getItem() {
        return item;
    }
    
    public void removeItem() {
        item = null;
    }

    public int getNorth() {
        return north;
    }

    public int getEast() {
        return east;
    }

    public int getSouth() {
        return south;
    }

    public int getWest() {
        return west;
    }
    
    //Method to add extra descriptions
    public void addStringToDescription(String description){
        feelOfRoom += description;
        feelOfRoom += "\n";
    }

    //toString method adds a string for each door(if there is one) and adds with the description string feelOfRoom.
    @Override
    public String toString() {
        String viewOfRoom = feelOfRoom + "\n";
        if(north >= 0) {
            viewOfRoom += "There is a door North. ";
        }
        if(east >= 0) {
            viewOfRoom += "There is a door East. ";
        }
        if(south >= 0) {
            viewOfRoom += "There is a door South. ";
        }
        if(west >= 0) {
            viewOfRoom += "There is a door West. ";
        }
        return viewOfRoom;
    }
    
}
