/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Motion extends JPanel implements Runnable 
{
 public ArrayList<Chickens>Chicken=new ArrayList<Chickens>(24);
  
   public Ship Playing_Ship=new Ship("E:\\Desktop\\JAVAPROGRAMS\\chicken invaders\\ship.jpg");
 //  public Chickens far5a=new Chickens(100,50,10);
   int XGLOBAL=20;
   public static int []A={120,240,360};
   int Counter=0;
   JLabel Score;
    int YGLOBAL=0;
    Boolean Collision=false;
    public Motion()
    {
        Playing_Ship.position.x=220;
        Playing_Ship.position.y=340;
     this.addKeyListener(new keylist());
    //  Chicken.add(far5a);
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent ke) 
        {}

        @Override
        public void keyPressed(KeyEvent ke) 
        {
            if(ke.getKeyCode()==KeyEvent.VK_LEFT)
            {
                Playing_Ship.MoveToLeft();
            }
            if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                Playing_Ship.MoveToRight();
            }
            if(ke.getKeyCode()==KeyEvent.VK_SPACE)
            {
             Playing_Ship.fireBullet();
            }
        }
        @Override
        public void keyReleased(KeyEvent ke)
        {}
    }
    public void paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 1000, 1000);   
         BufferedImage Chicken_Image=null;
         BufferedImage Egg=null;
         BufferedImage Egg2=null;
     try 
     {
        
              Chicken_Image=ImageIO.read(new File("E:\\Desktop\\JAVAPROGRAMS\\chicken invaders\\BigChicken.png"));
         //g.drawImage(Chicken_Image,far5a.x,far5a.y,null);   
              Egg = ImageIO.read(new File("E:\\Desktop\\JAVAPROGRAMS\\chicken invaders\\Egg.png"));
               Egg2 = ImageIO.read(new File("E:\\Desktop\\JAVAPROGRAMS\\chicken invaders\\Egg.png"));
        BufferedImage ShipImage = ImageIO.read(new File(Playing_Ship.Image));
         g.drawImage(ShipImage,Playing_Ship.position.x, Playing_Ship.position.y, null);
         BufferedImage RocketImage = ImageIO.read(new File(Playing_Ship.Rocket.ImgPath));
         g.drawImage(RocketImage,Playing_Ship.Rocket.position.x, Playing_Ship.Rocket.position.y, null);
         g.drawImage(Egg,XGLOBAL, YGLOBAL, this);
         g.drawImage(Egg2,XGLOBAL+100, YGLOBAL, this);
         
     }
     catch (IOException ex)
     {} 
     int j=0;
    
     for (Chickens A_Chicken: Chicken)
     {
         MovingEggs();
         
           // g.setColor(A_Chicken.CurrentColor);
           // g.fillOval(A_Chicken.x,A_Chicken.y, 50, 50);
            g.drawImage(Chicken_Image, A_Chicken.x, A_Chicken.y, null);
             
            if (Playing_Ship.Rocket.position.distance(A_Chicken.x, A_Chicken.y)<Playing_Ship.Rocket.position.getY())
            { 
           // j++;
                Score=new JLabel();
                  Counter++;
                Score.setText(String.valueOf("Counter"));
                Score.setBounds(100, 300, 100, 100);
                  //add(Score);
                Chicken.remove(A_Chicken);
                break;
            }
             
    }
    }
    @Override
    public void run()
    {
    try
    {
    while(true)
    {
        for (Chickens A_Chicken: Chicken)
        {
            A_Chicken.move(); 
        }    
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    public void MovingEggs()
    {
        YGLOBAL++;
        System.out.println("Playing_Ship.position.y"+Playing_Ship.position.getLocation());
        System.out.println("YGLOBAL "+YGLOBAL);
        if(Playing_Ship.position.x==YGLOBAL)
        {
          JOptionPane.showMessageDialog(null, "Mabrouk mat5btch :D", "Error", JOptionPane.ERROR_MESSAGE);
          Collision=false;
        }
    }
}
