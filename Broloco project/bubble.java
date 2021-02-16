import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bubble extends Collision
{
    /**
     * Act - do whatever the bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int variant = 0;
    
    bubble (int i)
    {
        variant = i;
    }
    
    int counter = 0;
    
    public void act() 
    {
        if (counter % 5 == 0) setImage("lava_bubble" + variant + "_" + counter / 5 + ".png");
        counter++;
        if (counter == 49) getWorld().removeObject(this);
    }    
}
