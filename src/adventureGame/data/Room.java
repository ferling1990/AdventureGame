//Contains a description of room as well as info about neighboor rooms.
//We have chosen to keep the data of neighboor rooms as integers that
//matches those rooms index-position in the room arraylist
package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads
public class Room {

    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private String feelOfRoom;
    private Item item;
    private String itemDescription;
    private boolean isFinalRoom;

    //Constructor with description and all room info, a -1 value on a direction means there is no door
    public Room(String feelOfRoom) {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.feelOfRoom = feelOfRoom;
        isFinalRoom = false;
        item = null;
        itemDescription = "";
    }

    public Room(String feelOfRoom, Item item, String itemDescription) {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.feelOfRoom = feelOfRoom;
        this.item = item;
        this.itemDescription = itemDescription;
        isFinalRoom = false;
    }

    public void setIsFinalRoom(boolean isFinalRoom) {
        this.isFinalRoom = isFinalRoom;
    }

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

    public boolean getIsFinalRoom() {
        return isFinalRoom;
    }

    public Item getItem() throws NoItemException {
        if (item != null) {
            return item;
        }
        else {
            throw new NoItemException();
        }
    }

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
