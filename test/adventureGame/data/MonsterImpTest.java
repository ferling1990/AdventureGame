package adventureGame.data;

import adventureGame.data.monsters.MonsterImp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterImpTest {       //Testne vil fejle dele af tiden, da der er random som bliver brugt, men dette er meningen
    
    @Test
    public void testMonsterImpFireball() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterImp MI = new MonsterImp();
            int actual = MI.getAttackPower();
            if (actual == 5) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }

    @Test
    public void testMonsterImpNormalAttack() {
        int counter = 0;
        for (int i = 0; i < 10000; i++) {
            MonsterImp MI = new MonsterImp();
            int actual = MI.getAttackPower();
            if (actual == 1) {
                counter++;
            }
        }
        System.out.println("counter: " + counter);
        assertTrue(counter > 4950);
        assertTrue(counter < 5050);
    }
}
