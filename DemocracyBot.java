
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class DemocracyBot extends Robot
{
    public boolean middleBeeper = false;
    public DemocracyBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixBallots() {
        middleBeeper = false;
        move();
        checkMiddle();
        checkNorth();
        checkSouth();
        reposition();
        fixBallots();
    }
    public void checkMiddle() {
        if (nextToABeeper()) {
            middleBeeper = true;
        }
    }
    public void checkNorth() {
        faceNorth();
        move();
        if (middleBeeper && !nextToABeeper()) {
            putBeeper();
        }
        else if (!middleBeeper && nextToABeeper()) {
            while (nextToABeeper()) {
                pickBeeper();
            }
        }
    }
    public void checkSouth() {
        faceSouth();
        move();
        move();
        if (middleBeeper && !nextToABeeper()) {
            putBeeper();
        }
        else if (!middleBeeper && nextToABeeper()) {
            while (nextToABeeper()) {
                pickBeeper();
            }
        }
    }
    public void reposition() {
        faceNorth();
        move();
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void faceSouth() {
        while (!facingSouth()) {
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
}

