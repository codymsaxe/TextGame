package GameStateManager;

import Tile.Background;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuState extends GameState{
    
     private Background bg;
    
     private int currentChoice = 0;
     
     private String title = "Escape!";
     private String[] options = {"Start", "Help", "Quit"};
     
     private Color titleColor;
     private Font titleFont;
     private Font font;
    
     public MenuState(GameStateManager gsm){
         this.gsm = gsm;
         bg = new Background();
         titleColor = Color.WHITE;
         titleFont = new Font("Arial", Font.PLAIN, 20);
         font = new Font("Arial", Font.PLAIN, 12);
     }
     public void init(){}
     public void update(){}
     public void draw(Graphics2D g){
         // Draw background
         bg.draw(g);
         
         // Draw title
         g.setColor(titleColor);
         g.setFont(titleFont);
         g.drawString(title, 120, 100);
         
         // Draw options
         g.setFont(font);
         for(int i = 0; i < options.length; i++){
             if(i == currentChoice){
                 g.setColor(Color.BLUE);
             }
             else{
                 g.setColor(Color.RED);
             }
             g.drawString(options[i], 145, 140 + i * 15);
         }
     }
     private void select(){
         if(currentChoice == 0){
             // Start option
             gsm.setState(GameStateManager.NORMALSTATE);
         }
         if(currentChoice == 1){
             // Help option
         }
         if(currentChoice == 2){
             // Exit option
             System.exit(0);
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
     public void keyReleased(int key){}
     
}
