import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map_3 extends Template
{

    /**
     * Constructor for objects of class Map_3.
     * 
     */
    public Map_3 (soundplayer nsfx)
    {
        set_sfx(nsfx, 0);
        prepare();
    }
    
    public void started()
    {
        get_sfx().play_loop(4);
    }
    
    public void stopped()
    {
        get_sfx().close();
    }
    
    void prepare ()
    {
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] first_layer1 ={90,90,90,90,89,92,92,92,92,92,92,92,99,90,90,88,94, 0, 0, 0};
        int[] first_layer2 ={90,90,90,90,98, 0, 0, 0, 0, 0, 0, 0,97,90,90,90,88,94, 0, 0};
        int[] first_layer3 ={90,90,90,90,98, 0, 0, 0, 0, 0, 0, 0,97,90,90,90,90,88,94, 0};
        int[] first_layer4 ={90,90,90,90,98, 0, 0, 0, 0, 0, 0, 0,97,90,90,90,90,90,88,91};
        int[] first_layer5 ={99,90,90,90,98, 0, 0, 0, 0, 0, 0, 0,97,90,90,90,90,90,90,90};
        int[] first_layer6 ={97,90,89,92,95, 0, 0, 0, 0, 0, 0, 0,96,92,92,92,92,99,90,90};
        int[] first_layer7 ={97,90,98,15,18,18,18,18,18,18,18,18,18,18,18,18,16,97,90,90};
        int[] first_layer8 ={97,90,98,21,23,23,23,23,23,23,23,23,23,23,23,23,20,97,90,90};
        int[] first_layer9 ={97,90,98,17,19,19,19,19,27,22,26,19,19,19,19,19,14,97,90,90};
        int[] first_layer10={96,99,88,91,91,91,91,94,21,22,20, 0,93,91,91,91,91,87,90,90};
        int[] first_layer11= {0,96,92,92,92,92,92,95,21,22,20, 0,96,92,92,92,92,92,92,92};
        int[] first_layer12= {0, 0, 0, 0, 0, 0, 0, 0,21,22,20, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //                    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[][] map = {first_layer1, first_layer2, first_layer3, first_layer4, first_layer5, first_layer6, first_layer7, first_layer8, first_layer9, first_layer10, first_layer11, first_layer12};

        //            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
        int[] row1 = {0,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12, 0};
        int[] row3 = {0, 0,13,13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row5 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12, 0, 0, 0};
        int[] row6 = {0, 0,12, 0, 0, 0, 0, 0, 0,47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row7 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row8 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12, 0};
        int[] row9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row10= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,46, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row11= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row12= {0, 0, 0, 0, 0, 0, 0, 0, 0,32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[][] map_layer2 = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12};

        //                  LAYER 2
        
        
        Grass_fake house_bottom = new Grass_fake();
        house_bottom.setImage("factory_bottom.png");
        addObject(house_bottom, 544, 264);
        house factory = new house();
        factory.setImage("factory_upper.png");
        addObject(factory, 544, 224); 
        addObject(new rooftop(), 544, 224);
        addObject(new filter_red(), 640, 384);
        
        set_lava();
        generate(map, true);
        generate(map_layer2, false);
    }
}
