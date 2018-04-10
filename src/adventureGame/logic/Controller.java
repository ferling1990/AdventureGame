package adventureGame.logic;

import adventureGame.data.Dungeon;
import adventureGame.data.Room;
import adventureGame.data.Player;
import adventureGame.view.TUI;
import java.util.Random;


public class Controller {

    private Player player;
    private Dungeon dungeon;
    private World world;
    private TUI ui;
    private Random rand;
    

    public Controller() {
        ui = new TUI();
        world = new World();
        rand = new Random();
    }
    
    public int generateStartRoom(){
        int startRoomNumber = rand.nextInt(4);
        switch(startRoomNumber){
            case 0: startRoomNumber = 0; break;
            case 1: startRoomNumber = 10; break;
            case 2: startRoomNumber = 12; break;
            case 3: startRoomNumber = 15; break;
            default: startRoomNumber = 0;
        }
        return startRoomNumber;
    }

    public void game() {
        player = new Player("Player1", generateStartRoom());
        world.createWorld();
        System.out.println(player.getCurrentRoom());
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
