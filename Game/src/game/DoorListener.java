package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * Creates doorlistener class which moves hero to the next level
 */
public class DoorListener implements CollisionListener //creates next/end level doorlistener
{
    private Game game;
    
    public DoorListener(Game game)
    {
        this.game = game;
    }
    
    private static SoundClip destSound;
    
    static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX7.wav");
         } 
         catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }        
    }
    public void collide(CollisionEvent e) //door listener method moving player to the next level and ingame message
    {
        Hero player = game.getPlayer();
        if (e.getOtherBody() == player)
        {
            System.out.println("Next level!");
            destSound.play();
            game.nextLevel();
        }
        else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
    }
       
}
