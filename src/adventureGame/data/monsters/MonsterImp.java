package adventureGame.data.monsters;

public class MonsterImp extends Monster {

    private static final int HEALTH = 10;
    private static final int ATTACK_POWER = 1;
    private static final int PLAYER_POINTS = 1;
    
    private int fireballpower = 5;
    private int MAX_COOLDOWN_fireball = 2;
    private int cooldown_fireball = 0;

    public MonsterImp() {
        super(HEALTH, ATTACK_POWER, PLAYER_POINTS);
    }

    private int fireball() {
        return fireballpower;
    }

    @Override
    public int getAttackPower() {
        if (cooldown_fireball-- <= 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown_fireball = MAX_COOLDOWN_fireball;
                return fireball();
            } else {
                return super.getAttackPower();          //Normal attack
            }
        } else {
            return super.getAttackPower();              //Normal attack, needs a last return, because if all lelse, fails, which it shouldn't come to such a point, it does this.

        }
    }

}
