package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Creates collision listener class for Tie 
 */
public class TieCrash implements CollisionListener
{
     private Hero hero;
     private Tie tie;
     
     
     public TieCrash(Hero hero)
     {
         this.hero = hero;
         this.tie = tie;
     }
     
     @Override
    public void collide(CollisionEvent e) //fuel pickup collision for hero/ship
    {
        if (e.getOtherBody() == hero) 
        {
            hero.hitShip();
            e.getReportingBody().destroy();
        }
    }
}
