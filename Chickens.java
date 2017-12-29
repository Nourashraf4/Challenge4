/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.awt.Color;

/**
 *
 * @author User
 */
public class Chickens
{ public int x, y;
int speedx;
Color CurrentColor;
public String image="E:\\Desktop\\JAVAPROGRAMS\\chicken invaders\\BigChicken.png";
public Chickens(int x, int y,int speedx)
{
this.x=x;
this.y=y;
this.speedx=speedx;
int XEGG=50;
    int YEGG=50;
    int SPEEDEGG=10;
}
public void move()
{ 
   if(x+1>x+10)
   {
         speedx= -speedx;
   }
}
    
}
