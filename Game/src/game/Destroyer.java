package game;

import city.cs.engine.*;
/**
 * Creates Destroyer class with fixtures, adjusted density and image
 */
public class Destroyer extends Walker //destroyer enemy ship class
{
    private int destCount;
           
   public Destroyer(World w) // creates destroyer shape and fixtures with adjusted density and image
    {
        super(w);
        destCount = 2;
        //right side fixture
        Shape destRShape = new PolygonShape(-0.66f,-0.82f, 0.86f,-2.22f, 4.04f,-2.16f,
        5.78f,-1.44f, 3.22f,1.72f, 1.54f,1.62f);
        Fixture Rfixture = new SolidFixture(this, destRShape);
        Rfixture.setDensity(100);
        //left side fixture
        Shape destLShape = new PolygonShape(-5.5f,-1.72f, -0.6f,-0.8f, 0.72f,-2.22f, -5.24f,-2.18f);
        Fixture Lfixture = new SolidFixture(this, destLShape);
        Lfixture.setDensity(100);
        
        addImage(new BodyImage("Data/Destroyer.gif", 8f)); 
    } 
   
}