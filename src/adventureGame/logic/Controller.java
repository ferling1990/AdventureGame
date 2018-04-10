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
                    if (checkDirection()) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth()); //set current room to the room north
                    }
                    break;
                case "e":
                    if (checkDirection()) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getEast());
                    }
                    break;
                case "s":
                    if (checkDirection()) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getSouth());
                    }
                    break;
                case "w":
                    if (checkDirection()) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getWest());
                    }
                    break;
                default:
            }

        } while (player.getCurrentRoom() != 99);
        ui.winningMessage();
    }

    public boolean checkDirection() {
        return player.getCurrentRoom() >= 0;
    }
}
