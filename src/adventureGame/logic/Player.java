//Player class, most important info in player is the currentRoom.
package adventureGame.logic;

//Group 20
//Lau, Mark, Jonatan og Mads
import exceptions.inCombatException;
import exceptions.PlayerDeadException;
import adventureGame.data.Item;
import exceptions.NoDoorException;
import adventureGame.data.Room;
import java.util.ArrayList;

public class Player {

    private static final int START_DAMAGE = 2;
    private static final int START_DEFENSE = 0;
    private static final int START_HEALTH = 100;

    private String name;
    private int health, attackPower, defense, point;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private boolean inCombat;

    // Constructor
    public Player(String name, Room startRoom) {
        inventory = new ArrayList();
        this.name = name;
        this.health = START_HEALTH;
        this.currentRoom = startRoom;
        this.attackPower = START_DAMAGE;
        this.defense = START_DEFENSE;
        this.inCombat = false;
    }

    public void addItem(Item item) {
        inventory.add(item);
        if (!item.isConsumable()) {
            item.use(this);

        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    //Searches inventory for specific item, if it is there it is used.
    public void useItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).toString().equals(itemName)) {
                inventory.get(i).use(this);
                break;
            }
        }
    }

    //Checks if there is a door north with checkDirection(), moves to room north if there is.
    //Otherwise it throws an exception.
    public void goNorth() throws NoDoorException, inCombatException {
        if (inCombat) {
            throw new inCombatException();
        }
        if (checkForDoor(ActionType.north)) {
            setCurrentRoom(getCurrentRoom().getNorth()); //set current room to the room north
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door east with checkDirection(), moves to room east if there is.
    //Otherwise it throws an exception.
    public void goEast() throws NoDoorException, inCombatException {
        if (inCombat) {
            throw new inCombatException();
        }
        if (checkForDoor(ActionType.east)) {
            setCurrentRoom(getCurrentRoom().getEast()); //set current room to the room east
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door south with checkDirection(), moves to room south if there is.
    //Otherwise it throws an exception.
    public void goSouth() throws NoDoorException, inCombatException {
        if (inCombat) {
            throw new inCombatException();
        }
        if (checkForDoor(ActionType.south)) {
            setCurrentRoom(getCurrentRoom().getSouth()); //set current room to the room south
        } else {
            throw new NoDoorException();
        }
    }

    //Checks if there is a door west with checkDirection(), moves to room west if there is.
    //Otherwise it throws an exception.
    public void goWest() throws NoDoorException, inCombatException {
        if (inCombat) {
            throw new inCombatException();
        }
        if (checkForDoor(ActionType.west)) {
            setCurrentRoom(getCurrentRoom().getWest()); //set current room to the room west
        } else {
            throw new NoDoorException();
        }
    }

    //Determines if the chosen direction is possible. If there is no door in a
    //certain direction, its value is null.
    private boolean checkForDoor(ActionType direction) {
        switch (direction) {
            case north:
                return getCurrentRoom().getNorth() != null;
            case east:
                return getCurrentRoom().getEast() != null;
            case south:
                return getCurrentRoom().getSouth() != null;
            case west:
                return getCurrentRoom().getWest() != null;
            default:
                return false;
        }
    }

    public boolean isInCombat() {
        return inCombat;
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower += attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getPoint() {
        return point;
    }
    
    public void addPoint(int point) {
        this.point += point;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void loseHealth(int monsterAttackPower) throws PlayerDeadException {
        int damage = monsterAttackPower;
        int block = getDefense();
        int output = (1 - block / 100) * damage;
        this.health -= output;
        if (this.health <= 0) {
            throw new PlayerDeadException();
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

}
