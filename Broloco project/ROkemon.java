import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ROkemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ROkemon extends Overlord
{
    /**
     * Act - do whatever the ROkemon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int id;
    
    void set_poke (int poke_id, boolean is_enemy)
    {
        if (poke_id == 0) 
        {
            id = 0;
            if (is_enemy == true) setImage("pkmn_grass_chick.png");
            else setImage("pkmn_grass_chick_back.png");
        }
        
        else if (poke_id == 1) 
        {
            id = 1;
            if (is_enemy == true) setImage("firecoc1.png");
            else setImage("firecoc.png");
        }
        
        else if (poke_id == 2) 
        {
            id = 2;
            if (is_enemy == true) setImage("vaporel1.png");
            else setImage("vaporel.png");
        }
    }

    public int get_id ()
    {
        return id;
    } 
}
