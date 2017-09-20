
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class TreasureBot extends Robot
{
    public int beepers;
    
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
        if (beepers%5 == 2 && !nextToABeeper()) {
            faceEast();
            move();
        }
        if (beepers%5 == 3 && !nextToABeeper()) {
            faceSouth();
            move();
        }
        if (beepers%5 == 4 && !nextToABeeper()) {
            faceWest();
            move();
        }
        if (beepers%5 == 0) {
            turnOff();
        }
        findTreasure();
    }
    
    public void faceNorth() {
        if (!facingNorth()) {
            turnLeft();
        }
    }
    public void faceEast() {
        if (!facingEast()) {
            turnLeft();
        }
    }
    public void faceWest() {
        if (!facingWest()) {
            turnLeft();
        }
    }
    public void faceSouth() {
        if (!facingSouth()) {
            turnLeft();
        }
    }
}

