package adventureGame.logic;

import adventureGame.data.Dungeon;
import adventureGame.data.Room;
import adventureGame.data.Player;
import adventureGame.view.TUI;

public class Controller {

    private Player player;
    private Dungeon dungeon;
    private World world;
    private TUI ui;

    public Controller() {
        player = new Player("Player1");
        ui = new TUI();
        world = new World();
    }

    public void game() {
        world.createWorld();
        dungeon = world.getDungeon();
        ui.startMessage();
        do {
            System.out.println(dungeon.rooms.get(player.getCurrentRoom()));
            String direction = ui.askDirection();
            switch (direction) {
                case "n":
                    if (checkDirection(1)) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth()); //set current room to the room north
                    } else {
                        ui.noDoorMessage();
                    }
                    break;
                case "e":
                    if (checkDirection(2)) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getEast());
                    } else {
                        ui.noDoorMessage();
                    }
                    break;
                case "s":
                    if (checkDirection(3)) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getSouth());
                    } else {
                        ui.noDoorMessage();
                    }
                    break;
                case "w":
                    if (checkDirection(4)) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getWest());
                    } else {
                        ui.noDoorMessage();
                    }
                    break;
                case "help":
                    ui.listOfCommands();
                    break;
                default:
                    ui.invalidCommand();
            }

        } while (player.getCurrentRoom() != 99);
        ui.winningMessage();
    }

    public boolean checkDirection(int direction) {
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
