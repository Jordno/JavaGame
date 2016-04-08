package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Creates collision class for Destroyer
 */
public class DestCrash implements CollisionListener //creates crash with destroyer class
{
     private Destroyer destroyer;
     
     public DestCrash(Destroyer destroyer)
     {
         this.destroyer = destroyer;
     }
     
     @Override
     public void collide (CollisionEvent e) //creates destroyer collision with ship and in game message
     {
     if(e.getOtherBody() instanceof Hero)
         {
            e.getOtherBody().destroy();
            System.out.println("GAME OVER");
            System.out.println("Avoid the destroyers");
         }
        else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
     }
}
