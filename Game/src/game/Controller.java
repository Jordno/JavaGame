package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
/**
 * Controller class for the game hero, including keyadapter and action listener for timer
 */
public class Controller extends KeyAdapter implements ActionListener //Controller class for game, including Keyadapter and action listener for timer
{   
    private Walker body;
    private GameLevel world;
    private Timer timer;
    private boolean canFire;
   
    private static SoundClip destSound;
   
   static 
    {
        try 
         {
           destSound = new SoundClip("data/SFX5.wav");
         } 
         catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) 
         {
           System.out.println(e);
         }        
    }
   
    public Controller(Walker body, GameLevel world)
    {
            this.body = body;
            this.world = world;
            timer = new Timer(2000, this);
            canFire = true;
    }
        
    public boolean canFire()//returns true or false if ship can fire
    {
        return canFire;         
    }
       
    @Override
    public void keyPressed(KeyEvent e)//creates key presses
    {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) //Q = quits the game
        { 
            System.exit(0);
        }
        else if (code == KeyEvent.VK_W) // W = move up
        { 
            body.setLinearVelocity(new Vec2(2,10));
            body.startWalking(15);            
        } 
        else if (code == KeyEvent.VK_S) // S = move down
        {
            body.setLinearVelocity(new Vec2(-2,-10));
            body.startWalking(15);           
        }
        else if (code == KeyEvent.VK_SPACE) // Space = shoot and sets timer to start upon fire and reset after 2 seconds
        {
            if (canFire)
            {
                Laser laser = new Laser(world);
                laser.setPosition(body.getPosition());
                laser.setLinearVelocity(new Vec2(100,0));
                laser.addCollisionListener(new LaserDest(laser));
                destSound.play();
                canFire = false; 
            }     
            timer.start();    
        }
    } 
    
    public void setBody(Walker body) 
    {
        this.body = body;
    }
    
    public void setWorld(GameLevel world)
    {
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent e) //sets fire to true allowing player to shoot
    {
        canFire = true;
    }
}
