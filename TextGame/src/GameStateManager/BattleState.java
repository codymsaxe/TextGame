package GameStateManager;

import Objects.Beast;
import Objects.Player;
import Objects.Snake;
import Objects.Weeper;
import Objects.Wolf;
import Tile.Background;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class BattleState extends GameState{
    
    private int currentChoice = 0;
    private int currentID;
    
    private String[] options = {"FIGHT", "FLIGHT", "DISTRACT", "EVADE"};
    
    private Color titleColor;
    
    private String enemyName;
    private int enemyMaxHealth;
    private int enemyHealth;
    private int enemyStrength;
    
    //private int playerMaxHealth;
    //private int playerHealth;
    //private int playerStrength;
    
    private boolean isDead;
    
    private String title = "Encounter!";
    private String playerTurnTxt = "Your turn";
    private String enemyturnTxt = "Enemy's Turn";
    private String turnTxt;
    private String damageTxt;
    
    private int currentState;
    private int titleState;
    private int normalState;
    private int playerHitState;
    private int enemyHitState;
    private int flightState;
    private int distractState;
    
    private int currentTurn;
    private int playerTurn;
    private int enemyTurn;
    
    private Background bg;
    
    public BattleState(GameStateManager gsm){
        this.gsm = gsm;
        bg = new Background();
        titleColor = Color.RED;
        currentID = NormalState.getID();
        
        titleState = 0;
        normalState = 1;
        playerHitState = 2;
        enemyHitState = 3;
        flightState = 4;
        distractState = 5;
        
        currentState = normalState;
        
        playerTurn = 0;
        enemyTurn = 1;
        
        currentTurn = playerTurn;
        
        turnTxt = "Your turn";
    }
    public void setEnemy(int currentID){
        switch(currentID){
            case 6:
                // Snake
                Snake snake = new Snake("Snake", "Venomous Snake");
                System.out.println("Working");
                this.enemyName = snake.getName();
                this.enemyMaxHealth = snake.getMaxHealth();
                this.enemyHealth = snake.getHealth();
                this.enemyStrength = snake.getStrength();
                isDead = false;
                break;
            case 7:
                // Wolf
                Wolf wolf = new Wolf("Wolf", "Vicious wolf");
                enemyName = wolf.getName();
                enemyMaxHealth = wolf.getMaxHealth();
                enemyHealth = wolf.getHealth();
                enemyStrength = wolf.getStrength();
                isDead = false;
                break;
            case 8:
                // Weeper
                Weeper weeper = new Weeper("Weeper", "Terrifying monster");
                enemyName = weeper.getName();
                enemyMaxHealth = weeper.getMaxHealth();
                enemyHealth = weeper.getHealth();
                enemyStrength = weeper.getStrength();
                isDead = false;
                break;
            case 9:
                // Beast
                Beast beast = new Beast("The Beast", "Run");
                enemyName = beast.getName();
                enemyMaxHealth = beast.getMaxHealth();
                enemyHealth = beast.getHealth();
                enemyStrength = beast.getStrength();
                isDead = false;
                break;
            default:
                break;
        }
    }
    public void init(){
        currentID = NormalState.getID();
        setEnemy(currentID);
    }
    public void update(){    }
    public void draw(Graphics2D g){
        // Draw Background
        bg.draw(g);
        
        if(currentState == normalState){
            // Draw title
            g.setColor(titleColor);
            g.drawString(title, 120, 30);
            g.drawString("You are fighting " + enemyName, 120, 40);
            g.drawString(turnTxt, 120, 60);
        }
        
        if(currentState == playerHitState){
            // Draw player hit
            g.setColor(titleColor);
            g.drawString(damageTxt, 100, 40);
            g.drawString(turnTxt, 120, 60);
        }
        
        if(currentState == flightState){
            g.setColor(Color.RED);
            g.drawString(damageTxt, 100, 40);
        }
        
        if(currentState == distractState){
            g.setColor(Color.RED);
            g.drawString(damageTxt, 100, 40);
        }
        
        // Draw options
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.BLUE);
            }
            else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 40 + i * 70, 200);
        }
        
        // Draw Enemy Stats
        //g.drawString(enemyName, 30, 100);
        g.setColor(Color.RED);
        g.drawString("Enemy Health:", 30, 100);
        g.drawString("" + enemyHealth + "/" + enemyMaxHealth, 30, 120);
        
        // Draw Player Stats
        g.setColor(Color.RED);
        g.drawString("Player Health:", 200, 100);
        g.drawString("" + Player.health + "/" + Player.maxHealth, 200, 120);
    }
    public void select(){
        if(currentChoice == 0){
            // Fight
            damageEnemy();
        }
        if(currentChoice == 1){
            // Flight
            damageTxt = "";
            turnTxt = "";
            flight();
        }
        if(currentChoice == 2){
            // Distract
            damageTxt = "";
            turnTxt = "";
            distract();
        }
        if(currentChoice == 3){
            // Evade
        }
    }
    public void keyPressed(int key){
        if(key == KeyEvent.VK_ENTER){
            select();
        }
        if(key == KeyEvent.VK_LEFT){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(key == KeyEvent.VK_RIGHT){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            gsm.setState(GameStateManager.PAUSESTATE);
        }
    }
    public void keyReleased(int key){}
    
    private void flight(){
        currentState = flightState;
        String txt = "";
        Random r = new Random();
        int max = 10;
        int min = 1;
        int randomNum = r.nextInt(max - min + 1) + min;
        damageTxt = "You attempt to run...";
        if(randomNum >= 7){
            txt = "You escape safely...";
            damageTxt = txt;
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){
                e.printStackTrace();
            }
            gsm.setState(GameStateManager.NORMALSTATE);
            currentState = normalState;
        }
        else{
            txt = "You couldn't escape";
            damageTxt = txt;
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){
                e.printStackTrace();
            }
            enemyTurn();
        }
    }
    private void distract(){
        currentState = distractState;
        String txt = "";
        Random r = new Random();
        int max = 10;
        int min = 1;
        int randomNum =  r.nextInt(max - min + 1) + min;
        if(randomNum >= 7){
            txt = "You throw a rock to distract the enemy";
            damageTxt = txt;
            currentState = normalState;
        }
        else if(randomNum < 7){
            txt = "The enemy is too focused on you";
            damageTxt = txt;
            enemyTurn();
        }
    }
    private void damageEnemy(){
        currentState = playerHitState;
        enemyHealth = enemyHealth - Player.strength;
        turnTxt = "Your turn";
        damageTxt = "You do " + Player.strength + " damage to " + enemyName;
        if(enemyHealth <= 0){
            
        }
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(isDead == false){
            enemyTurn();
        }
    }
    private void damagePlayer(){
        currentState = playerHitState;
        Player.health = Player.health - enemyStrength;
        turnTxt = "Enemy's turn";
        damageTxt = enemyName + " does " + enemyStrength + " damage to you";
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        playerTurn();
    }
    private void playerTurn(){
        damageTxt = "";
        turnTxt = "Your turn";
    }
    private void enemyTurn(){
        damageTxt = "";
        turnTxt = "Enemy's turn";
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        damagePlayer();
    }
    
}
