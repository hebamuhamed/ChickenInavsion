package ChickenInvasion;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public abstract class Images {
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;
    protected int lifePoint;
    protected int lvl;

    
    public Images(int posX, int posY,boolean visible) {

        this.posX = posX;
        this.posY = posY;
        this.visible = visible;
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }
     
    public void setX(int posX) {
         this.posX = posX;
    }
    
    public void setY(int posY) {
         this.posY = posY;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible() {
        this.visible = true;
    }
    public Rectangle getBounds() {
        return new Rectangle(posX, posY, width, height);
    }
    public int getLifePoint() {
        return lifePoint;
    }
    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }
    public int getlvl() {
        return lvl;
    }
    
}
