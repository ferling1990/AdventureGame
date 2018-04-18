//Main controller of the game, has the while loop that keeps the game running
//and instantiates most of the classes.
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads
import adventureGame.data.Dungeon;
//import adventureGame.data.Room;
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
        createWorld();
        createPlayer();
        //act = new Actions(dungeon, ui);
        ui.startMessage();
        //main loop that kees the game running till the end of maze is reached or player types quit.
        do {
            System.out.println("hp: " +player.getHealth());
            System.out.println(player.getCurrentRoom());

            // this if-statement adds the 3 messages to the startroom. We have 
            // decided to it this way, as previously mentioned our startroom is "random".
            if (turn == 1) {
                player.getCurrentRoom().addStringToDescription("\nUpon entering the room, you recognize it,");
                player.getCurrentRoom().addStringToDescription("you've been here before, you recognize the elevator,");
                player.getCurrentRoom().addStringToDescription("you are back where you started!");
            }
            playerAction(); //This is a switch that asks for player action with fitting cases.
            turn++; // counts the number of turns used.
        } while (!player.getCurrentRoom().getIsFinalRoom()); //game ends when current room == 99 (the end room).
        ui.winningMessage();
    }
    
    void createWorld() {
        world.createWorld();
        dungeon = world.getDungeon();
    }
    
    void createPlayer() {
        player = new Player("Player1", dungeon.rooms.get(world.generateStartRoom())); //generateStartRoom randomizes between 4 possible startrooms
    }

//    Method that asks the player for an action
//    and through the switch tries to do something
    public void playerAction() {
        boolean actCompleted = false;
        while(!actCompleted)  {
            String direction = ui.askDirection();
            switch (direction) {
                case "n":
                    actCompleted = goNorth(); //returns true if it was possible to go north
                    break;
                case "e":
                    actCompleted = goEast();
                    break;
                case "s":
                    actCompleted = goSouth();
                    break;
                case "w":
                    actCompleted = goWest();
                    break;
                case "loot":
                    player.inventory.add(player.getCurrentRoom().getItem());
                    player.getCurrentRoom().removeItem();
                    break;
                case "pot":
                    player.usePot();
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
    }

    //Checks if there is a door north with checkDirection(), moves to room north if there is.
    public boolean goNorth() {
        if (checkDirection(1)) {
            player.setCurrentRoom(player.getCurrentRoom().getNorth()); //set current room to the room north
            return true;
        } else {
            ui.noDoorMessage();
            return false;
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    public boolean goEast() {
        if (checkDirection(2)) {
            player.setCurrentRoom(player.getCurrentRoom().getEast()); //set current room to the room east
            return true;
        } else {
            ui.noDoorMessage();
            return false;
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    public boolean goSouth() {
        if (checkDirection(3)) {
            player.setCurrentRoom(player.getCurrentRoom().getSouth()); //set current room to the room south
            return true;
        } else {
            ui.noDoorMessage();
            return false;
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    public boolean goWest() {
        if (checkDirection(4)) {
            player.setCurrentRoom(player.getCurrentRoom().getWest()); //set current room to the room west
            return true;
        } else {
            ui.noDoorMessage();
            return false;
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is -1, so we check if the value is 0 or higher.
    //the values that are 0 or higher matches that room's index in the dungeon rooms arraylist.
    private boolean checkDirection(int direction) {
        switch (direction) {
            case 1:
                return player.getCurrentRoom().getNorth() != null;
            case 2:
                return player.getCurrentRoom().getEast() != null;
            case 3:
                return player.getCurrentRoom().getSouth() != null;
            case 4:
                return player.getCurrentRoom().getWest() != null;
            default:
                return false;
        }
    }

}
