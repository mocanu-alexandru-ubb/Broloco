import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc_mum extends NPC
{
    /**
     * Act - do whatever the npc0 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    String[] alf = {
            "Mum",
            "Have you gotten that damn bread yet?"
        };

    String[] alf_2 = {
            "Mum",
            "Level 3 bread?",
            "Are you mocking me?",
            "Go to the city and buy some damn elite bread!"
        };

    public void addedToWorld (World My_world)
    {
        set_dia(alf, alf_2, 0);
    }

    public void act() 
    {

    }    
}
