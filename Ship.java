/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.awt.Point;

/**
 *
 * @author User
 */
public class Ship 
{public Point position=new Point();
public int Speed;
String Image;
KillingRocket Rocket=new KillingRocket();
public Ship(String Image)
{
    Speed=5;
        this.Image=Image;
        Rocket.ImgPath="E:\\Desktop\\JAVAPROGRAMS\\rocket.gif";
    }
    void MoveToRight() {
        
        this.position.x+=Speed;
    }
      void MoveToLeft() {
        this.position.x-=Speed;
    }

    public void fireBullet() 
    {
        Rocket.position.x=this.position.x+60;
        Rocket.position.y=this.position.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
