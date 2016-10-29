package Types;

public class Escape {
    
    public static final int ID = 10;
    public static final String type = "Escaped";
    public static final String message = "You have escaped";
    
    public Escape(){}
    
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
