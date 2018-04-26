package adventureGame.data.monsters;

public class MonsterJeti extends Monster {

    private static final int HEALTH = 20;
    private static final int ATTACK_POWER = 5;

    private int stunPower = 1;
    private int MAX_COOLDOWN_stun = 5;
    private int cooldown_stun = 0;

    public MonsterJeti() {
        super(HEALTH, ATTACK_POWER);
    }

    private int stun() {
        return stunPower;
    }

    @Override
    public int getAttackPower() {
        if (cooldown_stun-- == 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown_stun = MAX_COOLDOWN_stun;
                return stun();                      //Add something to have player skip a turn, perhaps do "double" damage
            } else {
                return super.getAttackPower();          //Normal attack
            }
        } else {
            return super.getAttackPower();              //Normal attack, needs a last return, because if all lelse, fails, which it shouldn't come to such a point, it does this.

        }
    }
}