package ChickenInvasion;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class Game extends JFrame {
 private final int Width = 1600;
    private final int Height = 1200;
    private final String Title = "Chicken Invaders";

    public Game() {
       initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle(Title);
        setSize(Width, Height);
        setMinimumSize(new Dimension(790,590));
        setVisible(true);
        pack();
        validate();
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
       MainMenu mm=new MainMenu();
            mm.setVisible(true);
        });
    }
//    private boolean running = false;
//    private Thread thread;
        //        private synchronized void start() {
//        if (running) {
//            return;
//        }
//        running = true;
//        thread = new Thread(this);
//        thread.start();
//    }
//
//    private synchronized void stop() {
//        if (!running) {
//            return;
//        }
//        running = false;
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.exit(1);
//    }
//
//    @Override
//    public void run() {
//        long LastTime = System.nanoTime();
//        final double amountofticks = 60.0;
//        double Ns = 1000000000 / amountofticks;
//        double delta = 0;
//        int frames = 0;
//        int updates = 0;
//        long timer = System.currentTimeMillis();
//
//        while (running) {
//            //GAME LOOP
//            long now = System.nanoTime();
//            delta += (now - LastTime) / Ns;
//            LastTime = now;
//            if (delta >= 1) {
//                updates++;
//                delta--;
//            }
//            frames++;
//
//            if (System.currentTimeMillis() - timer > 1000) {
//                timer += 1000;
//                System.out.println(updates + "ticks" + frames);
//                updates = 0;
//                frames = 0;
//            }
//
//        }
//        stop();
//    
//
//
//    }
//        start(); 