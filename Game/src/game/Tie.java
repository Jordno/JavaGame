package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Creates Tie class with fixtures, adjusted density and image
 */
public class Tie extends Walker
{
   private static SoundClip destSound;
   
   public Tie(World w) // creates tie fighter shape and fixtures with adjusted density and image
    {
        super(w);
        //right side fixture
        Shape tieRShape = new PolygonShape(-0.39f,1.3f, 1.26f,1.28f,
        1.25f,-1.29f, -0.39f,-1.28f);
        Fixture Rfixture = new SolidFixture(this, tieRShape);
        Rfixture.setDensity(100);
        //left side fixture
        Shape tieLShape = new PolygonShape(-0.39f,1.18f, -1.11f,1.17f,
        -1.11f,-1.1f, -0.42f,-1.11f);
        Fixture Lfixture = new SolidFixture(this, tieLShape);
        Lfixture.setDensity(100);
        
        addImage(new BodyImage("Data/Tie.gif", 4f));       
    }
   
   static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX1.wav");
         } 
         catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }        
    }
   
   @Override
   public void destroy()
   {
      destSound.play();
      super.destroy();   
   }
   
}
