package GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * This class represents the logic for the Frogger game.
 * Objects in the game class have a Frog object player and a list of cars in the game.
 *
 * @author Nilay Das
 */


public class Game {

    //Initializing the instance variables
    private Frog player;
    private ArrayList<Car> cars = new ArrayList<Car>();

    //Constructor for Game class
    public Game(String name, Point point) {
        this.player = new Frog(name, point);
        cars.add(new Car(new Point(100, 400), Color.BLACK, 10, 120, 75, false));
        cars.add(new Car(new Point(0, 300), Color.BLUE, 30, 200, 75, false));
        cars.add(new Car(new Point(100, 150), Color.BLACK, 10, 120, 75, true));
        cars.add(new Car(new Point(0, 80), Color.BLACK, 20, 120, 75, true));
    }

    /**
     * Getter for getting the player from the Frog object.
     *
     * @return the player from the Frog object.
     */
    public Frog getPlayer() {
        return player;
    }

    /**
     * Getter for getting the car objects stored in the array list.
     *
     * @return the car objects stored in the array list.
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * Method for moving the player to the left, right, up and down.
     *
     * @param Key  represents the key pressed in the keyboard.
     * @param step represent the number of steps the frog will move when a specific key is pressed once.
     */
    public void movePlayer(int Key, int step) {
        if (Key == KeyEvent.VK_DOWN) {
            player.move(0, +step);
        } else if (Key == KeyEvent.VK_UP) {
            player.move(0, -step);
        } else if (Key == KeyEvent.VK_RIGHT) {
            player.move(+step, 0);
        } else if (Key == KeyEvent.VK_LEFT) {
            player.move(-step, 0);
        }
    }

    /**
     * Method for moving the cars to the left and right.
     *
     * @param xLimit represents the end of the screen in the game both in the left and the right side.
     */
    public void moveCars(int xLimit) {
        for (Car car : cars) {
            car.move();
            double x = car.getCurrentPosition().getX();
            double y = car.getCurrentPosition().getY();

            if (car.isMoveLeft()) {
                if (x <= 0) {
                    car.getCurrentPosition().setLocation(xLimit, y);
                }

            } else {
                if (x + car.getXSize() >= xLimit) {
                    car.getCurrentPosition().setLocation(0, y);
                }

            }
        }
    }

    /**
     * Method for determining if the player is hit or not.
     *
     * @return true if the player hits a car and false if the player does not hit anything.
     */
    public boolean isPlayerHit() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            if (car.getCollisionBounds().contains(player.getCurrentPosition())) {
                return true;
            } else if (player.getCollisionBounds().contains(car.getCollisionBounds())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for determining if the player the won or not.
     *
     * @return true if the player has won the game and false if the player has lost the game.
     */
    public boolean hasPlayerWon() {
        if (player.getCurrentPosition().getY() <= 20) {
            return true;
        } else {
            return false;
        }
    }


}




