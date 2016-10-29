package Tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.GamePanel;

public class Background {

    private BufferedImage image;
    private Graphics2D g;
    private Color color1;
    
    public Background(){
        color1 = Color.BLACK;
    }
    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }
    
}
