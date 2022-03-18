package ChickenInvasion;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
public class Player extends Images {

    private int dx;
    private int dy;
    int originalposX=800;
    int originalposY=800;
    private List<Bullets> bullets;
    private PowerUp twob = new PowerUp(0,0,false,1,false);
    public boolean PU;
  

    public Player() {
        
        super(800,800,true);
        this.PU=false;
        initPlayer();
        setLifePoint(3);

    }
    private void initPlayer() {

       bullets = new ArrayList<>();
        
        loadImage("Sprites/Paddle.png"); 
        getImageDimensions();
    }

    public void move() {
        posX += dx;
        posY += dy;
    }

    public List<Bullets> getBullets() {
        return bullets;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if(PU==false)
            fire();
            else
                fire2b();
        }

        if ((key == KeyEvent.VK_LEFT||(key==KeyEvent.VK_A))) {
          
            if(posX <= 0)
             {
                posX=0;
                dx=0;
            }else{
            dx = -5;
             }
        }

        if (key == KeyEvent.VK_RIGHT ||key==KeyEvent.VK_D) {
        if(posX>1920-110)
            {
             posX=1920-110;
             dx=0;
            }
            else
            {
            dx = 5;
            }
        }

        if (key == KeyEvent.VK_UP||key==KeyEvent.VK_W) {
            if(posY<0)
            {
             posY=0;
             dy=0;
            }
            else
            {
            dy = -3;
            }

        }
  if (key == KeyEvent.VK_DOWN||key==KeyEvent.VK_S) {
            if(posY>1080-170)
            {
             posY=1080-170;
             dy=0;
            }
            else
            {
            dy = 3;
            }
        }
    }
            public void fire() {
           bullets.add(new Bullets(posX+47, posY+40,true));
            } 
            
    public void fire2b() {
           bullets.add(new Bullets(posX+37, posY+35,true));
           bullets.add(new Bullets(posX+57, posY+35,true));
           
        }
        
    
     public void resetPosition(){
        this.posX=originalposX;
        this.posY=originalposY;
    }
    
    
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT||key==KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT ||key==KeyEvent.VK_D){
            dx = 0;
        }

        if (key == KeyEvent.VK_UP||key==KeyEvent.VK_W){
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN||key==KeyEvent.VK_S) {
            dy = 0;
        }
    }
    
}
