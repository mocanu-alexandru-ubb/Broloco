import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Overlord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlord extends Actor
{
    /**
     * Act - do whatever the Overlord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static final int cell = 64;
    
    static Map<String, Boolean> keyboard = new HashMap<String, Boolean>();
    String[] pressed_keys = new String[26];
    int pressed_keys_size = 0;
    
    public void refresh_keys ()
    {
        while (pressed_keys_size > 0 && !Greenfoot.isKeyDown(pressed_keys[pressed_keys_size]))
        {
            keyboard.put(pressed_keys[pressed_keys_size], false);
            pressed_keys_size--;
        }
    }

    public boolean pressed (String key)
    {
        if (Greenfoot.isKeyDown(key))
        {
            if (!keyboard.get(key))
            {
                keyboard.put(key, true);
                pressed_keys[++pressed_keys_size] = key;
                return true;
            }
        }
        return false;
    }

    public void addedToWorld (World Template)
    {
        keyboard.put("escape", false);
        keyboard.put("enter", false);
        keyboard.put("e", false);
        keyboard.put("up", false);
        keyboard.put("down", false);
        keyboard.put("right", false);
        keyboard.put("left", false);
    }
}
