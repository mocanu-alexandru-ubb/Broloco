import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class npc2_neighb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class npc2_neighb extends NPC
{
    /**
     * Act - do whatever the npc2_neighb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String[] alf = {
            "Danny",
            "Heard you kid getting scolded by yer' mum..",
            "Tough times, ey?",
            "Lemme tell you a secret...",
            "There's a legendary bread factory just northof here. Take the road to yer' right then go  north. Yer' can't miss it.",
            "But there's a catch...",
            "Yer' gotta be level 3 to buy from them.",
            "What are levels? Where yer' been at kid?    Everything's about levels nowadays.",
            "Can't even get my bottle of ol' beer before I get level 18.",
            "How about I let yer' have a go at me, see if yer' can get a quick level up.",
            "end",
            "2" };

    String[] alf_2 = {
            "Danny",
            "Huh, not bad kid.",
            "Now go out there and make yer' mum proud!"};

    public void addedToWorld (World My_world)
    {
        set_dia(alf, alf_2, 3);
    } 
}
