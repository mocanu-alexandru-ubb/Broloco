import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Black_White_filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class black extends Overlord
{
    /**
     * Act - do whatever the Black_White_filter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int sign = 1;
    int counter = 1;
    int route = -1;
    World map = null;
    int poke_id = -1;
    int poke = -1;
    
    public void set_action (int act) {route = act;}
    
    public void set_map (World mapp) {map = mapp;}
    
    public void set_for_fight (int a, int b) {poke_id = a; poke = b;}
    
    public void take_action ()
    {
        if (route == 1)
        {
            Greenfoot.setWorld(map);
        }
        if (route == -1)
        {
            Template wrld = (Template)getWorld();
            wrld.get_player().set_state("static");
            wrld.removeObject(this);
        }
        if (route == 2)
        {
            black bl = new black();
            bl.set_action(3);
            bl.reverse();
            bl.set_for_fight(poke_id, poke);
            
            Template wrld = (Template)getWorld();
            wrld.get_txt().activate(poke_id, poke);
            wrld.get_sfx().play_bgm(1);
            
            wrld.addObject(bl, 640, 384);
            wrld.removeObject(this);
        }
        if (route == 3)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void reverse ()
    {
        sign = -1;
        counter = 255;
    }
    
    public void act() 
    {
        getImage().setTransparency(counter);
        counter += 3 * sign;
        if (counter == 250 || counter == 0) take_action();
    }    
}
