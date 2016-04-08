package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 *
 * Crash class ground collision
 */
public class Crash implements CollisionListener //creates crash with ground collision class
{
    private Ground ground;

    public Crash(Ground ground)
    {
        this.ground = ground;
    }
    
    @Override
    public void collide (CollisionEvent e) //creates ground collision with ship and in game message
    {
        if(e.getOtherBody() instanceof Hero)
         {
            e.getOtherBody().destroy();
            System.out.println("GAME OVER");
            System.out.println("Avoid the ground");
         }
        else if(e.getOtherBody() instanceof Laser)
        {
            e.getOtherBody().destroy();
        }
    }
    
}
