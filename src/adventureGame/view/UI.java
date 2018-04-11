// UI interface, idea is to allow for easy change to other sorts of UI's instead of TUI if needed.
package adventureGame.view;

//Group 20
//Lau, Mark, Jonatan og Mads

public interface UI {

    public String askDirection();
    public void winningMessage();
    public void deathMessage();
    public void startMessage();
    public void invalidCommand();
    public void noDoorMessage();
    public void listOfCommands();
    
}
