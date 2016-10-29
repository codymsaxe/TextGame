package Objects;

import Globals.Inventory;

public class Player extends Object{
    
    private Room room;
    private Inventory inventory;
    
    public static int maxHealth = 10;
    public static int health = 10;
    public static int strength = 1;
    public static int dodge = 1;
    
    public Player(String aName, String aDescription, Room aRoom){
        super(aName, aDescription);
        this.room = aRoom;
        inventory = new Inventory();
    }
    
    // Set and get room
    public void setRoom(Room aRoom){
        this.room = aRoom;
    }
    public Room getRoom(){
        return room;
    }
    
    // Set and get max health
    public void setMaxHealth(int aMaxHealth){
        this.maxHealth = aMaxHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    
    // Set get health
    public void setHealth(int aHealth){
        this.health = aHealth;
    }
    public int getHealth(){
        return health;
    }
    
    // Set and get stregnth
    public void setStrength(int aStrength){
        this.strength = aStrength;
    }
    public int getStrength(){
        return strength;
    }
    
    // Set and get dodge
    public void setDodge(int aDodge){
        this.dodge = aDodge;
    }
    public int getDodge(){
        return dodge;
    }
    
    // Set get inventory
    public Inventory getInventory(){
        return inventory;
    }
    
}
