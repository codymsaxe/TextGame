package Globals;

public class Inventory {
    
    private boolean hasKey;
    private boolean hasItem;
    private boolean hasWeapon;
    
    public Inventory(){
        hasKey = false;
        hasItem = false;
        hasWeapon = false;
    }
    
    // Set Get key
    public void setHasKey(boolean aHasKey){
        this.hasKey = aHasKey;
    }
    public boolean getHasKey(){
        return hasKey;
    }
    
    // Set get item
    public void setHasItem(boolean aHasItem){
        this.hasItem = aHasItem;
    }
    public boolean getHasItem(){
        return hasItem;
    }
    
    // set get weapon
    public void setHasWeapon(boolean aHasWeapon){
        this.hasWeapon = aHasWeapon;
    }
    public boolean getHasWeapon(){
        return hasWeapon;
    }
    
}
