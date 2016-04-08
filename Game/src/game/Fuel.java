package game;

import city.cs.engine.*;
import java.awt.Color;

/**
 * Creates fuelpickup class with body and colour
 */
public class Fuel extends DynamicBody //creates fuel pickups, body and colour
{
    private static final Shape fuelShape = new CircleShape(0.25f);
   
    public Fuel(World w) 
    {
        super(w, fuelShape);
        setFillColor(Color.YELLOW);
    }
}
