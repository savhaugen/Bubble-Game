package edu.macalester.comp127.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CannonBallTest {

    // TODO: Uncomment this test
    @Test
    public void testBasicUpdatePosition() {
        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);
    
        ball.updatePosition(0.1);
        assertEquals(107.071, ball.getCenterX(), 0.001);
        assertEquals(92.9289, ball.getCenterY(), 0.001);
    
        ball.updatePosition(0.1);
        assertEquals(114.142, ball.getCenterX(), 0.001);
        assertEquals(85.9558, ball.getCenterY(), 0.001);
    
        ball.updatePosition(0.1);
        assertEquals(121.213, ball.getCenterX(), 0.001);
        assertEquals(79.0807, ball.getCenterY(), 0.001);
    }


    @Test
    public void testUpdatePosition(){
        CannonBall ball = new CannonBall(-10, 100, 100, 45, 1100, 600);
    
        
        assertFalse(ball.updatePosition(.1));
        assertEquals(-10, ball.getCenterX(), 0.0001);
        assertEquals(100, ball.getCenterY(), 0.0001);
    }
    
    
    //TODO: Add more test methods
}
