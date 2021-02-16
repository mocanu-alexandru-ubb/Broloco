import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc_oldman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc_oldman extends NPC
{
    /**
     * Act - do whatever the npc_oldman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String[] alf = {
            "Old man",
            "Ah the energy on youth...",
            "I see your mom still has plenty of it.",
            "You want me to give you some bread?",
            "Listen here kiddo, bread is a sacred item..",
            "Only those worthy of it shall feast upon it",
            "Do you think you have what it takes?",
            "If so, then shall I test you?",
            "end",
            "1" };

    String[] alf_2 = {
            "Old man",
            "Aah, there's nothing like the flame of youth..."};

    public void addedToWorld (World My_world)
    {
        set_dia(alf, alf_2, 2);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
