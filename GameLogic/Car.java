package GameLogic;

import java.awt.*;

/**
 * This class represents the cars in the Frogger game.
 * Objects in the car class have a current position, body color, movement speed, and co-ordinates representing the size
 * of the cars. A boolean variable also determines if the cars moves to the left or right.
 *
 * @author Nilay Das 
 */

public class Car {

    //Initializing the instance variables
    private Point currentPosition;
    private Color bodyColour;
    private int movementSpeed;
    private int xSize;
    private int ySize;
    private boolean moveLeft;

    //Constructor for Car class
    public Car(Point currentPosition, Color bodyColour, int movementSpeed, int xSize, int ySize, boolean moveLeft) {
        this.currentPosition = currentPosition;
        this.bodyColour = bodyColour;
        this.movementSpeed = movementSpeed;
        this.xSize = xSize;
        this.ySize = ySize;
        this.moveLeft = moveLeft;
    }

    /**
     * Getter for getting the current position of the cars in the game.
     *
     * @return the current position of the car as a Point object.
     */
    public Point getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Getter for getting body color of the cars in the game.
     *
     * @return the body color of the cars as a Color object.
     */
    public Color getBodyColour() {
        return bodyColour;
    }

    /**
     * Getter for getting the x co-ordinate of the car.
     *
     * @return the x co-ordinate of the car as an int.
     */
    public int getXSize() {
        return xSize;
    }

    /**
     * Getter for getting the y co-ordinate of the car.
     *
     * @return the y co-ordinate of the car as an int.
     */
    public int getYSize() {
        return ySize;
    }

    /**
     * Getter for getting the movement speed of the car.
     *
     * @return the movement speed of the car as an int.
     */
    public int getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Getter for getting if the car is moving to the left.
     *
     * @return true if the car moves to the left as a boolean
     */
    public boolean isMoveLeft() {
        return moveLeft;
    }

    /**
     * Method for determining if the car is moving to the left or right.
     */
    public void move() {
        if (moveLeft) {
            currentPosition.translate(-movementSpeed, 0);
        } else {
            currentPosition.translate(+movementSpeed, 0);
        }
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     *
     * @return A Rectangle object defining the bounds of the car
     */
    public Rectangle getCollisionBounds() {
        return new Rectangle(currentPosition.x, currentPosition.y, xSize, ySize);
    }
}
