package Types;

public class Snake {

    public static final int ID = 6;
    public static final String type = "Snake";
    public static final String message = "Fighting snakes";
    
    public Snake(){}
    
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