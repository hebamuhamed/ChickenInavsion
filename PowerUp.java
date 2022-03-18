
package ChickenInvasion;


public class PowerUp extends Images {
    private int ID;
    private int speed=4;
    boolean isTaken;

    public PowerUp( int posX, int posY,boolean visible,int ID,boolean isTaken) {
       super(posX, posY,visible);
        this.ID = ID;
        this.isTaken = false;
        initPowerUp();
    }

   
     private void initPowerUp() {
        loadImage("sprites/Skip2.png"); 
        getImageDimensions();
    }
     
     public void move() {
        posY += speed;
        if (posY>1600) {
            visible = false;
        }
    }
     
  
}
