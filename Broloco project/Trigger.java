import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trigger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trigger extends Overlord
{
    /**
     * Act - do whatever the Trigger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void do_something ()
    {
      getWorld().removeObject(this);  
    } 
    
    public void act() 
    {
        // Add your action code here.
    }    
}
