package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;
/**
 * Ceiling class, which creates the body, sets the position and adds a collision listener(ceilingCrash.java)
 */
public class Ceiling extends StaticBody//ceiling class
{
    public Ceiling (World w)//creates body for game ceiling, sets it's position and adds its collision listener(ceilingCrash.java)
    {
        super(w);
        Shape ceilingShape = new BoxShape(100, 5f);
        
        Body ceiling = new StaticBody(w, ceilingShape);
        ceiling.setFillColor(Color.GRAY);
        ceiling.setPosition(new Vec2(30, 25f)); 
        ceiling.addCollisionListener(new CeilingCrash(this));
    }
    
}
