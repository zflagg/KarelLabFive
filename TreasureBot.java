
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class TreasureBot extends Robot
{
    public int beepers = 0;
    
    public TreasureBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findTreasure() {
        if (nextToABeeper()) {
            beepers = 0;
            while (nextToABeeper()) {
                pickBeeper();
                beepers ++;
            }
        }
        if (beepers%5 == 1 && !nextToABeeper()) {
            faceNorth();
            move();
        }
        else if (beepers%5 == 2 && !nextToABeeper()) {
            faceEast();
            move();
        }
        else if (beepers%5 == 3 && !nextToABeeper()) {
            faceSouth();
            move();
        }
        else if (beepers%5 == 4 && !nextToABeeper()) {
            faceWest();
            move();
        }
        else {
            turnOff();
        }
        findTreasure();
    }
    
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void faceEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }
    public void faceWest() {
        while (!facingWest()) {
            turnLeft();
        }
    }
    public void faceSouth() {
        while (!facingSouth()) {
            turnLeft();
        }
    }
}

