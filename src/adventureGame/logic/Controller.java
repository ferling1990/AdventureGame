//Main controller of the game, has the while loop that keeps the game running
//and instantiates most of the classes.
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads
import adventureGame.data.Dungeon;
import adventureGame.data.NoItemException;
import adventureGame.data.Player;
import adventureGame.view.TUI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private Player player;
    private Dungeon dungeon;
    private World world;
    private TUI ui;
    private int turn;

    public Controller() {
        ui = new TUI();
        world = new World();
        turn = 1;
    }

    public void game() {
        createWorld();
        createPlayer();
        ui.startMessage();
        //main loop that kees the game running till the end of maze is reached or player types quit.
        do {
            ui.showPlayerHealth(player);
            ui.printRoomDescription(player.getCurrentRoom());
            addExtraDescriptionToStartRoom();
            
            action();
            turn++; // counts the number of turns used.
        } while (!player.getCurrentRoom().getIsFinalRoom()); //game ends when reaching the final room (the only one with getIsFinalRoom returns true)
        ui.winningMessage();
    }

    public void createWorld() {
        world.createWorld();
        dungeon = world.getDungeon();
    }

    public void createPlayer() {
        player = new Player("Player1", dungeon.rooms.get(world.generateStartRoom())); //generateStartRoom randomizes between 4 possible startrooms
    }

    // this if-statement adds the 3 messages to the startroom. We have 
    // decided to it this way, as previously mentioned our startroom is "random".
    public void addExtraDescriptionToStartRoom() {
        if (turn == 1) {
            player.getCurrentRoom().addStringToDescription("\nUpon entering the room, you recognize it,");
            player.getCurrentRoom().addStringToDescription("you've been here before, you recognize the elevator,");
            player.getCurrentRoom().addStringToDescription("you are back where you started!");
        }
    }

    public void action() {
        int count = 0;
        int maxTries = 3;
        while (count++ < maxTries) {
            String action = ui.askForAction();
            try {
                playerAction(action); //This is a switch that asks for player action with fitting cases.
                count = maxTries;
            } catch (IllegalArgumentException e) {
                ui.invalidCommand();
            } catch (NoDoorException ex) {
                ui.noDoorMessage();
            } catch (NoItemException ey) {
                ui.noLootMessage();
            }
        }
    }

//    Method that asks the player for an action
//    and through the switch tries to do something
    public void playerAction(String action) throws IllegalArgumentException, NoDoorException, NoItemException {
            switch (action) {
                case "n":
                    try {
                        goNorth();
                    }
                    catch (NoDoorException e) {
                        throw e;
                    }
                    break;
                case "e":
                    try {
                        goEast();
                    }
                    catch (NoDoorException e) {
                        throw e;
                    }
                    break;
                case "s":
                    try {
                        goSouth();
                    }
                    catch (NoDoorException e) {
                        throw e;
                    }
                    break;
                case "w":
                    try {
                        goWest();
                    }
                    catch (NoDoorException e) {
                        throw e;
                    }
                    break;
                case "loot":
                    try {
                        player.inventory.add(player.getCurrentRoom().getItem());
                        player.getCurrentRoom().removeItem();
                    }
                    catch (NoItemException e){
                        throw e;
                    }
                    break;
                case "pot":
                    player.useItem("HealthPot");
                    break;
                case "help":
                    ui.listOfCommands();
                    break;
                case "quit":
                    System.out.println("GG");
                    System.exit(0);
                default:
                    throw new IllegalArgumentException();
                //ui.invalidCommand();
            }
        //}
    }

    //Checks if there is a door north with checkDirection(), moves to room north if there is.
    public void goNorth() throws NoDoorException {
        if (checkForDoor("north")) {
            player.setCurrentRoom(player.getCurrentRoom().getNorth()); //set current room to the room north
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    public void goEast() throws NoDoorException {
        if (checkForDoor("east")) {
            player.setCurrentRoom(player.getCurrentRoom().getEast()); //set current room to the room east
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    public void goSouth() throws NoDoorException {
        if (checkForDoor("south")) {
            player.setCurrentRoom(player.getCurrentRoom().getSouth()); //set current room to the room south
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    public void goWest() throws NoDoorException {
        if (checkForDoor("west")) {
            player.setCurrentRoom(player.getCurrentRoom().getWest()); //set current room to the room west
        } else {
            throw new NoDoorException();
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is -1, so we check if the value is 0 or higher.
    //the values that are 0 or higher matches that room's index in the dungeon rooms arraylist.
    private boolean checkForDoor(String direction) {
        switch (direction) {
            case "north":
                return player.getCurrentRoom().getNorth() != null;
            case "east":
                return player.getCurrentRoom().getEast() != null;
            case "south":
                return player.getCurrentRoom().getSouth() != null;
            case "west":
                return player.getCurrentRoom().getWest() != null;
            default:
                return false;
        }
    }

}
