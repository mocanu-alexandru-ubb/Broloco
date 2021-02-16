import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class soundplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class soundplayer
{
    /**
     * Act - do whatever the soundplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound bgm1 = new GreenfootSound("bgm1.mp3"); 
    GreenfootSound bgm2 = new GreenfootSound("bgm2.mp3"); 
    GreenfootSound bgm3 = new GreenfootSound("bgm3.mp3"); 
    GreenfootSound footstep = new GreenfootSound("footstep-grass.wav");
    GreenfootSound bgm4 = new GreenfootSound("bgm4.mp3"); 
    GreenfootSound bgm5 = new GreenfootSound("bgm5.mp3"); 
    GreenfootSound bgm6 = new GreenfootSound("bgm6.mp3"); 
    
    
    GreenfootSound[] sfx = {bgm1, bgm2, bgm3, footstep, bgm4, bgm5, bgm6};
    public int bgm = 0;
    
    public void set_volume ()
    {
        bgm1.setVolume(20);
        bgm2.setVolume(20);
        bgm3.setVolume(40);
        bgm4.setVolume(20);
        bgm5.setVolume(20);
        bgm6.setVolume(20);
        footstep.setVolume(80);
    }
    
    public void play_bgm (int i)
    {
        sfx[bgm].pause();
        sfx[i].playLoop();
        bgm = i;
    }
    
    public void close()
    {
        for (int i = 0; i < sfx.length; i++)
        {
            System.out.println("Closed sfx" + i);
            sfx[i].pause();
        }
        //getWorld().removeObject(this);
    }
    
    public void pause (int i)
    {
        sfx[i].pause();
    }
    
    public void stop (int i)
    {
        sfx[i].stop();
    }
    
    public boolean is_playing (int i)
    {
        return sfx[i].isPlaying();
    }
    
    public void play_loop (int i)
    {
        sfx[i].playLoop();
    }
    
    public void play (int i)
    {
        sfx[i].play();
    }
    
}
