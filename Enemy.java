package ChickenInvasion;

import java.awt.Rectangle;


class Enemy extends Images {

int HP=1;
boolean PU=false; 

    public Enemy(int posX, int posY,boolean isVisible,int HP,boolean PU) {
        super(posX, posY,true);
        this.HP=HP;
        this.PU=PU;

        initEnemy();
    }




    private void initEnemy() {

        loadImage("Sprites/Lvl1Chick.png");
        getImageDimensions();
        
    }
    
    
    
   }



