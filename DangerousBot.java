
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DangerousBot extends Robot
{
    public int beepers;
    
    public DangerousBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void choosePile() {
        while (nextToABeeper()) {
            pickBeeper();
            beepers ++;
        }
        if (beepers%2 == 0) {
            faceEast();
            move();
            while (nextToABeeper()) {
                pickBeeper();
            }
            faceWest();
            move();
            turnRight();
        }
        else {
            faceWest();
            move();
            while (nextToABeeper()) {
                pickBeeper();
            }
            faceEast();
            move();
            turnLeft();
        }
    }
    public void faceWest() {
        if (!facingWest()) {
            turnLeft();
        }
    }
    public void faceEast() {
        if (!facingEast()) {
            turnLeft();
        }
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

