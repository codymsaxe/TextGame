package Types;

public class Start {

    public static final int ID = 0;
    public static final String type = "Start";
    public static final String message = "Start room";
    
    public Start(){}
    
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