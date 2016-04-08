package game;

import city.cs.engine.*;
/**
 * Creates Rock class with fixture and image
 */
public class Rock extends StaticBody//creates rock class 
{
    public Rock(World w)// creates the rock/asteroid shape with a set image and fixture
    {
        super(w);
        Shape rockShape = new PolygonShape(0.1f,1.05f, 0.84f,0.82f, 1.08f,-0.01f,
        0.85f,-0.61f, 0.17f,-0.86f, -0.87f,-0.6f, -1.08f,0.09f, -0.81f,0.81f);
        Fixture fixture = new SolidFixture(this, rockShape);
        addImage(new BodyImage("Data/Rock.gif", 4f)); 
    }   
}