package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fonte
 */
public class RoomTest {
    
     
     @Test
     public void testCreateRoomDark() {
     Room room = new Room("dark");
     Assert.assertEquals("dark", room.getFeelOfRoom());
     }
     
     @Test
     public void testCreateRoomWet() {
     Room room = new Room("wet");
     Assert.assertEquals("wet", room.getFeelOfRoom());
     }
     
     @Test
     public void testCreateRoomCorrdior() {
     Room room = new Room("corridor");
     Assert.assertEquals("corridor", room.getFeelOfRoom());
     }
     
     @Test
     public void testCreateRoomTorch() {
     Room room = new Room("torch");
     Assert.assertEquals("torch", room.getFeelOfRoom());
     }
     
     @Test
     public void testCreateRoomPotion() {
     Room room = new Room("potion");
     Assert.assertEquals("potion", room.getFeelOfRoom());
     }
     
         @Test
    public void testConectRoomWithNorthRoom() {
        Room start = new Room("Start");
        Room north = new Room("North");
        start.setNorth(north);
        assertEquals("North", start.getNorth().getFeelOfRoom());
        assertEquals("Start", north.getSouth().getFeelOfRoom());
    }

    @Test
    public void testConectRoomWithSouthRoom() {
        Room start = new Room("Start");
        Room south = new Room("South");
        start.setSouth(south);
        assertEquals("South", start.getSouth().getFeelOfRoom());
        assertEquals("Start", south.getNorth().getFeelOfRoom());
    }
    
    @Test
    public void testConectRoomWithEastRoom() {
        Room start = new Room("Start");
        Room east = new Room("East");
        start.setEast(east);
        assertEquals("East", start.getEast().getFeelOfRoom());
        assertEquals("Start", east.getWest().getFeelOfRoom());
    }
    
      @Test
    public void testConectRoomWithWestRoom() {
        Room start = new Room("Start");
        Room west = new Room("West");
        start.setWest(west);
        assertEquals("West", start.getWest().getFeelOfRoom());
        assertEquals("Start", west.getEast().getFeelOfRoom());
    }
}
