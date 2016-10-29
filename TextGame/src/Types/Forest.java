package Types;

public class Forest {

    public static final int ID = 0;
    public static final String type = "Forest";
    public static final String message = "The dark forest";
    
    public Forest(){}
    
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
