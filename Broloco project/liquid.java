import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class liquid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class liquid extends Collision
{
    /**
     * Act - do whatever the liquid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    String tile = "lake_middle";
    Random rand = new Random();
    
    liquid (String new_tile)
    {
        tile = new_tile;
    }
    
    public void act() 
    {
        if (rand.nextInt(1000) < 1 && tile == "lava_middle") getWorld().addObject(new bubble(rand.nextInt(2)), getX(), getY());
        if (counter % 50 == 0) setImage((tile + counter / 50) + ".png");
        counter = (counter + 1) % 99;
    }    
}
