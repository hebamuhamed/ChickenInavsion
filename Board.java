package ChickenInvasion;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLayeredPane;

public class Board  extends JPanel implements ActionListener {

    protected int lvl = 1;
    private final int timeDelay = 10;
    private Timer timer;
    private Player player;
    private Score score;
    private int lifePoint;
    private Enemy enemyarr[]= new Enemy[30];
    private PowerUp twoB = new PowerUp(0,0,false,1,false);
    private PowerUp Bomb = new PowerUp(0,0,false,1,false);
    int posX,posY,PUi,PUx;
    private boolean play;
    private final int Width = 1600;
    private final int Height = 1200;
    private int scoreFinal;
    
     
    
    public Board() {

        initBoard();
    }
    
   
    
 public void initEnemy() {
        
             
                for(int i=0; i<30; i++)
                    enemyarr[i] = new Enemy((((i%7)+3)*150),(((i/6)+1)*100),true,1,false);
                  for(int i=24; i<28; i++)
                    enemyarr[i].posX-=150;
                  for(int i=18; i<21; i++)
                    enemyarr[i].posX-=150;
                  for(int i=12; i<14; i++)
                    enemyarr[i].posX-=150;
                    enemyarr[6].posX-=150;
                    
                for(Enemy e:enemyarr){
                    if(e.HP == 0){
                         e.visible  = false;
                    }
                    else{ e.visible  = true;
                      
                    }
                }
               
                Random rand = new Random();
              PUi =(15 + rand.nextInt(14));
              PUx =PUi;
              
              System.out.println(PUi);
              System.out.println(PUx);

                enemyarr[PUi].PU=true;
                if(PUi%2 == 0){
                    Bomb.posX = enemyarr[PUi].posX;
                    Bomb.posY = enemyarr[PUi].posY;
                }
                else if(PUx%2 == 1){
                    twoB.posX = enemyarr[PUx].posX;
                    twoB.posY = enemyarr[PUx].posY;
                }
              PUi = PUi%2;
              PUx = PUx%2;
   
 }

    private void initBoard() {

        addKeyListener(new TAdapter());

         setBackground(Color.black);

        play=true;
        
        setFocusable(true);

       player = new Player();
       score = new Score();
        initEnemy();
        timer = new Timer(timeDelay, this);
        timer.start();
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (play) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    private void drawObjects(Graphics g) {


        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(),this);
        }
        
        if (twoB.isVisible()) {
            g.drawImage(twoB.getImage(), twoB.getX(), twoB.getY(),this);
        }
       if (Bomb.isVisible()) {
            g.drawImage(Bomb.getImage(), Bomb.getX(), Bomb.getY(),this);
        }
        List<Bullets> bullets = player.getBullets();

        for (Bullets bullet : bullets) {
            if (bullet.isVisible()) {
                g.drawImage(bullet.getImage(), bullet.getX(),bullet.getY(), this);
            }
        }

        for (int i=0; i<30; i++) {
            if (enemyarr[i].visible) {
                g.drawImage(enemyarr[i].getImage(), enemyarr[i].getX(), enemyarr[i].getY(),this);
            }
        }

        g.setColor(Color.WHITE);

        g.drawString("Lives: "+player.getLifePoint(),100,15);
        g.drawString("Score: "+score.getScore(),700,15);
    }

    private void drawGameOver(Graphics g) {

        
        Font small = new Font("Helvetica", Font.ITALIC, 40);
        String endGame = "Game Over";
       
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(endGame, (Width - fm.stringWidth(endGame)) / 2,    Height / 2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        play();
        updateBullets();
        updatePlayer();
        updateEnemy();
        updatePUi();
        updatePUx();
        checkCollisions();
        BOMB();
        repaint();
    }
private void play() {

        if (!play) {
            
            timer.stop();
        }
    }

    private void updatePUi() {

                if (twoB.isVisible()    &&  twoB.isTaken == false) {

                    twoB.move();
                } else {

                    twoB.visible=false;
                }
            }
     private void updatePUx() {

                if (Bomb.isVisible()    &&  Bomb.isTaken == false) {

                    Bomb.move();
                } else {

                    Bomb.visible=false;
                }
            }
    
    private void updateBullets() {

        List<Bullets> bullets = player.getBullets();

        for (int i = 0; i < bullets.size(); i++) {

            Bullets bullet = bullets.get(i);

            if (bullet.isVisible()) {

                bullet.move();
            } else {

                bullets.remove(i);
            }
        }
    }
 private void updateEnemy() {
 
 if  (scoreFinal>=125){
     play=false;
 }
 int alive=0;

     for(Enemy enemy :enemyarr){
         if(enemy.isVisible()&&enemy.HP>0){
                 alive++;}
             }
              if(alive==0){
             play=false;
             return; 
    }
        
 }   

 
              
 public void checkCollisions() {

        Rectangle p = player.getBounds();

        for (int i = 0; i < 30; i++) {
            
            Rectangle e = enemyarr[i].getBounds();

            if (p.intersects(e)&& enemyarr[i].HP>0) {
                System.out.println("player");
               player.resetPosition();
               lifePoint= player.getLifePoint();
               scoreFinal=score.getScore();
               scoreFinal+=5;
               score.setScore(scoreFinal);
               if(enemyarr[i].HP==0)
                    enemyarr[i].visible=false;
               if (lifePoint<1)
               {
                 player.visible=false;
                enemyarr[i].HP--;
                play = false;
                
               }
                else
                {
                enemyarr[i].HP--;   
                lifePoint--;
                if(enemyarr[i].HP<1)
                    enemyarr[i].visible=false;
                player.setLifePoint(lifePoint);

                score.setScore(scoreFinal);

               }    
            }
        }
        
         Rectangle pu1 = twoB.getBounds();      
         if (p.intersects(pu1)&& twoB.visible==true) {
             twoB.isTaken=true;
             twoB.visible=false;
             scoreFinal+=10;
             if(twoB.isTaken==true)
             {
                 player.PU=true;
             }
             
                long start = System.currentTimeMillis();
                long end = start + 30;
                if (System.currentTimeMillis() <= end) {
                    System.out.println("SHA8AL");
                    twoB.isTaken=true;
                    player.PU=true;
                }
            }
         else{
            Rectangle pu2 = Bomb.getBounds();
         if (p.intersects(pu2)&& Bomb.visible==true) {
             Bomb.isTaken=true;
             Bomb.visible=false;
             scoreFinal+=10;
         }
         } 
          


        List<Bullets> bullets = player.getBullets();

        for (Bullets bullet : bullets) {

            Rectangle b = bullet.getBounds();

            for (int i = 0; i < 30; i++) {

                Rectangle e = enemyarr[i].getBounds();

                if (b.intersects(e)&& enemyarr[i].HP>0) {
                    scoreFinal=score.getScore();
                    scoreFinal+=5;
                    score.setScore(scoreFinal);
                    bullet.visible=false;
                    enemyarr[i].HP--;
                    if(enemyarr[i].HP==0){
                        enemyarr[i].visible=false;
                        if(enemyarr[i].PU==true){
                            if(PUi == 0)
                            Bomb.setVisible();
                            
                            if(PUx == 1)
                            twoB.setVisible();
                        }
                    }
                }
            }
        }
 }
 
    private void updatePlayer() {

       if (player.isVisible()) {
            
            player.move();
        }
    }
    private void BOMB(){
        if(Bomb.isTaken==true){
            int counter=0;
            for(int i=0;i<30&&counter<6;i++){
               if( (enemyarr[i].isVisible()) && (i%2 == 1) ){
                   
                   enemyarr[i].HP--;
                   enemyarr[i].visible=false;
                   counter++;
                     if(counter==5){
                Bomb.isTaken=false;
                break;
               }
            }
          
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
} 