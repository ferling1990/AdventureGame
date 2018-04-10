package adventureGame.data;


public class Player {
    private String name;
    private int health;
    private int currentRoom;

    public Player(String name, int startRoom) {
        this.name = name;
        this.health = 100;
        this.currentRoom = startRoom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }
    
}
