package adventureGame.logic;

import adventureGame.model.*;
import adventureGame.view.TUI;

public class Controller {

    Player player;
    Dungeon dungeon;
    TUI ui;

    public Controller() {
        player = new Player("Player1");
        ui = new TUI();
    }

    public void startGame() {
        createWorld();
        do {
            System.out.println(dungeon.rooms.get(player.getCurrentRoom()));
            String direction = ui.askDirection();
            switch (direction) {
                case "n":
                    if (checkDirection()) {
                        player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth());
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
    }

    private boolean checkDirection() {
        return player.getCurrentRoom() >= 0;
    }

    private void createWorld() {
        dungeon = new Dungeon();
        dungeon.addRoom(new Room(-1, 1, -1, -1)); //Room 0, start
        dungeon.addRoom(new Room(-1, 2, -1, 0)); //Room 1
        dungeon.addRoom(new Room(-1, -1, 3, 1)); //Room 2
        dungeon.addRoom(new Room(2, 4, -1, -1)); //Room 3
        dungeon.addRoom(new Room(-1, 5, -1, 3)); //Room 4
        dungeon.addRoom(new Room(6, -1, -1, 4)); //Room 5
        dungeon.addRoom(new Room(7, -1, 5, -1)); //Room 6
        dungeon.addRoom(new Room(8, -1, 6, -1)); //Room 7
        dungeon.addRoom(new Room(-1, -1, 7, 9)); //Room 8
        dungeon.addRoom(new Room(99, 8, -1, -1)); //Room 9, end if 99
    }
}
