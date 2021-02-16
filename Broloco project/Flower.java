import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Flower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flower extends Overlord
{
    /**
     * Act - do whatever the Flower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = new Random().nextInt(140);
    //int counter = 0;

    Random rand = new Random();
    int cell = rand.nextInt(3);
    
    public void act() 
    {
        if (counter % 20 == 0)
        {
            setImage("flower" + cell + "_" + counter / 20 + ".png");
        }
        counter += 1;
        if (counter == 141) counter = -19;
    }    
}
