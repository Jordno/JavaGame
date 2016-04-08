package game;

import city.cs.engine.*;

/**
 *
 * Creates WormHole class with shape and image
 */
public class WormHole extends StaticBody 
{
    public WormHole(World w)
    {
        super(w, new BoxShape(0,500));
        addImage(new BodyImage("data/wormhole.gif", 35));
    }  
}
