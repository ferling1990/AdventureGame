package adventureGame.data;

public class HealthPot extends Item {

    @Override
    public void use(Player player) {
        if (player.getHealth() > 80) {
            player.setHealth(100);
        } else {
            player.setHealth(player.getHealth() + 20);
        }
        player.inventory.remove(this);
    }

    @Override
    public String toString() {
        return "HealthPot";
    }
    
    
}
