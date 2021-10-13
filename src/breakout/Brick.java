package breakout;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {

    int brickXPos, brickYPos; // переменные координат позиции блока.

    int brickWidth = 80; // ширина блока.
    int brickHeight = 40; // высота блока.

    int xOffset = 150; // отступ справа.
    int yOffset = 50; // отступ сверху.

    int xGap = 10; // промежуток по горизонтали.
    int yGap = 10; // промежуток по вертикали.

    public Brick(int i, int j) {

        brickXPos = xOffset + brickWidth * j + xGap * j;  // горизонтальная координата левого верхнего угла блока.
        brickYPos = yOffset + brickHeight * i + yGap * i; // вертикальная координата левого врехнего угла блока.

    }


}

