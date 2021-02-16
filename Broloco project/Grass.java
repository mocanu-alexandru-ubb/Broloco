import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass extends Trigger
{
    boolean changed = false;
    int chance = -1;
    Random rand = new Random();
    Player pl = null;
    GreenfootSound bush = new GreenfootSound("bush_enter2.wav");

    public void addedToWorld(World Template)
    {
        bush.setVolume(70);
    }

    public void act() 
    {

        if (pl == null)
        {
            Template aux = (Template)getWorld();
            pl = aux.get_player();
            if (pl == null) return;
        }

        if (Math.abs(pl.getX() - getX()) < 20 && Math.abs(pl.getY() + 16 - getY()) < 32)
        {
            if (chance == -1)
            {
                chance = rand.nextInt(100);
                bush.play();
            }
            if (chance < 40)
            {
                chance = pl.start_combat(rand.nextInt(3));
            }
            setImage("Iarba.png");
            changed = false;
        }
        else
        {
            chance = -1;
            if (!changed) 
            {
                setImage("empty_64x64.png");
                changed = true;
            }
        }
    }    
}
