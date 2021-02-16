import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPC extends Interact
{
    
    String[] dia = null;
    String[] dia_def = null;
    int id = 0;
    
    public int get_id () {return id;}
    
    public void set_dia (String[] new_dia, String[] dia_d, int id_n) { dia = new_dia; dia_def = dia_d; id = id_n;}
    
    public String[] get_dia () { return dia; }
    
    public String[] get_dia_def () { return dia_def; }
}
