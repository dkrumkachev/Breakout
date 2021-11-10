package breakout;

import java.awt.Color;
import java.awt.Graphics;

/***
 * Class Brick. This class includes position, dimensions of each brick.
 * @author Alexandr Ravodin.
 */
public class Brick {

    int brickXPos;
    int brickYPos;

    /***
     * Dimensions of each brick.
     */
    int brickWidth = 80; 
    int brickHeight = 40;

    /***
     * Offsets.
     */
    int xOffset = 150;
    int yOffset = 50;

    /***
     * Gaps between neighboring bricks.
     */
    int xGap = 10;
    int yGap = 10;

    /***
     * Calculating of the position of each brick.
     */
    public Brick(int i, int j) {

        brickXPos = xOffset + brickWidth * j + xGap * j;
        brickYPos = yOffset + brickHeight * i + yGap * i;
    }

    /***
     * Drawing of each brick.
     * @param g object;
     */
    public void drawBrick(Graphics g){

        g.fill3DRect(brickXPos, brickYPos, brickWidth, brickHeight, true);
        g.setColor(Color.white);
        g.drawRect(brickXPos, brickYPos, brickWidth, brickHeight);

    }
}


