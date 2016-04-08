package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 *
 * Creates GameLevel class 
 */
public abstract class GameLevel extends World //creates the gamelevel class
{
    private Hero hero;
    private Game game;
    
    public void populate(Game game) //method to populate the game world
    {
        hero = new Hero(this);
        hero.setPosition(startPosition());
        hero.setGravityScale(0);
        WormHole wormHole = new WormHole(this);
        wormHole.setPosition(doorPosition());
        wormHole.addCollisionListener(new DoorListener(game));
        this.game = game;
    }
    
    public abstract Vec2 startPosition(); //sets ship start position
    
    public abstract Vec2 doorPosition(); //sets door position
    
    public Game getGame()
    {
        return game;
    }
    
    public Hero getPlayer()
    {
        return hero;
    }
    
}
