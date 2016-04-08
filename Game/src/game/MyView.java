package game;

import city.cs.engine.*;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * Creates MyView class that sets the background image for each level
 */
public class MyView extends UserView
{
    private Game game;
    private Image background;
    private Hero hero;
    
    private Image Level1BG = new ImageIcon("data/space.jpg").getImage();
    private Image Level2BG = new ImageIcon("data/Field.jpg").getImage();
    private Image Level3BG = new ImageIcon("data/Death.jpg").getImage();
    private Image Level4BG = new ImageIcon("data/End.jpg").getImage();
    
    public MyView(World world, Hero hero, int width, int height, Game game)
    {
        super(world, width, height);
        this.game = game;
      
    }
    
    public void updatePlayer(Hero hero)
    {
        this.hero=hero;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) 
    {
        if (game.getLevel() == 1) 
        {
            background = Level1BG;
        }
        else if(game.getLevel() == 2)
        {
            background = Level2BG;
        }
        else if(game.getLevel() == 3)
        {
            background = Level3BG;
        }
        else if(game.getLevel() == 4)
        {
            background = Level4BG;
        }
        g.drawImage(background, 0, 0, this);
    }
}