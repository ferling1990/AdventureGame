package adventureGame.logic;

import adventureGame.data.monsters.*;
import adventureGame.data.Room;
import exceptions.PlayerDeadException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CombatTest {

    Player player;
    MonsterImp imp;
    MonsterJeti jeti;
    MonsterBoss boss;
    Combat combat;

    public CombatTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player("John", new Room("gg"));
        imp = new MonsterImp();
        jeti = new MonsterJeti();
        boss = new MonsterBoss();
        combat = new Combat();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCombatPlayerDeath() {
        try {
            combat.combatController(player, boss);
        } catch (PlayerDeadException ex) {
            Logger.getLogger(CombatTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }
}
