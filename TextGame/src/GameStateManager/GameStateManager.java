package GameStateManager;

import Objects.Player;
import java.util.ArrayList;
import java.awt.Graphics2D;

public class GameStateManager {
    
    private ArrayList<GameState> gameStates;
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int NORMALSTATE = 1;
    public static final int BATTLESTATE = 2;
    public static final int PAUSESTATE = 3;
    
    public GameStateManager(){
        gameStates = new ArrayList<GameState>();
        
        // Initialize first gamestate
        currentState = MENUSTATE;
        
        // Add class states to ArrayList
        gameStates.add(new MenuState(this));
        gameStates.add(new NormalState(this));
        gameStates.add(new BattleState(this));
        gameStates.add(new PauseState(this));
    }
    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }
    public void update(){
        gameStates.get(currentState).update();
    }
    public void draw(Graphics2D g){
        gameStates.get(currentState).draw(g);
    }
    public void keyPressed(int key){
        gameStates.get(currentState).keyPressed(key);
    }
    public void keyReleased(int key){
        gameStates.get(currentState).keyReleased(key);
    }
    
}
