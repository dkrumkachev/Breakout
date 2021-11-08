package breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import breakout.GamePanel.ScoreBoard;

public class MainPanel extends JPanel implements ActionListener, KeyListener {
    ScoreBoard scBoard = GamePanel.scBoard;
    Timer timer;
    final int width = 1220;
    final int height = 600;

    //bat
    int batXPos = 500, batYPos = 740;
    int batXVel = 0;
    int batWidth = 130, batHeight = 5;

    //ball
    int ballDia = 30;
    int ballXPos = (batXPos + (batWidth / 2) - (ballDia / 2)), ballYPos = batYPos - ballDia - 3;
    int ballXVel = 0, ballYVel = 0;

    //bricks
    int rows = 5;
    int cols = 10;
    Brick [][] bricks = new Brick[rows][cols];
    int [][] brickValue = new int[rows][cols];
    int brickLeft = rows * cols;

    //game variables
    boolean gameOver = false;
    boolean startGame = false;
    boolean winner = false;
    boolean batCollide = false;

    public MainPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        this.setBackground(Color.cyan);//цвет фона на мяче
        timer = new Timer(1, this);
        setBrickValues();
        addKeyListener(this);
        setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBrickMap(g);

        g.setColor(Color.BLUE);//цвет каретки
        g.fill3DRect(batXPos, batYPos, batWidth, batHeight, true);
        g.setColor(Color.BLACK);
        g.drawRect(batXPos, batYPos, batWidth, batHeight);

        g.setColor(Color.white);//цвет мяча
        g.fillOval(ballXPos, ballYPos, ballDia, ballDia);

        if (!startGame && !gameOver) {
            drawStartGame(g);
        }
        if (winner) {
            drawOptions(g);
            win(g);
            timer.stop();
        }
        if (gameOver) {
            drawOptions(g);
            showGameOver(g);
        }
    }

    public void drawBrickMap(Graphics g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (brickValue[i][j] == 1) {
                    switch (i) {
                        case 0:
                            g.setColor(Color.red);
                            break;
                        case 1:
                            g.setColor(Color.orange);
                            break;
                        case 2:
                            g.setColor(Color.yellow);
                            break;
                        case 3:
                            g.setColor(Color.green);
                            break;
                        case 4:
                            g.setColor(Color.blue);
                    }
                    bricks[i][j].drawBrick(g);
                }
            }
        }
    }

    public void setBrickValues() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                brickValue[i][j] = 1;
                bricks[i][j] = new Brick(i, j);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ballXPos += ballXVel;
        ballYPos += ballYVel;
        batXPos += batXVel;

        if (batXPos < 0 || batXPos + batWidth > width) {
            batXVel = 0;
        }
        if (ballXPos < 0 || ballXPos + ballDia >= width) {
            ballXVel = -ballXVel;
        }
        if (ballYPos < 0) {
            ballYVel = -ballYVel;
        }
        if (ballYPos >= height) {

            scBoard.life--;
            if (scBoard.life == 0) {
                gameOver = true;
                startGame = false;
                timer.stop();
            } else {
                batXPos = 550;
                batYPos = 550;
                ballXPos = (batXPos + (batWidth / 2) - (ballDia / 2));
                ballYPos = batYPos - ballDia - 3;
                ballXVel = 0;
                ballYVel = 0;
                startGame = false;
            }
        }

        Ellipse2D.Double ball = new Ellipse2D.Double(ballXPos, ballYPos, ballDia, ballDia);
        Rectangle2D.Double bat = new Rectangle2D.Double(batXPos, batYPos, batWidth, batHeight);

        if (!batCollide) {
            if (((ballYPos + ballDia) == batYPos) &&
                    (ballXPos + (ballDia / 2)) >= batXPos &&
                    ((ballXPos + (ballDia / 2)) <= (batXPos + batWidth))) {
                System.out.println("bat vertical");
                ballYVel = -ballYVel;
                batCollide = true;
            } else {
                if (ball.intersects(bat)) {
                    if (ballXPos < (batXPos + batWidth / 2) && ballYPos < (batYPos + batHeight)) {
                        if (ballXVel < 0 && ballYVel > 0) {
                            ballYVel = -ballYVel;
                            System.out.println("bat vertical");
                        } else if (ballXVel > 0 && ballYVel > 0) {
                            ballYVel = -ballYVel;
                            ballXVel = -ballXVel;
                            System.out.println("bat diagonal");
                        }
                    } else if (ballXPos > (batXPos + batWidth / 2) && ballYPos < (batYPos + batHeight)) {
                        if (ballXVel < 0 && ballYVel > 0) {
                            ballYVel = -ballYVel;
                            ballXVel = -ballXVel;
                            System.out.println("bat diagonal");
                        } else if (ballXVel > 0 && ballYVel > 0) {
                            ballYVel = -ballYVel;
                            System.out.println("bat vertical");
                        }
                    }
                    batCollide = true;
                }
            }
        }

        if (batCollide && !ball.intersects(bat)) {
            batCollide = false;
        }

// вот это говно надо срочно переписать!
        A:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (brickValue[i][j] == 1) {
                    Rectangle2D.Double br = new Rectangle2D.Double(bricks[i][j].brickXPos, bricks[i][j].brickYPos, bricks[i][j].brickWidth, bricks[i][j].brickHeight);

                    if (((ballYPos + ballDia) == bricks[i][j].brickYPos) &&
                            (ballXPos + (ballDia / 2)) >= bricks[i][j].brickXPos &&
                            ((ballXPos + (ballDia / 2)) <= (bricks[i][j].brickXPos + bricks[i][j].brickWidth))) {
                        System.out.println("pure vertical");
                        ballYVel = -ballYVel;
                        update(i, j);
                        break A;

                    } else if ((((ballYPos) == (bricks[i][j].brickYPos + bricks[i][j].brickHeight)) &&
                            (ballXPos + (ballDia / 2)) >= bricks[i][j].brickXPos) &&
                            ((ballXPos + (ballDia / 2)) <= (bricks[i][j].brickXPos + bricks[i][j].brickWidth))) {
                        System.out.println("pure vertical");
                        ballYVel = -ballYVel;
                        update(i, j);
                        break A;
                    } else if (((ballXPos + ballDia) == bricks[i][j].brickXPos) &&
                            ((ballYPos + (ballDia / 2)) >= bricks[i][j].brickYPos) &&
                            ((ballYPos + (ballDia / 2)) <= (bricks[i][j].brickYPos + bricks[i][j].brickHeight))) {
                        System.out.println("pure horizontal");
                        ballXVel = -ballXVel;
                        update(i, j);
                        break A;
                    } else if (((ballXPos) == (bricks[i][j].brickXPos + bricks[i][j].brickWidth)) &&
                            ((ballYPos + (ballDia / 2)) >= bricks[i][j].brickYPos) &&
                            ((ballYPos + (ballDia / 2)) <= (bricks[i][j].brickYPos + bricks[i][j].brickHeight))) {
                        System.out.println("pure horizontal");
                        ballXVel = -ballXVel;
                        update(i, j);
                        break A;
                    } else if (ball.intersects(br)) {
                        if (ballXPos < (bricks[i][j].brickXPos + bricks[i][j].brickWidth / 2) && ballYPos < (bricks[i][j].brickYPos + bricks[i][j].brickHeight / 2)) {
                            if (ballXVel > 0 && ballYVel < 0) {
                                System.out.println("horizontal");
                                ballXVel = -ballXVel;
                                update(i, j);
                                break A;
                            } else if (ballXVel < 0 && ballYVel > 0) {
                                ballYVel = -ballYVel;
                                System.out.println("vertical");
                                update(i, j);
                                break A;
                            } else if (ballXVel > 0 && ballYVel > 0) {
                                ballYVel = -ballYVel;
                                ballXVel = -ballXVel;
                                System.out.println("diagonal");
                                update(i, j);
                                break A;
                            }
                        } else if (ballXPos > (bricks[i][j].brickXPos + bricks[i][j].brickWidth / 2) && ballYPos < (bricks[i][j].brickYPos + bricks[i][j].brickHeight / 2)) {
                            if (ballXVel < 0 && ballYVel > 0) {
                                ballYVel = -ballYVel;
                                ballXVel = -ballXVel;
                                System.out.println("diagonal");
                                update(i, j);
                                break A;
                            } else if (ballXVel > 0 && ballYVel > 0) {
                                ballYVel = -ballYVel;
                                System.out.println("vertical");
                                update(i, j);
                                break A;
                            } else if (ballXVel < 0 && ballYVel < 0) {
                                System.out.println("horizontal");
                                ballXVel = -ballXVel;
                                update(i, j);
                                break A;
                            }
                        } else if (ballXPos > (bricks[i][j].brickXPos + bricks[i][j].brickWidth / 2) && ballYPos > (bricks[i][j].brickYPos + bricks[i][j].brickHeight / 2)) {
                            if (ballXVel > 0 && ballYVel < 0) {
                                System.out.println("vertical");
                                ballYVel = -ballYVel;
                                update(i, j);
                                break A;
                            } else if (ballXVel < 0 && ballYVel > 0) {
                                ballXVel = -ballXVel;
                                System.out.println("horizontal");
                                update(i, j);
                                break A;
                            } else if (ballXVel < 0 && ballYVel < 0) {
                                ballYVel = -ballYVel;
                                ballXVel = -ballXVel;
                                System.out.println("diagonal");
                                update(i, j);
                                break A;
                            }
                        } else if (ballXPos < (bricks[i][j].brickXPos + bricks[i][j].brickWidth / 2) && ballYPos > (bricks[i][j].brickYPos + bricks[i][j].brickHeight / 2)) {
                            if (ballXVel > 0 && ballYVel < 0) {
                                ballYVel = -ballYVel;
                                ballXVel = -ballXVel;
                                System.out.println("diagonal");
                                update(i, j);
                                break A;
                            } else if (ballXVel > 0 && ballYVel > 0) {
                                ballXVel = -ballXVel;
                                System.out.println("horizontal");
                                update(i, j);
                                break A;
                            } else if (ballXVel < 0 && ballYVel < 0) {
                                System.out.println("vertical");
                                ballYVel = -ballYVel;
                                update(i, j);
                                break A;
                            }
                        }
                    }
                }
            }

            if (brickLeft <= 0) {
                winner = true;
                timer.stop();
            }

            repaint();
            scBoard.refresh();
        }
    }

    void update(int i, int j) {
        brickValue[i][j] = 0;
        if (i == 4) scBoard.score += 1;
        if (i == 3) scBoard.score += 3;
        if (i == 2) scBoard.score += 5;
        if (i == 1) scBoard.score += 7;
        if (i == 0) scBoard.score += 9;
        brickLeft--;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (!startGame && !gameOver) {
            if (key == KeyEvent.VK_SPACE) {
                startGame = true;
                ballXVel = 3;
                ballYVel = 3;
                timer.start();
            }
        }
        if (!startGame) {
            if (key == KeyEvent.VK_LEFT) {
                if (batXPos >= 0) {
                    batXVel = -5;
                    ballXVel = -5;
                } else {
                    batXVel = 0;
                    ballXVel = 0;
                }
            }
            if (key == KeyEvent.VK_RIGHT) {
                if (batXPos + batWidth <= width) {
                    batXVel = 5;
                    ballXVel = 5;
                } else {
                    batXVel = 0;
                    ballXVel = 0;
                }
            }
        }

        if (startGame) {
            if (key == KeyEvent.VK_LEFT) {
                if (batXPos >= 0) {
                    batXVel = -10;
                } else
                    batXVel = 0;
            }
            if (key == KeyEvent.VK_RIGHT) {
                if (batXPos + batWidth <= width) {
                    batXVel = 10;
                } else
                    batXVel = 0;
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (key == KeyEvent.VK_R) {
            batXPos = 500;
            batYPos = 550;

            ballXPos = (batXPos + (batWidth / 2) - (ballDia / 2));
            ballYPos = batYPos - ballDia - 3;
            ballXVel = 0;
            ballYVel = 0;

            brickLeft = rows * cols;

            gameOver = false;
            startGame = false;
            winner = false;
            setBrickValues();
            scBoard.life = 3;
            scBoard.score = 0;
            scBoard.refresh();
            timer.start();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (!startGame) {
            batXVel = 0;
            ballXVel = 0;
        } else
            batXVel = 0;
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    void showGameOver(Graphics g) {
        g.setColor(Color.orange);
        g.setFont(new Font("Times new roman", Font.PLAIN, 40));
        g.drawString("GAME OVER", width / 2 - 170, height / 2 + 10);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times new roman", Font.BOLD, 40));
        g.drawString("SCORE : " + scBoard.score, width / 2 - 150, height / 2 + 60);
    }

    void win(Graphics g) {
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times new roman", Font.ITALIC, 40));
        g.drawString("You Have Cleared The Game.", width / 2 - 260, height / 2 - 120);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times new roman", Font.BOLD, 42));
        g.drawString("SCORE : " + scBoard.score, width / 2 - 150, height / 2 - 70);
    }

    public void drawOptions(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times new roman", Font.ITALIC, 42));
        g.drawString("Press [ESC] to exit the game", width / 2 - 260, height / 2 + 120);
        g.drawString("Press [R] to restart the game", width / 2 - 260, height / 2 + 170);
    }

    public void drawStartGame(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Times new roman", Font.ITALIC, 42));
        g.drawString("Press [Space] to start the game", width / 2 - 280, height / 2 + 30);
    }
}
