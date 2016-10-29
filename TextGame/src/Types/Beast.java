package Types;

public class Beast {

    public static final int ID = 9;
    public static final String type = "Beast";
    public static final String message = "Fighting Beast";
    
    public Beast(){}
    
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