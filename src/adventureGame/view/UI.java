// UI interface, idea is to allow for easy change to other sorts of UI's instead of TUI if needed.
package adventureGame.view;

//Group 20

import adventureGame.logic.Player;
import adventureGame.data.Room;

//Lau, Mark, Jonatan og Mads

public interface UI {

    public String askForAction();
    public void winningMessage();
    public void deathMessage();
    public void startMessage();
    public void invalidCommand();
    public void noDoorMessage();
    public void noLootMessage();
    public void listOfCommands();
    public void showPlayerHealth(Player player);
    public void printRoomDescription(Room room);
    
}
