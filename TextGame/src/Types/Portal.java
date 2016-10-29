package Types;

public class Portal {

    public static final int ID = 3;
    public static final String type = "Portal";
    public static final String message = "Found portal";
    
    public Portal(){}
    
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