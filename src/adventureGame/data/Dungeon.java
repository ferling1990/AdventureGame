//Dungeon class, that contains a list of rooms.
//This is really only smart if we end up having to make more different dungeons.

package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

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
