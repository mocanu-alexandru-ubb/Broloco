import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class effect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class effect extends Overlord
{
    /**
     * Act - do whatever the effect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String anim = "scratch";
    int cell = 0;

    public void set_anim (String name)
    {
        anim = name;
        GreenfootSound sf = new GreenfootSound(name + ".wav");
        sf.setVolume(60);
        sf.play();
    }

    public void act() 
    {
        if (cell == 39) 
        {
            GreenfootSound so = new GreenfootSound("hit.wav");
            so.setVolume(70);
            so.play();
            getWorld().removeObject(this);
        }
        if (cell < 35 && cell % 5 == 0)
            setImage(anim + cell / 5 + ".png");
        cell++;
    }    
}
