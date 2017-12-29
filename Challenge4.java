/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Challenge4 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
             Task []ArrayTasks=new Task[100];
        JOptionPane.showMessageDialog(null, "HI ,Don't let the Easter Eggs touch the Ship\n  press Space to get the Rocket "
                + "and Kill These Chickens"
                , "Info", JOptionPane.OK_OPTION);
         
        for (int i=0;i<100;i++)
        {
            ArrayTasks[i]=new Task(i);
            
        }
        for (int i=0;i<100;i++)
        {
            ArrayTasks[i].start();
            
        }
        
        JFrame jf=new JFrame();
        jf.setSize(500, 500);
        
        Motion Motion_Object=new Motion();
       Motion_Object.Chicken.add(new Chickens(2,5,2));
        Motion_Object.Chicken.add(new Chickens(120,5,2));
        Motion_Object.Chicken.add(new Chickens(240,5,2));
        Motion_Object.Chicken.add(new Chickens(360,5,2));
      //  Motion_Object.Chicken.add(new Chickens(10,200,2));
        
        jf.add(Motion_Object);
        Motion_Object.setFocusable(true);
        Thread t1=new Thread(Motion_Object);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
