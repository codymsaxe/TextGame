package GameStateManager;

import Tile.Background;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class PauseState extends GameState{
    
    private Background bg;
    
    private int currentChoice = 0;
    
    private String title = "Pause Menu";
    private String[] options = {"Continue", "Exit"};
    
    private Color titleColor;
    
    public PauseState(GameStateManager gsm){
        this.gsm = gsm;
        bg = new Background();
        titleColor = Color.BLUE;
    }
    public void init(){}
    public void update(){}
    public void draw(Graphics2D g){
        // Draw background
        bg.draw(g);
        
        // Draw title
        g.setColor(titleColor);
        g.drawString(title, 120,100);
        
        // Draw options
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.BLUE);
            }
            else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 125, 140 + i * 15);
        }
    }
    public void select(){
        if(currentChoice == 0){
            // Continue
            gsm.setState(GameStateManager.NORMALSTATE);
        }
        if(currentChoice == 1){
            // Exit
            gsm.setState(GameStateManager.MENUSTATE);
        }
    }
    public void keyPressed(int key){
        if(key == KeyEvent.VK_ENTER){
            select();
        }
        if(key == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(key == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int ke){}
    
}
