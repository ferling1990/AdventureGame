//This class creates the world through hardcoded data
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads

import adventureGame.data.Dungeon;
import adventureGame.data.HealthPot;
import adventureGame.data.Room;
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

    // Boring hardcoded data that makes the maze. The constructor for rooms accepts 4 integers and a string description.
    // The constructer asks for the 4 neighboring roomnumbers, -1 means there is no door. 
    // Room(north, east, south, west, String description)
    public void createWorld() {
        //main path
        String room0 = "This room is very cold, and has a very humid feel,\nthe room has a torch on one side of the walls. HP pot in corner";
        dungeon.addRoom(new Room(13, 1, -1, -1, room0, new HealthPot())); //Room 0, start
        String room1 = "The room's walls are very mossy, there's crates and\nother furniture, it looks like an old supply depot.";
        dungeon.addRoom(new Room(10, 2, -1, 0, room1)); //Room 1
        String room2 = "You now find yourself in a new room. This room is chilly,\nbut it feels a little warmer, than the last.";
        dungeon.addRoom(new Room(-1, 14, 3, 1, room2)); //Room 2
        String room3 = "This room's floor is wet, and slippery,\nthere's a Skull hanging above the door leading east.";
        dungeon.addRoom(new Room(2, 4, -1, -1, room3)); //Room 3
        String room4 = "This rooms floor is still wet, but this room is a corridor\nwith little to no light, the corridor is long and thin.";
        dungeon.addRoom(new Room(-1, 5, -1, 3, room4)); //Room 4
        String room5 = "Entering the room you find some crates.";
        dungeon.addRoom(new Room(6, -1, -1, 4, room5)); //Room 5
        String room6 = "This room is a corridor with water covering your feet, its cold.";
        dungeon.addRoom(new Room(7, -1, 5, -1, room6)); //Room 6
        String room7 = "This room is a corridor, the southern part\nis covered in water, while the northern part is dry.";
        dungeon.addRoom(new Room(8, -1, 6, -1, room7)); //Room 7
        String room8 = "This room has a torch on one of the walls,\nthis room looks like an old entrance, there's dynamite boxes,\nbut they are all covered in water, no use.";
        dungeon.addRoom(new Room(-1, -1, 7, 9, room8)); //Room 8
        String room9 = "This room has a very cold floor, there's little to no light,\nbut a skull is hanging above the west door.";
        dungeon.addRoom(new Room(99, 8, -1, 16, room9)); //Room 9, end if 99

        //loop, starts from room 0 and 1
        String room10 = "This room is very humid and cold. The east door\nis locked with a mysterious looking skull hanging above\nthe door frame, there's wind coming from beneath the door.";
        dungeon.addRoom(new Room(11, -1, 1, -1, room10)); //Room 10
        String room11 = "This room is nothing special, there is old clothe laying around.";
        dungeon.addRoom(new Room(-1, -1, 10, 12, room11)); //Room 11
        String room12 = "This room has a very humid feeling,\nand a torch is lit on one of the walls.";
        dungeon.addRoom(new Room(-1, 11, 13, -1, room12)); //Room 12
        String room13 = "This room is a long corridor, there\nis light at the end of the tunnel!";
        dungeon.addRoom(new Room(12, -1, 0, -1, room13)); //Room 13

        //dead-end, starts from room 2
        String room14 = "After walking into the room, you are\nfaced with a riddle, \"Skull oh skull\",\nwhat does it mean?";
        dungeon.addRoom(new Room(15, -1, -1, 2, room14)); //Room 14
        String room15 = "This room is very dark, and there is\nlittle to no light. In the corners\nof the room is various disgusting looking tools,\nand an iron maiden, there are old bloodstains in\nthe middle of the room, a torture chamber perhaps?";
        dungeon.addRoom(new Room(-1, -1, 14, -1, room15)); //Room 15

        //dead-end, starts from room 9
        String room16 = "This room has remains of an old forge,\nit's not working anymore.";
        dungeon.addRoom(new Room(-1, 9, 17, -1, room16)); //Room 16
        String room17 = "This room has a door with a spooky looking\nskull above the west door, there's wind coming from\nunderneath the door, there's a lock on it,\nbut its accessible from this side only.";
        dungeon.addRoom(new Room(16, -1, -1, 10, room17)); //Room 17, has "one-way" door to room10
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}
