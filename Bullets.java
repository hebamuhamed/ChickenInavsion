package ChickenInvasion;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bullets extends Images {
    
    private final int Speed = 3;

    public Bullets(int x, int y,boolean visible) {
        super(x,y,visible);
        initBullet();
    }
    
    private void initBullet() {
        
        loadImage("sprites/smolBullet.png");  
        getImageDimensions();
    }

    public void move() {
        
        posY -= Speed;
        
        if (posY<0) {
            visible = false;
        }
    }
}