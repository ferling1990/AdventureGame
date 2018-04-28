package adventureGame.data.monsters;

public class MonsterBoss extends Monster {

    private static final int HEALTH = 50;
    private static final int ATTACK_POWER = 7;
    private static final int PLAYER_POINTS = 10;

    private int stunPower = 4;
    private int fireballpower = 10;
    private int MAX_COOLDOWN_stunPower = 5;
    private int MAX_COOLDOWN_FireballPower = 2;
    private int cooldown_fireball = 0;
    private int cooldown_stun = 0;

    public MonsterBoss() {
        super(HEALTH, ATTACK_POWER, PLAYER_POINTS);
    }

    private int stun() {
        return stunPower + ATTACK_POWER;
    }

    private int fireball() {
        return fireballpower;
    }

    @Override
    public int getAttackPower() {
        if (cooldown_stun-- <= 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown_stun = MAX_COOLDOWN_stunPower;
                return stun();                      //Add something to have player skip a turn, perhaps do "double" damage

            }
        }
        if (cooldown_fireball-- <= 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown_fireball = MAX_COOLDOWN_FireballPower;
                return fireball();
            }
        }
        return super.getAttackPower();                              //Normal attack
    }
}
