package Objects;

public class Weeper extends Object{
    
    public int maxHealth = 1;
    public int health = 1;
    public int strength = 8;
    
    public Weeper(String aName, String aDescription){
        super(aName, aDescription);
        this.name = aName;
        this.description = aDescription;
    }
    
    // Get set max health
    public void setMaxHealth(int aMaxHealth){
        this.maxHealth = aMaxHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    
    // Get set health
    public void setHealth(int aHealth){
        this.health = aHealth;
    }
    public int getHealth(){
        return health;
    }
    
    // Get set Strength
    public void setStrength(int aStrength){
        this.strength = aStrength;
    }
    public int getStrength(){
        return strength;
    }
    
    // Get name
    public String getName(){
        return name;
    }
    
}
