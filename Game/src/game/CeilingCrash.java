package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Class for ceiling collision, it creates the collision event for hero colliding with the ceiling
 */
public class CeilingCrash implements CollisionListener//class for ceiling collision crash with ship
{
    private Ceiling ceiling;
    
    public CeilingCrash(Ceiling ceiling)
    {
        this.ceiling = ceiling;
    }
    
    @Override
    public void collide (CollisionEvent e)//creates the collision event for the hero colliding with ceiling
    {
        if(e.getOtherBody() instanceof Hero)
        {
        e.getOtherBody().destroy();
        System.out.println("GAME OVER");
        }
        else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
    }    
}