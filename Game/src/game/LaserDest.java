package game;

import city.cs.engine.*;
/**
 * Creates collision class for laser
 */
public class LaserDest implements CollisionListener //collision for pickup to change when collision with hero/ship
{
    private Laser laser;
    private Tie tie;
    
    public LaserDest(Laser laser) 
    {
        this.laser = laser;
        this.tie = tie;
    }

    @Override
    public void collide(CollisionEvent e) //fuel pickup collision for hero/ship
    {
        if (e.getOtherBody() instanceof Tie)
        {
            e.getOtherBody().destroy();
            laser.destroy();
        }
    }
    
}