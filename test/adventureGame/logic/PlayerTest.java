package adventureGame.data;

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
    
//        @Test
//    public void testGoNorth() {
//        Player player = new Player("player1", start);
//        boolean result = player.goNorth();
//        assertTrue(result);
//    }
//    
//    @Test
//    public void testGoEastWhenThereIsNoEastRoom() {
//        Player player = new Player(start);
//        boolean result = player.goEast();
//        assertFalse(result);
//    }
    
}
