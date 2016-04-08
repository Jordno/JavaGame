package game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 *
 * Creates level 2 class with populate method and start/door positions
 */
public class Level2 extends GameLevel
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
        {
           for (int i = 0; i < 40; i++)//creates and sets asteroids/rocks in random positions in world
            {
                int pos1;
                int pos2;
                pos1=(int)(140*Math.random()-10);
                pos2=(int)(30*Math.random()-10);
                Rock rock = new Rock(this);
                rock.setPosition(new Vec2(pos1, pos2));
                rock.addCollisionListener(new rockCrash(rock));
            }
        }
        
        for (int i = 0; i < 15; i++)//creates tie fighters
        {
            int pos1;
            int pos2;
            pos1=(int)(140*Math.random()-10);
            pos2=(int)(30*Math.random()-10);
            Tie tie = new Tie(this);
            tie.setPosition(new Vec2(pos1,pos2));
            tie.setGravityScale(0);
            tie.addCollisionListener(new TieCrash(getPlayer()));
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
