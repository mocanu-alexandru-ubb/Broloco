import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Overlord
{
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World Main_menu)
    {
        Font font = new Font("Courier New", true, false, 50);
        getImage().setFont(font);
        getImage().setColor(Color.WHITE);
        getImage().drawString("Press enter to start", 340, 530);
    }

    int transparency = 254;
    int sign = -3;
    
    public void act() 
    {
        getImage().setTransparency(transparency);
        transparency += sign;
        if (transparency == 11 || transparency == 254) sign *= -1;
        
        if (Greenfoot.isKeyDown("enter"))
        {
            Template aux = (Template)getWorld();
            aux.get_sfx().play_bgm(0);

            My_world map = new My_world(aux.get_sfx());

            black bl = new black();
            bl.set_action(1);
            bl.set_map(map);
            getWorld().addObject(bl, 640, 384);
        }
    }    
}
