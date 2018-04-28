package adventureGame.data.monsters;

import adventureGame.data.Item;
import exceptions.MonsterDeadException;

public class Monster {
    private String name;
    private int health;
    private int attackPower;
    private int specialAttack;
    private Item item;
    private int playerPoints;
    
    public Monster(int health, int attackPower, int playerPoints) {
        this.health = health;
        this.attackPower = attackPower;
        this.playerPoints = playerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public void loseHealth(int damageTaken) throws MonsterDeadException {
        health -= damageTaken;
        if (health <= 0) {
            throw new MonsterDeadException();
        }
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
