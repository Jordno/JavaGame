package game;

import city.cs.engine.*;
/**
 * Creates Laser class, with fixtures and image
 */
public class Laser extends DynamicBody //creates Laser class
{  
   public Laser(World w) // creates laser shape and fixture with image
    {
        super(w);
        Shape laserShape = new PolygonShape(-0.457f,0.234f, 0.469f,0.234f, 0.47f,-0.127f, -0.459f,-0.13f);
        Fixture fixture = new SolidFixture(this, laserShape);
        
        addImage(new BodyImage("Data/Laser.png", 1f)); 
    } 
}
