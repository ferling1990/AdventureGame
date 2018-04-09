package adventureGame.model;

import java.util.ArrayList;

public class Dungeon {
    public ArrayList<Room> rooms;

    public Dungeon() {
        rooms = new ArrayList();
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    
}
