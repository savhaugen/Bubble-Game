package edu.macalester.comp127.hw2;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

/**
 * The main game class to run the game popping bubbles.
 */
@SuppressWarnings("WeakerAccess")
public class BubbleBlitz {

    private Random random;
    private Cannon cannon;
    private BubbleManager bubbleManager;
    private CanvasWindow canvas;

    public static final int WINDOW_PADDING = 30;
    public static final Color SKY_COLOR = new Color(188, 217, 255);
    public static final Color GROUND_COLOR = new Color(122, 181, 107);


    public static void main(String[] args) {
        BubbleBlitz game = new BubbleBlitz();
        
            game.run();
        
        
    }

    public BubbleBlitz() {
        canvas = new CanvasWindow("BubbleBlitz", 800, 600);
        random = new Random();
        bubbleManager = new BubbleManager(canvas);
    }

    public void run() {  
        resetGame();
        while (bubbleManager.bubblesStillExist()){
            getInput();
            cannonStuff(initialAngle, initialVelocity); 
        }  
        resetGame();
       
        
    }

    /**
     * Resets the canvas by removing everything and redrawing new bubbles and a new random placement for the cannon.
     */
    public void resetGame() {
        bubbleManager.removeAllBubbles();
        canvas.removeAll();
        createBackground();
        bubbleManager.generateBubbles();
        createCannon(random.nextDouble() * (canvas.getWidth() - WINDOW_PADDING) + WINDOW_PADDING, canvas.getHeight() - WINDOW_PADDING, 90);
        canvas.draw();
    }

    /**
     * Creates a cannon.
     * @param centerX The anchor position of the cannon
     * @param centerY The anchor position of the cannon
     * @param angleDegrees The direction of the cannon
     */
    private void createCannon(double centerX, double centerY, double angleDegrees) {
        cannon = new Cannon(centerX, centerY, angleDegrees);
        canvas.add(cannon);
    }

    /**
     * Creates the sky and ground background
     */
    private void createBackground() {
        Rectangle sky = new Rectangle(0, 0, canvas.getWidth(), canvas.getHeight());
        sky.setFillColor(SKY_COLOR);
        sky.setFilled(true);
        canvas.add(sky);

        Rectangle ground = new Rectangle(0, canvas.getHeight() - WINDOW_PADDING, canvas.getWidth(), WINDOW_PADDING);
        ground.setFilled(true);
        ground.setFillColor(GROUND_COLOR);
        ground.setStroked(false);
        canvas.add(ground);
    }

    double initialAngle;
    double initialVelocity;

    public void getInput(){
        
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter an angle between 0 and 180");

        initialAngle = scan1.nextDouble();
        cannon.updateCannon(initialAngle);
        

        System.out.println("Enter an initial velocity");
        initialVelocity = scan1.nextDouble();
    }
        

    public void cannonStuff(double initialAngle, double initialVelocity){
            CannonBall cannonball1 = new CannonBall(cannon.getX2(), cannon.getY2(), initialVelocity, initialAngle, 
                                                canvas.getWidth(), canvas.getHeight());
    

        cannonball1.addToCanvas(canvas);  

         while (bubbleManager.testHit(cannonball1) == false && cannonball1.updatePosition(.1)){
            cannonball1.updatePosition(.1);
                canvas.draw();
                canvas.pause(10);  
            
        }
       
        cannonball1.removeFromCanvas(canvas);
        canvas.draw();

        }
    

      }
       