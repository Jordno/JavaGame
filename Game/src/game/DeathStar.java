package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Creates Deathstar class, with fixtures and adjusted density and image
 */
public class DeathStar extends Walker //creates deathstar class
{
    private static SoundClip destSound;
           
   public DeathStar(World w) // creates deathstar shape and fixtures with adjusted density and image
    {
        super(w);
        Shape starRShape = new PolygonShape(-0.23f,7.94f, 5.85f,5.51f, 7.97f,0.09f, 5.85f,-5.49f, 0.0f,-7.94f);
        Fixture Rfixture = new SolidFixture(this, starRShape);
        Rfixture.setDensity(100);
        //left side fixture
        Shape starLShape = new PolygonShape(-2.84f,7.54f, -6.43f,5.01f, -7.82f,0.43f, -7.24f,-3.73f, -2.97f,-7.46f, -0.15f,-7.94f, -0.35f,7.92f);
        Fixture Lfixture = new SolidFixture(this, starLShape);
        Lfixture.setDensity(100);
        
        addImage(new BodyImage("Data/Deathstar.gif", 22f)); 
    } 
   
   static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX2.wav");
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