package Types;

public class Wolf {

    public static final int ID = 7;
    public static final String type = "Wolf";
    public static final String message = "Fighting Wolf";
    
    public Wolf(){}
    
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