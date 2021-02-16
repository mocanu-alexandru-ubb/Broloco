import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc_factory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc_factory extends NPC
{
    /**
     * Act - do whatever the npc_factory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    String[] alf = {
            "Factory",
            "Get out of here noob.",
            "We only sell bread to those above level 3."
        };

    String[] alf_2 = {
            "Mum",
            "Here you are. Thank you for your patronage."
        };

    public void addedToWorld (World Map_3)
    {
        set_dia(alf, alf_2, 1);
    }
}
