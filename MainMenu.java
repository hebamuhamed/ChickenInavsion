package ChickenInvasion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class MainMenu  extends JFrame implements ActionListener {
    JButton b1,b3;
     public MainMenu(){
         
         Font font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 80);
         setFont(new Font("Arial", Font.BOLD, 80));
         
         b1=new JButton("PLAY");
         b1.setFont(font);
         b1.setBounds(720,850,199,80);
         b1.setBackground( new Color(0,0,0,0));
         b1.setOpaque(false);
         b1.setFocusable(false);
         b1.setHorizontalTextPosition(JButton.CENTER);
         b1.setVerticalTextPosition(JButton.BOTTOM);
         b1.setForeground(Color.WHITE);
         b1.setBorderPainted(false);
         b1.setBorder(new LineBorder (Color.BLACK));
         b1.addActionListener(this);



          
         b3=new JButton("EXIT");
         b3.setBounds(1400,850,199,80);
         b3.setFont(font);
         b3.setLayout(null);
         b3.setBackground( new Color(0,0,0,0));
         b3.setOpaque(false);
         b3.setFocusable(false);
         b3.setHorizontalTextPosition(JButton.CENTER);
         b3.setVerticalTextPosition(JButton.BOTTOM);
         b3.setForeground(Color.WHITE);
         b3.setBorderPainted(false);
         b3.setBorder(new LineBorder (Color.BLACK));
         b3.addActionListener(this);
        setTitle("The Main Menu");
//        setSize(1920,1080);
       
        setMinimumSize(new Dimension(1920,1080));
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        pack();
        add(b1);
        add(b3);

      JLabel menulabel= new JLabel();
      add(menulabel);
      menulabel.setBounds(0, 0, 1920,1080);
      ImageIcon ii = new ImageIcon("sprites/MBG.png");
      menulabel.setIcon(ii);     
        
       }


    @Override
       public void actionPerformed(ActionEvent e)
       {
        if(e.getSource()==b1){
           
         Game g=new Game();
         g.setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
            
        }

        
        else if (e.getSource()==b3)
        {
            System.exit(0);
            dispose();
          

        }
        
       
    }  
}