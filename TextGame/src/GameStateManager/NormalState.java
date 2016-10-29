package GameStateManager;

import Globals.*;
import Objects.Player;
import Objects.Room;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import Tile.Background;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Types.*;

public class NormalState extends GameState{
    
    private Background bg;
    
    private String[] options = {"NORTH", "SOUTH", "EAST", "WEST"};
    private int currentChoice = 0;
    
    private Color optionsColor;
    private Font optionsFont;
    
    private String title = "TEST";
    private String message = "message test";
    private Font messageFont;
    
    private static ArrayList map;
    private static Player player;
    private static Inventory inventory;
    
    private static int ID;
    
    public NormalState(GameStateManager gsm){
        this.gsm = gsm;
        bg = new Background();
        
        optionsColor = Color.WHITE;
        optionsFont = new Font("Arial", Font.PLAIN, 12);
        
        this.map = new ArrayList();
        this.inventory = new Inventory();
        createMap();
        this.player = new Player("Player 1", "New Player", (Room) map.get(24));
    }
    public void createMap(){
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), Direction.NO_EXIT, 7, 1, Direction.NO_EXIT));
        map.add(new Room(Weeper.getType(), Weeper.getMessage(), Weeper.getIdentifier(), Direction.NO_EXIT, 8, 2, 0));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), Direction.NO_EXIT, 9, 3, 1));
        map.add(new Room(Key.getType(), Key.getMessage(), Key.getIdentifier(), Direction.NO_EXIT, 10, 4, 2));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), Direction.NO_EXIT, 11, 5, 3));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), Direction.NO_EXIT, 12, 6, 4));
        map.add(new Room(Weapon.getType(), Weapon.getMessage(), Weapon.getIdentifier(), Direction.NO_EXIT, 13, Direction.NO_EXIT, 5));
        
        map.add(new Room(Weeper.getType(), Weeper.getMessage(), Weeper.getIdentifier(), 0, 14, 8, Direction.NO_EXIT));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 1, 15, 9, 7));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 2, 16, 10, 8));
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 3, 17, 11, 9));
        map.add(new Room(Snake.getType(), Snake.getMessage(), Snake.getIdentifier(), 4, 18, 12, 10));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 5, 19, 13, 11));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 6, 20, Direction.NO_EXIT, 12));
        
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 7, 21, 15, Direction.NO_EXIT));
        map.add(new Room(Wolf.getType(), Wolf.getMessage(), Wolf.getIdentifier(), 8, 22, 16, 14));
        map.add(new Room(Snake.getType(), Snake.getMessage(), Snake.getIdentifier(), 9, 23, 17, 15));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 10, 24, 18, 16));
        map.add(new Room(Weapon.getType(), Weapon.getMessage(), Weapon.getIdentifier(), 11, 25, 19, 17));
        map.add(new Room(Wolf.getType(), Wolf.getMessage(), Wolf.getIdentifier(), 12, 26, 20, 18));
        map.add(new Room(Weapon.getType(), Weapon.getMessage(), Weapon.getIdentifier(), 13, 27, Direction.NO_EXIT, 19));
        
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 14, 28, 22, Direction.NO_EXIT));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 15, 29, 23, 21));
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 16, 30, 24, 22));
        map.add(new Room(Start.getType(), Start.getMessage(), Start.getIdentifier(), 17, 31, 25, 23));
        map.add(new Room(Weapon.getType(), Weapon.getMessage(), Weapon.getIdentifier(), 18, 32, 26, 24));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 19, 33, 27, 25));
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 20, 34, Direction.NO_EXIT, 26));
        
        map.add(new Room(Portal.getType(), Portal.getMessage(), Portal.getIdentifier(), 21, 35, 29, Direction.NO_EXIT));
        map.add(new Room(Weapon.getType(), Weapon.getMessage(), Weapon.getIdentifier(), 22, 36, 30, 28));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 23, 37, 31, 29));
        map.add(new Room(Wolf.getType(), Wolf.getMessage(), Wolf.getIdentifier(), 24, 38, 32, 30));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 25, 39, 33, 31));
        map.add(new Room(Snake.getType(), Snake.getMessage(), Snake.getIdentifier(), 26, 40, 34, 32));
        map.add(new Room(Item.getType(), Item.getMessage(), Item.getIdentifier(), 27, 41, Direction.NO_EXIT, 33));
        
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 28, 42, 36, Direction.NO_EXIT));
        map.add(new Room(Snake.getType(), Snake.getMessage(), Snake.getIdentifier(), 29, 42, 37, 35));
        map.add(new Room(Wolf.getType(), Wolf.getMessage(), Wolf.getIdentifier(), 30, 43, 38, 36));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 31, 44, 39, 37));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 32, 45, 40, 38));
        map.add(new Room(Beast.getType(), Beast.getMessage(), Beast.getIdentifier(), 33, 46, 41, 39));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 34, 47, Direction.NO_EXIT, 40));
        
        map.add(new Room(Item.getType(), Item.getMessage(), Item.getIdentifier(), 35, Direction.NO_EXIT, 43, Direction.NO_EXIT));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 36, Direction.NO_EXIT, 44, 42));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 37, Direction.NO_EXIT, 45, 43));
        map.add(new Room(Weeper.getType(), Weeper.getMessage(), Weeper.getIdentifier(), 38, Direction.NO_EXIT, 46, 44));
        map.add(new Room(Bog.getType(), Bog.getMessage(), Bog.getIdentifier(), 39, Direction.NO_EXIT, 47, 45));
        map.add(new Room(Forest.getType(), Forest.getMessage(), Forest.getIdentifier(), 40, Direction.NO_EXIT, 48, 46));
        map.add(new Room(Item.getType(), Item.getMessage(), Item.getIdentifier(), 41, Direction.NO_EXIT, Direction.NO_EXIT, 47));
    }
    public Player getPlayer(){
        return player;
    }
    public void movePlayerToRoom(Player aPlayer, Room aRoom){
        aPlayer.setRoom(aRoom);
    }
    public int movePlayerTo(Direction dir){
        return moveTo(player, dir);
    }
    public int moveTo(Player aPlayer, Direction dir){
        Room room = aPlayer.getRoom();
        int exit;
        
        switch(dir){
            case NORTH:
                exit = room.getN();
                break;
            case SOUTH:
                exit = room.getS();
                break;
            case EAST:
                exit = room.getE();
                break;
            case WEST:
                exit = room .getW();
                break;
            default:
                exit = Direction.NO_EXIT;
                break;
        }
        if(exit != Direction.NO_EXIT){
            movePlayerToRoom(aPlayer, (Room)map.get(exit));
            ID = player.getRoom().getIdentity();
            checkEvent(ID);
        }
        return exit;
    }
    public void checkEvent(int ID){
        switch(ID){
            case 0:
                // Start, Forest
                setID(0);
                break;
            case 1:
                // Bog
                setID(1);
                break;
            case 2:
                // Key
                setID(2);
                inventory.setHasKey(true);
                System.out.println("Key Case Working");
                break;
            case 3:
                setID(3);
                // Portal
                if(inventory.getHasKey() == true){
                    System.out.println("You Win!");
                }
                else{
                    System.out.println("You Don't Win :(");
                }
                break;
            case 4:
                setID(4);
                // Item
                inventory.setHasItem(true);
                System.out.println("Has item working");
                break;
            case 5:
                setID(5);
                // Weapon
                inventory.setHasWeapon(true);
                System.out.println("Has weapon working");
                break;
            case 6:
                setID(6);
                // Snake
                gsm.setState(GameStateManager.BATTLESTATE);
                break;
            case 7:
                setID(7);
                // Wolf
                gsm.setState(GameStateManager.BATTLESTATE);
                break;
            case 8:
                setID(8);
                // Weeper
                gsm.setState(GameStateManager.BATTLESTATE);
                break;
            case 9:
                setID(9);
                gsm.setState(GameStateManager.BATTLESTATE);
                // Beast
                break;
            case 10:
                setID(10);
                // Escape
                break;
            default:
                break;
        }
    }
    public void updateOutput(int roomNumber){
        if(roomNumber == Direction.NO_EXIT){
            message = "No Exit";
        }
        else{
            Room room = player.getRoom();
            title = room.getName();
            message = room.getDescription();
        }
    }
    public void init(){}
    public void update(){}
    public void draw(Graphics2D g){
        
        // Draw (BLACK) background
        bg.draw(g);
        
        // Draw options
        g.setFont(optionsFont);
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.BLUE);
            }
            else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 40 + i * 70, 200);
        }
        
        // Draw Title
        g.setColor(Color.RED);
        g.drawString(title, 40, 40);
        
        // Draw Message
        g.setColor(Color.BLUE);
        messageFont = new Font("Arial", Font.PLAIN, 10);
        g.setFont(messageFont);
        g.drawString(message, 40, 60);
    }
    public void select(){
        if(currentChoice == 0){
            // NORTH
            updateOutput(movePlayerTo(Direction.NORTH));
        }
        if(currentChoice == 1){
            // SOUTH
            updateOutput(movePlayerTo(Direction.SOUTH));
        }
        if(currentChoice == 2){
            // EAST
            updateOutput(movePlayerTo(Direction.EAST));
        }
        if(currentChoice == 3){
            // WEST
            updateOutput(movePlayerTo(Direction.WEST));
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
    
    public void setTitle(String aTitle){
        this.title = aTitle;
    }
    public void setMessage(String aMessage){
        this.message = aMessage;
    }
    public void setID(int aID){
        this.ID = aID;
    }
    public static int getID(){
        return ID;
    }
}
