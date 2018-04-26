package adventureGame.data;

import adventureGame.data.monsters.MonsterBoss;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterBossTest {      //Testne vil fejle dele af tiden, da der er random som bliver brugt, men dette er meningen

    @Test
    public void testMonsterBossStun() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterBoss MB = new MonsterBoss();
            int actual = MB.getAttackPower();
            if (actual == 4) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }

    @Test
    public void testMonsterBossFireball() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterBoss MB = new MonsterBoss();
            int actual = MB.getAttackPower();
            if (actual == 10) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 2400);
        assertTrue(counter < 2600);
    }

    @Test
    public void testMonsterBossNormalAttack() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterBoss MB = new MonsterBoss();
            int actual = MB.getAttackPower();
            if (actual == 7) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 2400);
        assertTrue(counter < 2600);
    }
}
