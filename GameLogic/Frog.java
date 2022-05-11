package GameLogic;

import java.awt.*;

/**
 * This class represents the frog in the Frogger game.
 * Objects in the frog class have a name and a current position.
 *
 * @author Nilay Das 
 */

public class Frog {

    //Initializing the instance variables
    private String name;
    private Point currentPosition;

    //1st constructor for Frog class
    public Frog(String name, Point currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    //2nd constructor for Frog class
    public Frog(String name) {
        this.name = name;
        this.currentPosition = new Point(0, 0);
    }

    /**
     * Getter for getting the current position of the frog in the game
     *
     * @return the current position of the frog as a Point object.
     */
    public Point getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Getter for getting the name of the frog in the game.
     *
     * @return the name of the frog as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Method for moving the frog in the desired direction.
     *
     * @param dx is the distance moved in the x co-ordinate.
     * @param dy is the distance moved in the y co-ordinate.
     * @return current position of the frog as a Point object.
     */
    public Point move(int dx, int dy) {
        currentPosition.translate(dx, dy);
        return currentPosition;
    }

    /**
     * Method for calculating the distance from the Point object.
     *
     * @param point is a Point object.
     * @return distance as a double.
     */
    public double distanceFromPoint(Point point) {
        double distance;
        double x1 = point.getX();
        double x2 = currentPosition.getX();
        double y1 = point.getY();
        double y2 = currentPosition.getY();

        distance = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        return distance;
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     *
     * @return A Rectangle object defining the bounds of the frog
     */
    public Rectangle getCollisionBounds() {
        return new Rectangle(currentPosition.x, currentPosition.y, 30, 30);
    }

    /**
     * Method for representing the Frog object as a String.
     *
     * @return a String when the object is printed.
     */
    public String toString() {
        return "The frog named " + name + " is at " + "(" + (int) currentPosition.getX() + "," + (int) currentPosition.getY() + ")";
    }


}




