import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class choice_engine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class choice_engine extends Overlord
{
    /**
     * Act - do whatever the choice_engine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int nr = -1;
    highlight txt = new highlight();
    int answer = -1;
    int index = 0;

    public void delete()
    {
        getWorld().removeObject(txt);
        getWorld().removeObject(this);
    }
    
    public int get_answer ()
    {
        return answer;
    }
    
    public void set_choices (int number, String[] choices)
    {
        nr = number;
        txt.setImage("text_box_empty.png");
        txt.getImage().setFont(new Font("Courier New", true, false, 40));
        for (int i=0; i < nr; i++)
        {
            getImage().drawImage(new GreenfootImage("bubl.png"), 512, 384 - nr * 64 + i * 129);
            txt.getImage().drawString(choices[i], 512 + (256 - choices[i].length() * 23) / 2, 384 - nr * 64 +i * 129 + 80);
        }
        getWorld().addObject(txt, 640, 384);
    }

    public void act() 
    {
        if (answer == -1)
        {
            if (pressed("up"))
            {
                getImage().drawImage(new GreenfootImage("bubl.png"), 512, 384 - nr * 64 + index * 129);
                index = (index - 1 + nr) % nr;
                getImage().drawImage(new GreenfootImage("bubl_selected.png"), 512, 384 - nr * 64 + index * 129);
            }
            if (pressed("down"))
            {
                getImage().drawImage(new GreenfootImage("bubl.png"), 512, 384 - nr * 64 + index * 129);
                index = (index + 1 + nr) % nr;
                getImage().drawImage(new GreenfootImage("bubl_selected.png"), 512, 384 - nr * 64 + index * 129);
            }
            if (pressed("enter"))
            {
                answer = index;
            }
        }
        
        refresh_keys();
    }    
}
