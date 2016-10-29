package Objects;

public class Room extends Object{
    
    private int n, s, e, w;
    private int identity;
    
    public Room(String aName, String aDescription, int aIdentity, int aN, int aS, int aE, int aW){
        super(aName, aDescription);
        this.name = aName;
        this.description = aDescription;
        this.n = aN;
        this.s = aS;
        this.e = aE;
        this.w = aW;
        this.identity = aIdentity;
    }
    
    // Set directions
    public void setN(int aN){
        this.n = aN;
    }
    public void setS(int aS){
        this.s = aS;
    }
    public void setE(int aE){
        this.e = aE;
    }
    public void setW(int aW){
        this.w = aW;
    }
    
    // Get directions
    public int getN(){
        return n;
    }
    public int getS(){
        return s;
    }
    public int getE(){
        return e;
    }
    public int getW(){
        return w;
    }
    
    // Get and set Identity
    public void setIdentity(int aIdentity){
        this.identity = aIdentity;
    }
    public int getIdentity(){
        return identity;
    }
    
}
