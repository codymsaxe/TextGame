package Types;

public class Weeper {

    public static final int ID = 8;
    public static final String type = "Weeper";
    public static final String message = "Fightin weeper";
    
    public Weeper(){}
    
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