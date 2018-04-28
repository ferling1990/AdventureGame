//Main controller of the game, has the while loop that keeps the game running
//and instantiates most of the classes.
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads
import exceptions.*;
import adventureGame.data.*;
import exceptions.NoItemException;
import adventureGame.view.TUI;

public class Controller {

    private Player player;
    private Dungeon dungeon;
    private World world;
    private TUI ui;
    private int turn;
    private Combat combat;
    private boolean hasRoomChanged;
    private Highscores hs;                                  //Highscore initieres

    public Controller() {
        ui = new TUI();
        world = new World();
        turn = 1;
        hasRoomChanged = false;
    }

    public void game() {
        createWorld();
        createPlayer();
        loadHighscore();
        ui.startMessage();
        //main loop that kees the game running till the end of maze is reached or player types quit.
        do {
            //ui.showPlayerHealth(player);
            ui.printRoomDescription(player.getCurrentRoom());
            addExtraDescriptionToStartRoom();

            checkForCombat();
            action();
            turn++; // counts the number of turns used.
        } while (!player.getCurrentRoom().getIsFinalRoom()); //game ends when reaching the final room (the only one with getIsFinalRoom returns true)
        updateHighcore();
        ui.printHighscore(hs.printHighscore());
        ui.winningMessage();
    }

    public void createWorld() {
        world.createWorld();
        dungeon = world.getDungeon();
    }

    public void createPlayer() {
        String name = ui.askForAction("What is your name?");
        player = new Player(name, dungeon.rooms.get(world.generateStartRoom())); //generateStartRoom randomizes between 4 possible startrooms
    }

    // this if-statement adds the 3 messages to the startroom. We have 
    // decided to do it this way, as previously mentioned our startroom is "random".
    public void addExtraDescriptionToStartRoom() {
        if (turn == 1) {
            player.getCurrentRoom().addStringToDescription("\nUpon entering the room, you recognize it,");
            player.getCurrentRoom().addStringToDescription("you've been here before, you recognize the elevator,");
            player.getCurrentRoom().addStringToDescription("you are back where you started!");
        }

    }

    public void loadHighscore() {
        Highscores hsx = null;
        /* Serialisering benyttes til at hente highscore objekt fra fil eller oprette et nyt hvis det fejler. */
        try {
            hsx = (Highscores) Serialization.load("highscores.ser");
            ui.printHighscore(hsx.printHighscore());
        } catch (Exception e) {
            System.out.println("Error");
            hsx = new Highscores();
        }
        hs = hsx;
    }

    public void updateHighcore() {
        Score score = new Score(player.getName(), player.getPoint());
        hs.addScore(score);
        hs.sortScore();

        try {
            Serialization.save(hs, "highscores.ser");
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // This method runs a loop on playerAction until a valid command is used or
    // an invalid command has been attempted 3 times. This method catches all the 
    // exceptions.
    public void action() {
        int count = 0;
        int maxTries = 3;
        while (count++ < maxTries || !hasRoomChanged) {
            String actionString = ui.askForAction("What is your next action?");
            try {
                ActionType actionEnum = actionConverter(actionString);
                hasRoomChanged = playerAction(actionEnum); //This is a switch that asks for player action with fitting cases.
                count = maxTries;
            } catch (IllegalArgumentException e) {
                ui.invalidCommand();
            } catch (NoDoorException ex) {
                ui.noDoorMessage();
            } catch (NoItemException ey) {
                ui.noLootMessage();
            } catch (PlayerDeadException ex) {
                ui.deathMessage();
                System.exit(0);
            } catch (NoMonsterException ex) {
                ui.noMonsterMessage();
            } catch (inCombatException ex) {
                ui.youCantRun();
            }
        }
        hasRoomChanged = false;
    }

    public ActionType actionConverter(String action) {
        ActionType actionType;
        try {
            actionType = ActionType.valueOf(action);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return actionType;
    }

//    Method that receives the attempted action from the user
//    and through the switch tries to do something.
    public boolean playerAction(ActionType action) throws IllegalArgumentException, NoDoorException, NoItemException, PlayerDeadException, NoMonsterException, inCombatException {
        switch (action) {
            case north:
                player.goNorth();
                return true;
            case east:
                player.goEast();
                return true;
            case south:
                player.goSouth();
                return true;
            case west:
                player.goWest();
                return true;
            case loot:
                player.addItem(player.getCurrentRoom().getItem());
                player.getCurrentRoom().removeItem();
                return false;
            case pot:
                player.useItem("HealthPot");
                return false;
            case stats:
                ui.printStats(player);
                return false;
            case attack:
                combat = new Combat();
                combat.combatController(player, player.getCurrentRoom().getMonster());
                return false;
            case help:
                ui.listOfCommands();
                return false;
            case quit:
                System.out.println("GG");
                System.exit(0);
            default:
                throw new IllegalArgumentException();
        }

    }

    public void checkForCombat() {
        if (player.getCurrentRoom().getMonster() == null) {
            player.setInCombat(false);
        } else {
            player.setInCombat(true);
        }
    }

}
