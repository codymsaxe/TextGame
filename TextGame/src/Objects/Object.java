package Objects;

public class Object {

    String name;
    String description;
    
    public Object(String aName, String aDescription){
        this.name = aName;
        this.description = aDescription;
    }
    public void setName(String aName){
        this.name = aName;
    }
    public void setDescription(String aDescription){
        this.description = aDescription;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
