package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Creates collision listener class for Rock.java
 */
public class rockCrash implements CollisionListener// rock/asteroid collision for rock.java with added message
{
     private Rock rock;
     
     public rockCrash(Rock rock)
     {
         this.rock = rock;
     }
     
     @Override
     public void collide (CollisionEvent e)
     {
         if(e.getOtherBody() instanceof Hero)
         {
            e.getOtherBody().destroy();
            System.out.println("GAME OVER");
            System.out.println("Avoid the asteroids");
         }
         else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
     }
}
