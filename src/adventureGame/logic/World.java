//This class creates the world through hardcoded data
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads

import adventureGame.data.Dungeon;
import adventureGame.data.HealthPot;
import adventureGame.data.Room;
import adventureGame.data.monsters.*;
import java.util.Random;

public class World {

    private Dungeon dungeon;
    private Random rand;

    public World() {
        rand = new Random();
        dungeon = new Dungeon();
    }

    // Generates a random number between 0-3 that we change with the switch to
    // a corrosponding room number from the dungeon arraylist that we have allowed
    // to be startrooms.
    public int generateStartRoom() {
        int startRoomNumber = rand.nextInt(4);
        switch (startRoomNumber) {
            case 0:
                startRoomNumber = 0;
                break;
            case 1:
                startRoomNumber = 10;
                break;
            case 2:
                startRoomNumber = 12;
                break;
            case 3:
                startRoomNumber = 15;
                break;
            default:
                startRoomNumber = 0;
        }
        return startRoomNumber;
    }

    // Boring hardcoded data that makes the maze.
    public void createWorld() {
        //Creating all the rooms
        String room0Description = "This room is very cold, and has a very humid feel, the room has a torch on one side of the walls.";
        Room room0 = new Room(room0Description, new HealthPot(), "There is a healthpot in the corner."); //Room 0, start
        MonsterImp imp1 = new MonsterImp();
        room0.setMonster(imp1);
        
        String room1Description = "The room's walls are very mossy, there's crates and other furniture, it looks like an old supply depot.";
        Room room1 = new Room(room1Description); //Room 1
        
        String room2Description = "You now find yourself in a new room. This room is chilly, but it feels a little warmer, than the last.";
        Room room2 = new Room(room2Description); //Room 2

        String room3Description = "This room's floor is wet, and slippery, there's a Skull hanging above the door leading east.";
        Room room3 = new Room(room3Description); //Room 3
        
        String room4Description = "This rooms floor is still wet, but this room is a corridor with little to no light, the corridor is long and thin.";
        Room room4 = new Room(room4Description); //Room 4
        
        String room5Description= "Entering the room you find some crates.";
        Room room5 = new Room(room5Description); //Room 5
        
        String room6Description = "This room is a corridor with water covering your feet, its cold.";
        Room room6 = new Room(room6Description); //Room 6
        
        String room7Description = "This room is a corridor, the southern part is covered in water, while the northern part is dry.";
        Room room7 = new Room(room7Description); //Room 7
        
        String room8Description = "This room has a torch on one of the walls, this room looks like an old entrance,\nthere's dynamite boxes, but they are all covered in water, no use.";
        Room room8 = new Room(room8Description); //Room 8
        
        String room9Description = "This room has a very cold floor, there's little to no light, but a skull is hanging above the west door.";
        Room room9 = new Room(room9Description); //Room 9
        
        String roomEndDescription = "You won.";
        Room wonTheGame = new Room(roomEndDescription);
        wonTheGame.setIsFinalRoom(true);

        //loop, starts from room 0 and 1
        String room10Description = "This room is very humid and cold. The east door is locked with a mysterious looking\nskull hanging above the door frame, there's wind coming from beneath the door.";
        Room room10 = new Room(room10Description); //Room 10
        MonsterImp imp2 = new MonsterImp();
        room10.setMonster(imp2);
        
        String room11Description = "This room is nothing special, there is old clothe laying around.";
        Room room11 = new Room(room11Description);
        
        String room12Description = "This room has a very humid feeling, and a torch is lit on one of the walls.";
        Room room12 = new Room(room12Description); //Room 12
        MonsterImp imp3 = new MonsterImp();
        room12.setMonster(imp3);
                
        String room13Description = "This room is a long corridor, there is light at the end of the tunnel!";
        Room room13 = new Room(room13Description); //Room 13

        //dead-end, starts from room 2
        String room14Description = "After walking into the room, you are faced with a riddle, \"Skull oh skull\", what does it mean?";
        Room room14 = new Room(room14Description); //Room 14
        
        String room15Description= "This room is very dark, and there is little to no light. In the corners of the room is various disgusting looking tools,\nand an iron maiden, there are old bloodstains in the middle of the room, a torture chamber perhaps?";
        Room room15 = new Room(room15Description); //Room 15
        MonsterImp imp4 = new MonsterImp();
        room15.setMonster(imp4);

        //dead-end, starts from room 9
        String room16Description = "This room has remains of an old forge, it's not working anymore.";
        Room room16 = new Room(room16Description); //Room 16
        
        String room17Description = "This room has a door with a spooky looking skull above the west door, there's wind coming from\nunderneath the door, there's a lock on it, but its accessible from this side only.";
        Room room17 = new Room(room17Description); //Room 17, has "one-way" door to room10
    
        // Connect all the rooms
        room0.setNorth(room13);
        room0.setEast(room1);
        room1.setNorth(room10);
        room1.setEast(room2);
        room2.setSouth(room3);
        room2.setEast(room14);
        room3.setEast(room4);
        room4.setEast(room5);
        room5.setNorth(room6);
        room6.setNorth(room7);
        room7.setNorth(room8);
        room8.setWest(room9);
        room9.setNorth(wonTheGame);
        
        room9.setWest(room16);
        room16.setSouth(room17);
        //room17.setWest(room10);
        
        //room10.setEast(null);
        room10.setNorth(room11);
        room11.setWest(room12);
        room12.setSouth(room13);
        
        room14.setNorth(room15);
        
        
        //Add the rooms to the arraylist in dungeon.
        dungeon.addRoom(room0);
        dungeon.addRoom(room1);
        dungeon.addRoom(room2);
        dungeon.addRoom(room3);
        dungeon.addRoom(room4);
        dungeon.addRoom(room5);
        dungeon.addRoom(room6);
        dungeon.addRoom(room7);
        dungeon.addRoom(room8);
        dungeon.addRoom(room9);
        dungeon.addRoom(room10);
        dungeon.addRoom(room11);
        dungeon.addRoom(room12);
        dungeon.addRoom(room13);
        dungeon.addRoom(room14);
        dungeon.addRoom(room15);
        dungeon.addRoom(room16);
        dungeon.addRoom(room17);
        dungeon.addRoom(wonTheGame);
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}
