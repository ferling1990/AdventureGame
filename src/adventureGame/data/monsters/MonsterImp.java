package adventureGame.data.monsters;

public class MonsterImp extends Monster {

    private int fireballpower = 5;
    private int MAX_COOLDOWN = 2;
    private int cooldown = 0;

    private int fireball() {
        return fireballpower;
    }

    @Override
    public int getAttackPower() {
        if (cooldown-- == 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown = MAX_COOLDOWN;
                return fireball();
            } else {
                return super.getAttackPower();
            }
        } else {
            return super.getAttackPower(); 
        }
    }

}
