package adventureGame.data.monsters;

public class Monster {
    private String name;
    private int health;
    private int attackPower;
    private int specialAttack;
    
    public Monster() {
        this.health = 10;
        this.attackPower = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int AttackPower) {
        this.attackPower = AttackPower;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }
    
    
    
}
