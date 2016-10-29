package Types;

public class Bog {

    public static final int ID = 1;
    public static final String type = "Bog";
    public static final String message = "Stuck in a bog";
    
    public Bog(){}
    
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
