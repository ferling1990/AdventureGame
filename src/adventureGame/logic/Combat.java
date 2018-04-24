package adventureGame.logic;

import adventureGame.data.monsters.*;
import exceptions.MonsterDeadException;
import exceptions.PlayerDeadException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Combat {
    private boolean didSomeoneDie = false;
    
    public void combatController(Player player, Monster monster) throws PlayerDeadException{
        while (!didSomeoneDie) {
            try {
                playerAttack(player, monster);
                monsterAttack(player, monster);
            } catch (MonsterDeadException ex) {
                didSomeoneDie = true;
//                player.getCurrentRoom().setItem(monster.getItem);
//                player.getCurrentRoom().removeMonster();
            }
        }
    }

    private void playerAttack(Player player, Monster monster) throws MonsterDeadException {
        monster.loseHealth(player.getAttackPower());
    }

    private void monsterAttack(Player player, Monster monster) throws PlayerDeadException {
        player.loseHealth(monster.getAttackPower());
    }
}
