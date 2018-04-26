package adventureGame.data.monsters;

public class MonsterJeti extends Monster {

    private int stun = 6;
    private int MAX_COOLDOWN = 5;
    private int cooldown = 0;
    private int stun() {
        return stun;
    }

    @Override
    public int getAttackPower() {
        if (cooldown-- == 0) {                    //Cooldown sammenlignes med 0, derefter tælles der ned. (cooldown == 0, cooldown--)
            if (((int) (Math.random() * 100)) % 2 == 0) {
                cooldown = MAX_COOLDOWN;
                return stun();                      //Add something to have player skip a turn, perhaps do "double" damage
            } else {
                return super.getAttackPower();
            }
        } else {
            return super.getAttackPower(); 
        }
    }

}