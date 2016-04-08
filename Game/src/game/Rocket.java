package game;

import city.cs.engine.*;
/**
 * Creates rocket pickup class with fixture and image
 */
public class Rocket extends DynamicBody//creates rocket pickup class
{        
   public Rocket(World w) // creates rocket shape and fixture with image
    {
        super(w);
        Shape rocketShape = new PolygonShape(-0.457f,0.247f, -0.46f,-0.275f, 0.179f,-0.28f, 0.453f,0.026f, 0.166f,0.249f);
        Fixture fixture = new SolidFixture(this, rocketShape);
        
        addImage(new BodyImage("Data/Rocket.gif", 1f)); 
    } 
}
