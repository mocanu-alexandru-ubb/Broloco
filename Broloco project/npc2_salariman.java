import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc2_salariman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc2_salariman extends NPC
{
    /**
     * Act - do whatever the npc2_salariman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    String[] alf = {
            "Ahahah!",
            "How come a little boy like you traveled to the only bread factory across the land?",
            "Many others tried to get a piece of one of my delicious breads.",
            "Just as many have  managed to...",
            "...fail.",
            "end",
            "1" };

    String[] alf_2 = {
            "Salariman",
            "Ugh, defeated by a kid..." };

    Player pl = null;

    public void addedToWorld (World Map_3)
    {
        set_dia(alf, alf_2, 4);
    } 

    public void act ()
    {
        if (pl == null)
        {
            Template wrld = (Template)getWorld();
            pl = wrld.get_player();
        }
        else
        {
            alf[2] = "" + ((pl.get_poke() + 2) % 3); 
            set_dia(alf, alf_2, 4);
        }
    }
}
