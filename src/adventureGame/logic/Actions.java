//Controller in charge of all player actions
//Fx. the switch, goNorth, loot etc

package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads

import adventureGame.data.Dungeon;
import adventureGame.data.Player;
import adventureGame.view.TUI;

public class Actions {

//    Method that asks the player for an action
//    and through the switch tries to do something
    public void playerAction(Player player, Dungeon dungeon, TUI ui) {
        String direction = ui.askDirection();
        switch (direction) {
            case "n":
                goNorth(player, dungeon, ui);
                break;
            case "e":
                goEast(player, dungeon, ui);
                break;
            case "s":
                goSouth(player, dungeon, ui);
                break;
            case "w":
                goWest(player, dungeon, ui);
                break;
            case "help":
                ui.listOfCommands();
                break;
            case "quit":
                System.out.println("GG");
                System.exit(0);
            default:
                ui.invalidCommand();
        }
    }

    //Checks if there is a door north with checkDirection(), moves to room north if there is.
    public void goNorth(Player player, Dungeon dungeon, TUI ui) {
        if (checkDirection(1, player, dungeon)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    public void goEast(Player player, Dungeon dungeon, TUI ui) {
        if (checkDirection(1, player, dungeon)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getEast()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    public void goSouth(Player player, Dungeon dungeon, TUI ui) {
        if (checkDirection(1, player, dungeon)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getSouth()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    public void goWest(Player player, Dungeon dungeon, TUI ui) {
        if (checkDirection(1, player, dungeon)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getWest()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is -1, so we check if the value is 0 or higher.
    //the values that are 0 or higher matches that room's index in the dungeon rooms arraylist.
    private boolean checkDirection(int direction, Player player, Dungeon dungeon) {
        switch (direction) {
            case 1:
                return dungeon.rooms.get(player.getCurrentRoom()).getNorth() >= 0;
            case 2:
                return dungeon.rooms.get(player.getCurrentRoom()).getEast() >= 0;
            case 3:
                return dungeon.rooms.get(player.getCurrentRoom()).getSouth() >= 0;
            case 4:
                return dungeon.rooms.get(player.getCurrentRoom()).getWest() >= 0;
            default:
                return false;
        }
    }
}
