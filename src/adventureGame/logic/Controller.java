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
    private Actions act;
    
    public Controller() {
        ui = new TUI();
        world = new World();
        act = new Actions();
        turn = 1;
    }
    
    public void game() {
        player = new Player("Player1", world.generateStartRoom()); //generateStartRoom randomizes between 4 possible startrooms
        world.createWorld();
        //System.out.println(player.getCurrentRoom()); //test message to see the start room number
        dungeon = world.getDungeon();
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
            act.playerAction(player, dungeon, ui); //This is a switch that asks for player action with fitting cases.
            turn++; // counts the number of turns used.
        } while (player.getCurrentRoom() != 99); //game ends when current room == 99 (the end room).
        ui.winningMessage();
    }
    
}
