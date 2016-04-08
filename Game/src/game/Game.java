package game;
import java.awt.BorderLayout;
import javax.swing.*;
/**
 * Creates main game class, with nextLevel method
 */
public class Game //creates game class
{

    //World for the characters to move and objects to be placed
    private GameLevel world;
    //Display of the world
    private MyView view;
    //sets the level
    private int level;
    //sets the controller
    private Controller controller;
    //sets the camera
    private Tracker tracker;
    //sets the label
    private ControlPanel buttons;
    //sets the frame for GUI
    private JFrame frame;
    //sets the view for the world
    private MyView wideView;
    
    public Game() //game method that sets and creates the game world
    {
        
        //world = new GameWorld();
        level = 1;
        world = new Level1();
        world.populate(this);
        
        //creates a view window
        view = new MyView(world, world.getPlayer(), 1400, 625, this);
        //adds a grid to view
        //view.setGridResolution(1);
        // display the view in a frame
        frame = new JFrame("First world");
        
        buttons = new ControlPanel(world.getPlayer());
        
        frame.setLocationByPlatform(true);
        // display the world in a window
        frame.add(view);
        frame.add(buttons, BorderLayout.NORTH);
        frame.setFocusable(true);
        
        world.addStepListener(buttons);
        
        frame.setResizable(true);
         // add a wide angle view of the world
        wideView = new MyView(world, world.getPlayer(), 500, 100, this);
        wideView.setWorld(world);
        wideView.setZoom(4);
        frame.add(wideView, BorderLayout.SOUTH);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible to the user
        frame.setVisible(true);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // creates a debugging window
        //JFrame debugView = new DebugViewer(world, 500, 500);
        // enables the controllers/keylistener for the hero
        controller = new Controller(world.getPlayer(),world);
        frame.addKeyListener(controller);
        // camera follows player through game
        tracker = new Tracker(view, world.getPlayer());
        world.addStepListener(tracker);
        // creates the world
        world.start();   
    }
    
    public Hero getPlayer()
    {
        return world.getPlayer();
    }
    
    public void nextLevel() //next level method, creating and changing the level
    {
        world.stop();
        if (level == 4) 
        {
            System.exit(0);
        } 
        else if (level == 1) 
        {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // switch keyboard control for the laser
            controller.setWorld(world);
            // set the camera in the new world
            tracker.setBody(world.getPlayer());
            // show the new world in the view'
            view.setWorld(world);
            //set camera for next levels
            tracker = new Tracker(view, world.getPlayer());
            wideView.setWorld(world);
            wideView.setZoom(4);
            wideView.updatePlayer(world.getPlayer());
            world.addStepListener(tracker);
            //start the world
            world.start();
            System.out.println("Level 2!");
        }
        else if (level == 2)
        {
             level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // switch keyboard control for the laser
            controller.setWorld(world);
            // set the camera in the new world
            tracker.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            //set camera for next levels
            tracker = new Tracker(view, world.getPlayer());
            wideView.setWorld(world);
            wideView.setZoom(4);
            wideView.updatePlayer(world.getPlayer());
            world.addStepListener(tracker);
            //start the world
            world.start(); 
            System.out.println("Level 3!");
        }
        else if (level == 3)
        {
             level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // switch keyboard control for the laser
            controller.setWorld(world);
            // set the camera in the new world
            tracker.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            //set camera for next levels
            tracker = new Tracker(view, world.getPlayer());
            wideView.setWorld(world);
            wideView.setZoom(4);
            wideView.updatePlayer(world.getPlayer());
            world.addStepListener(tracker);
            //start the world
            world.start(); 
            System.out.println("Level 4!");
        }
    }
    
    public int getLevel() //returns the current level
    {
        return level;
    }

   //Runs the game
    public static void main(String[] args) //starts the game
    {
        new Game();
    }
}
    
