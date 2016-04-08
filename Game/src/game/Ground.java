package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * Creates the ground class, setting colour, position and adding collision listener Crash.java
 */
public class Ground extends StaticBody //creates the ground class
{
    public Ground (World w)//creates the ground body and sets it's colour, position and adds the collision listener Crash.java
    {
        super(w);
        Shape groundShape = new BoxShape(100, 5f);
        
        Body ground = new StaticBody(w, groundShape);
        ground.setFillColor(Color.GRAY);
        ground.setPosition(new Vec2(30, -15f));
        ground.addCollisionListener(new Crash(this));
    }        
}
