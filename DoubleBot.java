


import kareltherobot.*;

/**
 * Write a description of class Template here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleBot extends Robot
{
    // instance variables - replace the example below with your own
    public int beepers;
    private int count = 0;
    
    /**
     * Constructor for objects of class Template
     */
     public DoubleBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }

    public void doubleBeepers()
    {
        move();
        while (nextToABeeper()) {
            pickBeeper();
            count ++;
            beepers ++;
        }
        while (beepers>0) {
            putBeeper();
            beepers --;
        }
        move();
        count*=2;
        while (count>0) {
            putBeeper();
            count --;
        }
        turnLeft();
        move();
        turnLeft();
        move();
        move();
        turnLeft();
        move();
        turnLeft();
    }
}
