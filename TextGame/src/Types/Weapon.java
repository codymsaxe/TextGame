package Types;

public class Weapon {

    public static final int ID = 5;
    public static final String type = "Weapon";
    public static final String message = "Found Weapon";
    
    public Weapon(){}
    
    public static String getType(){
        return type;
    }
    public static String getMessage(){
        return message;
    }
    public static int getIdentifier(){
        return ID;
    }
    
}