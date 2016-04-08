package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Creates collision listener class for the Rocket pickup
 */

public class RocketPickup implements CollisionListener //collision for pickup to change when collision with hero/ship
{
    private Hero hero;
    private static SoundClip destSound;
    
    public RocketPickup(Hero hero) 
    {
        this.hero = hero;
    }
    static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX6.wav");
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
            hero.rockPickup();
            destSound.play();
            e.getReportingBody().destroy();
        }
    }
    
}