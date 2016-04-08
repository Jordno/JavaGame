package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Creates collsionlistener class for the pickup
 */
public class Pickup implements CollisionListener //collision for pickup to change when collision with hero/ship
{
    private Hero hero;
    private static SoundClip destSound;
    
    public Pickup(Hero hero) 
    {
        this.hero = hero;
    }
    
    static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX4.wav");
         } 
         catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }        
    }

    @Override
    public void collide(CollisionEvent e) //fuel pickup collision for hero/ship
    {
        if (e.getOtherBody() == hero) 
        {
            hero.fuelPickup();
            destSound.play();
            e.getReportingBody().destroy();
        }
        else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
    }    
}