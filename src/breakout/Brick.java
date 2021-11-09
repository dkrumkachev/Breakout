package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {

    int brickXPos;
    int brickYPos;

    int brickWidth = 80; 
    int brickHeight = 40;

    int xOffset = 150;
    int yOffset = 50;

    int xGap = 10;
    int yGap = 10;

    public Brick(int i, int j) {
        brickXPos = xOffset + brickWidth * j + xGap * j;
        brickYPos = yOffset + brickHeight * i + yGap * i;
    }
    public void drawBrick(Graphics g){
        g.fill3DRect(brickXPos, brickYPos, brickWidth, brickHeight, true);
        g.setColor(Color.white);
        g.drawRect(brickXPos, brickYPos, brickWidth, brickHeight);

    }
}


