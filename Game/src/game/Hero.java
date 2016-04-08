package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Creates hero class, with body shape and image, as well as pickup methods
 */
 public class Hero extends Walker//creates hero/ship class with body shape and image
 {
    private static final Shape shape = new PolygonShape(-1.43f,0.6f, 1.47f,0.16f, 1.28f,-0.18f, -1.3f,-0.18f);
    private static final BodyImage image = new BodyImage("Data/xwing.gif", 1.5f);
    
    private int fuelCount;
    private int hitCount;
    private int rocketCount;
    private int currentspeed;
    private static SoundClip destSound;
     
    public Hero(World w) //sets variable values and movement for ship to move upon start of game and constantly
    {
        super(w, shape);
        addImage(image);
        rocketCount = 0;
        fuelCount = 0;
        hitCount = 2;
        currentspeed = 15;
        startWalking(currentspeed);
    }
    
    static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX3.wav");
         } 
         catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }        
    }
    
    public int hit()//hit count method
    {
        return hitCount;        
    }
    
    public void hitShip()//method to reduce hit count upon ship being hit, printing a message in game 
    {
        if (hitCount == 2)
        {
            hitCount--;
            System.out.println("Avoid the ships or you will die");
        }
        else if (hitCount == 1)
        {
            hitCount--;
            System.out.println("Last chance don't hit another!");
        }
        else if (hitCount == 0)
        {
            System.exit(0);
        }    
    }
    
    public int rockPickupCount()//returns current amount of rocket pickups
    {
        return rocketCount;
    }
 
    public void rockPickup()//adds a rocket pickup point to rocket count
    {
        rocketCount++;
        System.out.println("Rockets collected = " + rocketCount);
    }  
    
    public int pickupFuelCount()//returns current amount of fuel pickups
    {
        return fuelCount;
    }
    
    public void fuelPickup()//adds a fuel pickup point to fuel count
    {
        fuelCount++;
        System.out.println("Fuel collected = " + fuelCount);
    } 
    
    public int currentspeed()
    {
        return currentspeed;
    }
    
    public void slowPickup()
    {
        currentspeed=currentspeed-10;
        System.out.println("Speed slowed down"+ currentspeed);
    }
    
    @Override
   public void destroy()
   {
      destSound.play();
      super.destroy();   
   }
}
