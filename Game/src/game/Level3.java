package game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 *
 * Creates level 3 class with populate method and start/door positions
 */
public class Level3 extends GameLevel
{
    
    private Ground ground;
    private Ceiling ceiling;
    
    @Override
    public void populate(Game game)
    {
        super.populate(game);
       
        { // make the ground in the world 
            ground = new Ground(this);
        }
        
        { // make the ceiling in world
            ceiling = new Ceiling(this);
        }
       
        for (int i = 0; i < 25; i++)//creates and sets destroyers
        {
            int pos1;
            int pos2;
            pos1=(int)(140*Math.random()-10);
            pos2=(int)(30*Math.random()-10);
            Destroyer destroyer = new Destroyer(this);
            destroyer.setPosition(new Vec2(pos1,pos2));
            destroyer.setGravityScale(0);
            destroyer.addCollisionListener(new DestCrash(destroyer));
        }
        
        {
            for (int i = 0; i < 7; i++) //creates fuel pickups in world in random locations 
            {
                Fuel fuel = new Fuel(this);
                Random random = new Random();
                fuel.setPosition(new Vec2(i * 20 + 10, random.nextFloat() * 10f));
                fuel.addCollisionListener(new Pickup(getPlayer()));
                fuel.setGravityScale(0);
            }
        }     
    }
    
    
    @Override
    public Vec2 startPosition() 
    {
        return new Vec2(-25,0);
    } 
    
    @Override
    public Vec2 doorPosition()
    {
        return new Vec2(135,5);
    }
    
}
