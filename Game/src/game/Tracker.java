package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * Creates Step listener class that follows Hero.java in game
 **/

//creates a class for a tracker to follow the character
public class Tracker implements StepListener 
{
    //view varialbe for the tracker
    private WorldView view;
    //body variable tracker follows
    private Body body;

    public Tracker(WorldView view, Body body) 
    {
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) 
    {
    }

    @Override
    public void postStep(StepEvent e) 
    {
        float x = body.getPosition().x;
        float y = view.getCentre().y;
        view.setCentre(new Vec2(body.getPosition()));
    }
    
    public void setBody(Walker body) 
    {
        this.body = body;      
    }
    
}
