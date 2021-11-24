package breakout;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class includes all data about bricks.
 * @author Alexandr Ravodin.
 *  */

public class Brick {

    int brickXPos;
    int brickYPos;

    /**
     * This is int field with brick width data.
     *  */

    int brickWidth = 80;

    /**
     * This is int field with brick height data.
     *  */

    int brickHeight = 40;

    /**
     * This is int field with horizontal offset.
     *  */

    int xOffset = 150;

    /**
     * This is int field with vertical offset.
     *  */

    int yOffset = 50;

    int xGap = 10;
    int yGap = 10;

    /**
     * This method create every break.
     * @author Alexandr Ravodin.
     * @param i row.
     * @param j column.
     *  */

    public Brick(int i, int j) {
        brickXPos = xOffset + brickWidth * j + xGap * j;
        brickYPos = yOffset + brickHeight * i + yGap * i;
    }

    /**
     * This method draw every brick.
     * @author Alexandr Ravodin.
     *  */

    public void drawBrick(Graphics g){
        g.fill3DRect(brickXPos, brickYPos, brickWidth, brickHeight, true);
        g.setColor(Color.white);
        g.drawRect(brickXPos, brickYPos, brickWidth, brickHeight);

    }
}


