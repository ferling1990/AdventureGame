package adventureGame.model;

public class Room {
    private int north;
    private int east;
    private int south;
    private int west;

    public Room(int north, int east, int south, int west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
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

    @Override
    public String toString() {
        String viewOfRoom = "";
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
