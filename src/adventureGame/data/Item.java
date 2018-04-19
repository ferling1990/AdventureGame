package adventureGame.data;

public abstract class Item {
      
    public abstract void use(Player player);
    
    @Override
    public abstract String toString();
    
}
