package adventureGame.data;

//Group 20
//Lau, Mark, Jonatan og Mads

import adventureGame.logic.Player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PlayerTest {
    
    Room start = new Room("Start");
    
        @Test
    public void testCreatePlayer() {
        Player player = new Player("player1", start);
        Room result = player.getCurrentRoom();
        assertEquals(start, player.getCurrentRoom());
    }
    
    @Test
    public void testGoNorth() throws NoDoorException {
        Room start = new Room("Start");
        Room east = new Room("north");
        start.setEast(east);
        Player player = new Player("player1", start);
        player.goEast();
        assertEquals("north", player.getCurrentRoom().getFeelOfRoom());
    }
    
@Test
    public void testGoEast() throws NoDoorException {
        Room start = new Room("Start");
        Room east = new Room("east");
        start.setEast(east);
        Player player = new Player("player1", start);
        player.goEast();
        assertEquals("east", player.getCurrentRoom().getFeelOfRoom());
    }
    
    @Test
    public void testGoSouth() throws NoDoorException {
        Room start = new Room("Start");
        Room east = new Room("south");
        start.setEast(east);
        Player player = new Player("player1", start);
        player.goEast();
        assertEquals("south", player.getCurrentRoom().getFeelOfRoom());
    }
    
    @Test
    public void testGoWest() throws NoDoorException {
        Room start = new Room("Start");
        Room east = new Room("west");
        start.setEast(east);
        Player player = new Player("player1", start);
        player.goEast();
        assertEquals("west", player.getCurrentRoom().getFeelOfRoom());
    }
    
    @Test (expected = NoDoorException.class)
    public void testGoEastWhenThereIsNoNorthRoom() throws NoDoorException {
        Player player = new Player("player1", start);
        player.goNorth();
    }
    
        @Test (expected = NoDoorException.class)
    public void testGoEastWhenThereIsNoEastRoom() throws NoDoorException {
        Player player = new Player("player1", start);
        player.goEast();
    }
    
        @Test (expected = NoDoorException.class)
    public void testGoEastWhenThereIsNoSouthRoom() throws NoDoorException {
        Player player = new Player("player1", start);
        player.goSouth();
    }
    
        @Test (expected = NoDoorException.class)
    public void testGoEastWhenThereIsNoWestRoom() throws NoDoorException {
        Player player = new Player("player1", start);
        player.goWest();
    }
    
}
