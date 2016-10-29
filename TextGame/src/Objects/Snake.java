package Objects;

public class Snake extends Object{
    
    private int maxHealth = 3;
    private int health = 3;
    private int strength = 1;
    
    public Snake(String aName, String aDescription){
        super(aName, aDescription);
        this.name = aName;
        this.description = aDescription;
    }
    
    // Set get maxhealth
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
    
    // Get set strength
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
