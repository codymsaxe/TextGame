package Types;

public class Item {

    public static final int ID = 4;
    public static final String type = "Item";
    public static final String message = "Found item";
    
    public Item(){}
    
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