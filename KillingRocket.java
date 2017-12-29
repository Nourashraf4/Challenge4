/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author User
 */
public class KillingRocket implements Runnable
{ public Point position=new Point();
public String ImgPath;
  public Color CurrentColor;
    public int Speed;
    public KillingRocket()
    {
        Speed=30;
    }
    public void move()
    {
     position.y-=Speed;   
    }

    @Override
    public void run() 
    {
  for (int i=0;i<200;i++)
        {
            move();
            try
            {
                Thread.sleep(10);
            } 
            catch (InterruptedException ex) 
            {
                
            }
    }
    }
}
    
