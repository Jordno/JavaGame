package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Creates collisionlistener for the deathstar and the pickup count required
 */
public class StarCrash implements CollisionListener
{
     private Hero hero;
     
     public StarCrash(Hero hero)
     {
         this.hero = hero;
     }
     
     @Override
    public void collide(CollisionEvent e) //fuel pickup collision for hero/ship
    {
        if (e.getOtherBody() == hero && hero.rockPickupCount()>=3) 
        {
            System.out.println("You destroyed the deathstar!");
            e.getReportingBody().destroy();
        }
        else if(e.getOtherBody() == hero && hero.rockPickupCount()<=2)
        {
            System.out.println("Collect more rockets, to destroy the deathstar");
            hero.destroy();
        }
    }
}
