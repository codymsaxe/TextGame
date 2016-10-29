package Types;

public class Key {

    public static final int ID = 2;
    public static final String type = "Key";
    public static final String message = "Found key";
    
    public Key(){}
    
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