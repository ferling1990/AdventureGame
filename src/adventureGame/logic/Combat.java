package adventureGame.logic;

import exceptions.NoMonsterException;
import adventureGame.data.monsters.*;
import exceptions.MonsterDeadException;
import exceptions.PlayerDeadException;

public class Combat {

    private static final String RED = "\u001B[31m";

    private int damage1;
    private int damage2;

    public void combatController(Player player, Monster monster) throws PlayerDeadException, NoMonsterException {
        if (monster == null) {
            throw new NoMonsterException();
        }
        try {
            playerAttack(player, monster);
            monsterAttack(player, monster);
            combatLog(player, monster);
        } catch (MonsterDeadException ex) {
            combatLog(player, monster);
            player.setInCombat(false);
            player.getCurrentRoom().setItem(monster.getItem());
            player.getCurrentRoom().removeMonster();
        }
    }

    private void playerAttack(Player player, Monster monster) throws MonsterDeadException {
        damage1 = player.getAttackPower();
        monster.loseHealth(damage1);
    }

    private void monsterAttack(Player player, Monster monster) throws PlayerDeadException {
        damage2 = monster.getAttackPower();
        player.loseHealth(damage2);
    }

    private void combatLog(Player player, Monster monster) {
        System.out.println(RED + "the monster damaged you for " + damage2 + RED);
        System.out.println(RED + "your health: " + player.getHealth() + RED);
        System.out.println(RED + "you've damaged the monster for " + damage1 + RED);
        System.out.println(RED + "monster health: " + monster.getHealth() + RED);
        if (monster.getHealth() <= 0) {
            System.out.println(RED + "you've killed the monster!" + RED);
        }

    }

}
