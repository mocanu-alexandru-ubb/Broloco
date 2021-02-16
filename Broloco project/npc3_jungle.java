import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc3_jungle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc3_jungle extends NPC
{
    /**
     * Act - do whatever the npc3_jungle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String[] alf = {
            "Naz'var", 
            "Hey! Psst!", 
            "Over here!", 
            "I'm Navzar, most people call me the unachieved. ", 
            "I preffer the first one.", 
            "I am one of the ones you need to beat before you can enter the land of the \"Doomed Factory\"", 
            "Let me teach you some new moves, my son. You need to be prepared for...", 
            "the one...",
            "end",
            "2" };

    String[] alf_2 = {
            "Naz'var",
            "I see you have mastered the art of humiliation, my son."};

    public void addedToWorld (World Map_4)
    {
        set_dia(alf, alf_2, 5);
    }
}
