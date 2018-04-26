package adventureGame.logic;

import adventureGame.data.monsters.*;
import exceptions.MonsterDeadException;
import exceptions.PlayerDeadException;

public class Combat {

    private boolean didSomeoneDie = false;
    public static final String RED = "\u001B[31m";

    public void combatController(Player player, Monster monster) throws PlayerDeadException {
        while (!didSomeoneDie) {
            try {
                playerAttack(player, monster);
                monsterAttack(player, monster);
                combatLog(player, monster);
            } catch (MonsterDeadException ex) {
                didSomeoneDie = true;
//              player.getCurrentRoom().setItem(monster.getItem);
                player.getCurrentRoom().removeMonster();
            }
        }
    }

    private void playerAttack(Player player, Monster monster) throws MonsterDeadException {
        int damage = player.getAttackPower();
        monster.loseHealth(damage);
    }

    private void monsterAttack(Player player, Monster monster) throws PlayerDeadException {
        int damage = monster.getAttackPower();
        player.loseHealth(damage);
    }

    private void combatLog(Player player, Monster monster) {
        System.out.println(RED + "the monster damaged you for " + monster.getAttackPower() + RED);
        System.out.println(RED + "your health: " + player.getHealth() + RED);
        System.out.println(RED + "you've damaged the monster for " + player.getAttackPower() + RED);
        System.out.println(RED + "monster health: " + monster.getHealth() + RED);
        if (monster.getHealth() == 0) {
            System.out.println(RED + "you've killed the monster!" + RED);
        }

    }
}
