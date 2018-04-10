package adventureGame.logic;

import adventureGame.data.Dungeon;
import adventureGame.data.Room;

public class World {
    private Dungeon dungeon;
    
    public void createWorld() {
        dungeon = new Dungeon();
        dungeon.addRoom(new Room(13, 1, -1, -1)); //Room 0, start
        dungeon.addRoom(new Room(10, 2, -1, 0)); //Room 1
        dungeon.addRoom(new Room(-1, 14, 3, 1)); //Room 2
        dungeon.addRoom(new Room(2, 4, -1, -1)); //Room 3
        dungeon.addRoom(new Room(-1, 5, -1, 3)); //Room 4
        dungeon.addRoom(new Room(6, -1, -1, 4)); //Room 5
        dungeon.addRoom(new Room(7, -1, 5, -1)); //Room 6
        dungeon.addRoom(new Room(8, -1, 6, -1)); //Room 7
        dungeon.addRoom(new Room(-1, -1, 7, 9)); //Room 8
        dungeon.addRoom(new Room(99, 8, -1, 16)); //Room 9, end if 99
        
        //loop, starts from room 0 and 1
        dungeon.addRoom(new Room(11, -1, 1, -1)); //Room 10
        dungeon.addRoom(new Room(-1, -1, 10, 12)); //Room 11
        dungeon.addRoom(new Room(-1, 11, 13, -1)); //Room 12
        dungeon.addRoom(new Room(12, -1, 0, -1)); //Room 13
        
        //dead-end, starts from room 2
        dungeon.addRoom(new Room(15, -1, -1, 2)); //Room 14
        dungeon.addRoom(new Room(-1, -1, 14, -1)); //Room 15
        
        //dead-end, starts from room 9
        dungeon.addRoom(new Room(-1, 9, 17, -1)); //Room 16
        dungeon.addRoom(new Room(16, -1, -1, 10)); //Room 17, has "one-way" door to room10
    }
    public Dungeon getDungeon(){
        return dungeon;
    }
}
