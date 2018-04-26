package adventureGame.data;

import adventureGame.data.monsters.MonsterJeti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterJetiTest {      //Testne vil fejle dele af tiden, da der er random som bliver brugt, men dette er meningen

    @Test
    public void testMonsterBossStun() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterJeti MJ = new MonsterJeti();
            int actual = MJ.getAttackPower();
            if (actual == 1) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }

    @Test
    public void testMonsterBossNormalAttack() {
        int counter = 0;
        for(int i = 0; i < 10000; i++){
            MonsterJeti MJ = new MonsterJeti();
            int actual = MJ.getAttackPower();
            if(actual == 5) counter++;
        }
        System.out.println("counter: "+counter);
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }
}
