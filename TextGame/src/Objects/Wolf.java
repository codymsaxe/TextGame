package Objects;

public class Wolf extends Object{
    
    private int maxHealth = 5;
    private int health = 5;
    private int strength = 3;
    
    public Wolf(String aName, String aDescription){
        super(aName, aDescription);
        this.name = aName;
        this.description = aDescription;
    }
    
    // Set and get maxheatlh
    public void setMaxHealth(int aMaxHealth){
        this.maxHealth = aMaxHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    
    // Set and get health
    public void setHealth(int aHealth){
        this.health = aHealth;
    }
    public int getHealth(){
        return health;
    }
    
    // Set and get strength
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
