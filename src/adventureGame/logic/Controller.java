//Main controller of the game, has the while loop that keeps the game running
//and instantiates most of the classes.
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads
import adventureGame.data.Dungeon;
import adventureGame.data.Room;
import adventureGame.data.Player;
import adventureGame.view.TUI;

public class Controller {

    private Player player;
    private Dungeon dungeon;
    private World world;
    private TUI ui;
    private int turn;
    //private Actions act;

    public Controller() {
        ui = new TUI();
        world = new World();
        turn = 1;
        //act = new Actions();
    }

    public void game() {
        player = new Player("Player1", world.generateStartRoom()); //generateStartRoom randomizes between 4 possible startrooms
        world.createWorld();
        //System.out.println(player.getCurrentRoom()); //test message to see the start room number
        dungeon = world.getDungeon();
        //act = new Actions(dungeon, ui);
        ui.startMessage();
        //main loop that kees the game running till the end of maze is reached or player types quit.
        do {
            System.out.println(dungeon.rooms.get(player.getCurrentRoom()));

            // this if-statement adds the 3 messages to the startroom. We have 
            // decided to it this way, as previously mentioned our startroom is "random".
            if (turn == 1) {
                dungeon.rooms.get(player.getCurrentRoom()).addStringToDescription("\nUpon entering the room, you recognize it,");
                dungeon.rooms.get(player.getCurrentRoom()).addStringToDescription("you've been here before, you recognize the elevator,");
                dungeon.rooms.get(player.getCurrentRoom()).addStringToDescription("you are back where you started!");
            }
            playerAction(); //This is a switch that asks for player action with fitting cases.
            turn++; // counts the number of turns used.
        } while (player.getCurrentRoom() != 99); //game ends when current room == 99 (the end room).
        ui.winningMessage();
    }

//    Method that asks the player for an action
//    and through the switch tries to do something
    public void playerAction() {
        String direction = ui.askDirection();
        switch (direction) {
            case "n":
                goNorth();
                break;
            case "e":
                goEast();
                break;
            case "s":
                goSouth();
                break;
            case "w":
                goWest();
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
    public void goNorth() {
        if (checkDirection(1)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getNorth()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    public void goEast() {
        if (checkDirection(2)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getEast()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    public void goSouth() {
        if (checkDirection(3)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getSouth()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    public void goWest() {
        if (checkDirection(4)) {
            player.setCurrentRoom(dungeon.rooms.get(player.getCurrentRoom()).getWest()); //set current room to the room north
        } else {
            ui.noDoorMessage();
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is -1, so we check if the value is 0 or higher.
    //the values that are 0 or higher matches that room's index in the dungeon rooms arraylist.
    private boolean checkDirection(int direction) {
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
