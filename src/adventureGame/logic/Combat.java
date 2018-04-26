package adventureGame.logic;

import adventureGame.data.monsters.*;
import exceptions.MonsterDeadException;
import exceptions.PlayerDeadException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Combat {

    private boolean didSomeoneDie = false;
    private boolean nextTurn;
    public static final String RED = "\u001B[31m";

    public void combatController(Player player, Monster monster) throws PlayerDeadException {
        nextTurn = false;
        while (!nextTurn && !didSomeoneDie) {
            try {
                playerAttack(player, monster);
                monsterAttack(player, monster);
                combatLog(player, monster);
                nextTurn = true;
            } catch (MonsterDeadException ex) {
                didSomeoneDie = true;
//              player.getCurrentRoom().setItem(monster.getItem);
             player.getCurrentRoom().removeMonster();
            }
        }
    }

    private void playerAttack(Player player, Monster monster) throws MonsterDeadException {
        try {
            if (monster.getHealth() > 0) {
                int damage = player.getAttackPower();
                monster.setHealth(monster.getHealth() - damage);
            }
        } catch (Exception MDE) {
            throw MDE; //throw MonsterDeadException
        }
    }

    private void monsterAttack(Player player, Monster monster) throws PlayerDeadException {
        try {
            if (monster.getHealth() > 0) {
                int damage = monster.getAttackPower();
                player.setHealth(player.getHealth() - damage);
            }
            didSomeoneDie = true;
        } catch (Exception PDE) {
            throw PDE; //throw PlayerDeadException
        }

    }

    private void combatLog(Player player, Monster monster) {
        System.out.println(RED +"the monster damaged you for "+ monster.getAttackPower() + RED);
        System.out.println(RED + "your health: " + player.getHealth() + RED);
        System.out.println(RED +"you've damaged the monster for "+ player.getAttackPower() + RED);
        System.out.println(RED + "monster health: " + monster.getHealth() + RED);
        if(monster.getHealth() == 0){
            System.out.println(RED+"you've killed the monster!"+RED);
        }

    }
}
