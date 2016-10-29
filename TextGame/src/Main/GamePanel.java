package Main;

import javax.swing.JPanel;
import GameStateManager.GameStateManager;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class GamePanel extends JPanel implements Runnable, KeyListener{
    
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;
    
    private Thread thread;
    private boolean running;
    
    private Graphics2D g;
    
    private BufferedImage image;
    private GameStateManager gsm;
    
    private JTextArea textArea;
    
    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH * 2, HEIGHT * 2));
        setFocusable(true);
        requestFocus();
        
        textArea = new JTextArea(5,20);
        add(textArea);
    }
    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }
    private void init(){
        // Sets image and g to be able to create images
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        
        running = true;
        gsm = new GameStateManager();
    }
    public void run(){
        init();
        
        while(running){
            update();
            draw();
            drawToScreen();
        }
    }
    private void update(){
        gsm.update();
    }
    private void draw(){
        gsm.draw(g);
    }
    private void drawToScreen(){
        Graphics g2 = getGraphics();
        g2.drawImage(image,0,0,WIDTH * SCALE, HEIGHT * SCALE,null);
        g2.dispose();
    }
    public void keyTyped(KeyEvent key){}
    public void keyPressed(KeyEvent key){
        gsm.keyPressed(key.getKeyCode());
    }
    public void keyReleased(KeyEvent key){
        gsm.keyReleased(key.getKeyCode());
    }
    
}
