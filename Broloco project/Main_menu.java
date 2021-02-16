import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main_menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main_menu extends Template
{

    /**
     * Constructor for objects of class Main_menu.
     * 
     */
    public Main_menu()
    {
        soundplayer sf = new soundplayer();
        sf.set_volume();
        set_sfx(sf, 6);
        addObject(new Menu(), 640, 364);
    }
    
    public void started()
    {
        get_sfx().play_bgm(6);
    }
    
    public void stopped()
    {
        get_sfx().close();
    }
}
