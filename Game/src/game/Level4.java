package game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 *
 * Creates level 4 class with populate method and start/door positions
 */
public class Level4 extends GameLevel
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
       
        for (int i = 0; i < 1; i++)//creates and sets destroyers
        {
            DeathStar deathstar = new DeathStar(this);
            deathstar.setPosition(new Vec2(120,2));
            deathstar.setGravityScale(0);
            deathstar.addCollisionListener(new StarCrash(getPlayer()));
        }
        
        {
            for (int i = 0; i < 7; i++) //creates fuel pickups in world in random locations 
            {
                Rocket rocket = new Rocket(this);
                Random random = new Random();
                rocket.setPosition(new Vec2(i * 20 + 10, random.nextFloat() * 10f));
                rocket.addCollisionListener(new RocketPickup(getPlayer()));
                rocket.setGravityScale(0);
            }
        } 
        
        for (int i = 0; i < 30; i++)//creates tie fighters
        {
            int pos1;
            int pos2;
            pos1=(int)(110*Math.random()-10);
            pos2=(int)(30*Math.random()-10);
            Tie tie = new Tie(this);
            tie.setPosition(new Vec2(pos1,pos2));
            tie.setGravityScale(0);
            tie.addCollisionListener(new TieCrash(getPlayer()));
        }
        
        for (int i = 0; i < 12; i++)//creates and sets destroyers
        {
            int pos1;
            int pos2;
            pos1=(int)(110*Math.random()-10);
            pos2=(int)(30*Math.random()-10);
            Destroyer destroyer = new Destroyer(this);
            destroyer.setPosition(new Vec2(pos1,pos2));
            destroyer.setGravityScale(0);
            destroyer.addCollisionListener(new DestCrash(destroyer));
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
