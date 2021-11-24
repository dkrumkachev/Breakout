package main.java.breakout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    int width = 1220;
    ScoreBoard s;


    public GamePanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        s = new ScoreBoard();
        MainPanel p = new MainPanel();
        this.add(s);
        this.add(p);

    }


    public class ScoreBoard extends JPanel {
        int score = 0;
        int life = 4;

        public ScoreBoard() {
            this.setPreferredSize(new Dimension(width, 100));
            this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            this.setBackground(Color.BLACK);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times new roman", Font.PLAIN, 80));
            g.drawString("BreakOut", 430, 80);

            g.setFont(new Font("Times new roman", Font.PLAIN, 50));
            g.drawString("Счёт: " + score, 1000, 80);
            g.drawString("Жизни: " + life, 20, 80);
        }

        void refresh() {
            repaint();
        }
    }

    public class MainPanel extends JPanel implements ActionListener, KeyListener {

        Timer t;

        int width = 1220, height = 600;

        //bat
        int batxpos = 500, batypos = 740;
        int batxvel = 0;
        int batwidth = 130, batheight = 5;

        //ball

        int balldia = 30;
        int ballxpos = (batxpos + (batwidth / 2) - (balldia / 2)), ballypos = batypos - balldia - 3;
        int ballxvel = 0, ballyvel = 0;


        //bricks
        int rows = 5, cols = 10;
        Brick[][] b = new Brick[rows][cols];
        int[][] brickvalue = new int[rows][cols];
        int bricksleft = rows * cols;

        //game variables
        boolean gameover = false;
        boolean startgame = false;
        boolean winner = false;

        boolean batcollide = false;


        public MainPanel() {
            this.setPreferredSize(new Dimension(width, height));
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
            this.setBackground(Color.cyan);//цвет фона на мяче
            t = new Timer(1, this);
            setValue();
            addKeyListener(this);
            setFocusable(true);
            this.setFocusTraversalKeysEnabled(false);

            t.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawBrickMap(g);

            g.setColor(Color.BLUE);//цвет каретки
            g.fill3DRect(batxpos, batypos, batwidth, batheight, true);
            g.setColor(Color.BLACK);
            g.drawRect(batxpos, batypos, batwidth, batheight);


            g.setColor(Color.white);//цвет мяча
            g.fillOval(ballxpos, ballypos, balldia, balldia);


            if (!startgame && !gameover) {
                drawStartGame(g);
            }

            if (winner) {
                drawOptions(g);
                win(g);
                t.stop();
            }

            if (gameover) {
                drawOptions(g);
                showGameOver(g);
            }


        }

        public void drawBrickMap(Graphics g) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (brickvalue[i][j] == 1) {
                        switch (i) {
                            case 0 -> g.setColor(Color.red);
                            case 1 -> g.setColor(Color.orange);
                            case 2 -> g.setColor(Color.yellow);
                            case 3 -> g.setColor(Color.green);
                            case 4 -> g.setColor(Color.blue);
                        }
                        b[i][j].drawBrick(g);
                    }
                }
            }
        }

        public void setValue() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    brickvalue[i][j] = 1;
                    b[i][j] = new Brick(i, j);
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ballxpos += ballxvel;
            ballypos += ballyvel;

            batxpos += batxvel;

            if (batxpos < 0 || batxpos + batwidth > width) {
                batxvel = 0;
            }

            if (ballxpos < 0 || ballxpos + balldia >= width) {
                ballxvel = -ballxvel;
            }
            if (ballypos < 0) {
                ballyvel = -ballyvel;
            }
            if (ballypos >= height) {

                s.life--;
                if (s.life == 0) {
                    gameover = true;
                    startgame = false;
                    t.stop();
                } else {
                    batxpos = 550;
                    batypos = 550;
                    ballxpos = (batxpos + (batwidth / 2) - (balldia / 2));
                    ballypos = batypos - balldia - 3;
                    ballxvel = 0;
                    ballyvel = 0;
                    startgame = false;
                }


            }

            Ellipse2D.Double ball = new Ellipse2D.Double(ballxpos, ballypos, balldia, balldia);
            Rectangle2D.Double bat = new Rectangle2D.Double(batxpos, batypos, batwidth, batheight);


            if (!batcollide) {
                if (((ballypos + balldia) == batypos) &&
                        (ballxpos + (balldia / 2)) >= batxpos &&
                        ((ballxpos + (balldia / 2)) <= (batxpos + batwidth))) {
                    System.out.println("bat vertical");
                    ballyvel = -ballyvel;
                    batcollide = true;
                } else {
                    if (ball.intersects(bat)) {
                        if (ballxpos < (batxpos + batwidth / 2) && ballypos < (batypos + batheight)) {

                            if (ballxvel < 0 && ballyvel > 0) {
                                ballyvel = -ballyvel;
                                System.out.println("bat vertical");

                            } else if (ballxvel > 0 && ballyvel > 0) {
                                ballyvel = -ballyvel;
                                ballxvel = -ballxvel;
                                System.out.println("bat diagonal");

                            }
                        } else if (ballxpos > (batxpos + batwidth / 2) && ballypos < (batypos + batheight)) {
                            if (ballxvel < 0 && ballyvel > 0) {
                                ballyvel = -ballyvel;
                                ballxvel = -ballxvel;
                                System.out.println("bat diagonal");

                            } else if (ballxvel > 0 && ballyvel > 0) {
                                ballyvel = -ballyvel;
                                System.out.println("bat vertical");

                            }
                        }
                        batcollide = true;
                    }
                }
            }

            if (batcollide) {
                if (!ball.intersects(bat)) {
                    batcollide = false;
                }
            }


            A:
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (brickvalue[i][j] == 1) {
                        Rectangle2D.Double br = new Rectangle2D.Double(b[i][j].brickXPos, b[i][j].brickYPos, b[i][j].brickWidth, b[i][j].brickHeight);

                        if (((ballypos + balldia) == b[i][j].brickYPos) &&
                                (ballxpos + (balldia / 2)) >= b[i][j].brickXPos &&
                                ((ballxpos + (balldia / 2)) <= (b[i][j].brickXPos + b[i][j].brickWidth))) {
                            System.out.println("pure vertical");
                            ballyvel = -ballyvel;
                            update(i, j);
                            break A;

                        } else if ((((ballypos) == (b[i][j].brickYPos + b[i][j].brickHeight)) &&
                                (ballxpos + (balldia / 2)) >= b[i][j].brickXPos) &&
                                ((ballxpos + (balldia / 2)) <= (b[i][j].brickXPos + b[i][j].brickWidth))) {
                            System.out.println("pure vertical");
                            ballyvel = -ballyvel;
                            update(i, j);
                            break A;
                        } else if (((ballxpos + balldia) == b[i][j].brickXPos) &&
                                ((ballypos + (balldia / 2)) >= b[i][j].brickYPos) &&
                                ((ballypos + (balldia / 2)) <= (b[i][j].brickYPos + b[i][j].brickHeight))) {
                            System.out.println("pure horizontal");
                            ballxvel = -ballxvel;
                            update(i, j);
                            break A;
                        } else if (((ballxpos) == (b[i][j].brickXPos + b[i][j].brickWidth)) &&
                                ((ballypos + (balldia / 2)) >= b[i][j].brickYPos) &&
                                ((ballypos + (balldia / 2)) <= (b[i][j].brickYPos + b[i][j].brickHeight))) {
                            System.out.println("pure horizontal");
                            ballxvel = -ballxvel;
                            update(i, j);
                            break A;
                        } else if (ball.intersects(br)) {
                            if (ballxpos < (b[i][j].brickXPos + b[i][j].brickWidth / 2) && ballypos < (b[i][j].brickYPos + b[i][j].brickHeight / 2)) {
                                if (ballxvel > 0 && ballyvel < 0) {
                                    System.out.println("horizontal");
                                    ballxvel = -ballxvel;
                                    update(i, j);
                                    break A;
                                } else if (ballxvel < 0 && ballyvel > 0) {
                                    ballyvel = -ballyvel;
                                    System.out.println("vertical");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel > 0 && ballyvel > 0) {
                                    ballyvel = -ballyvel;
                                    ballxvel = -ballxvel;
                                    System.out.println("diagonal");
                                    update(i, j);
                                    break A;
                                }
                            } else if (ballxpos > (b[i][j].brickXPos + b[i][j].brickWidth / 2) && ballypos < (b[i][j].brickYPos + b[i][j].brickHeight / 2)) {
                                if (ballxvel < 0 && ballyvel > 0) {
                                    ballyvel = -ballyvel;
                                    ballxvel = -ballxvel;
                                    System.out.println("diagonal");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel > 0 && ballyvel > 0) {
                                    ballyvel = -ballyvel;
                                    System.out.println("vertical");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel < 0 && ballyvel < 0) {
                                    System.out.println("horizontal");
                                    ballxvel = -ballxvel;
                                    update(i, j);
                                    break A;
                                }
                            } else if (ballxpos > (b[i][j].brickXPos + b[i][j].brickWidth / 2) && ballypos > (b[i][j].brickYPos + b[i][j].brickHeight / 2)) {
                                if (ballxvel > 0 && ballyvel < 0) {
                                    System.out.println("vertical");
                                    ballyvel = -ballyvel;
                                    update(i, j);
                                    break A;
                                } else if (ballxvel < 0 && ballyvel > 0) {
                                    ballxvel = -ballxvel;
                                    System.out.println("horizontal");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel < 0 && ballyvel < 0) {
                                    ballyvel = -ballyvel;
                                    ballxvel = -ballxvel;
                                    System.out.println("diagonal");
                                    update(i, j);
                                    break A;
                                }
                            } else if (ballxpos < (b[i][j].brickXPos + b[i][j].brickWidth / 2) && ballypos > (b[i][j].brickYPos + b[i][j].brickHeight / 2)) {
                                if (ballxvel > 0 && ballyvel < 0) {
                                    ballyvel = -ballyvel;
                                    ballxvel = -ballxvel;
                                    System.out.println("diagonal");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel > 0 && ballyvel > 0) {
                                    ballxvel = -ballxvel;
                                    System.out.println("horizontal");
                                    update(i, j);
                                    break A;
                                } else if (ballxvel < 0 && ballyvel < 0) {
                                    System.out.println("vertical");
                                    ballyvel = -ballyvel;
                                    update(i, j);
                                    break A;
                                }
                            }
                        }
                    }
                }

                if (bricksleft <= 0) {
                    winner = true;
                    t.stop();
                }

                repaint();
                s.refresh();

            }
        }

        void update(int i, int j) {
            brickvalue[i][j] = 0;
            if (i == 4) s.score += 1;
            if (i == 3) s.score += 3;
            if (i == 2) s.score += 5;
            if (i == 1) s.score += 7;
            if (i == 0) s.score += 9;
            bricksleft--;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (!startgame && !gameover) {
                if (key == KeyEvent.VK_SPACE) {
                    startgame = true;
                    ballxvel = 3;
                    ballyvel = 3;
                    t.start();
                }
            }
            if (!startgame) {
                if (key == KeyEvent.VK_LEFT) {
                    if (batxpos >= 0) {
                        batxvel = -5;
                        ballxvel = -5;
                    } else {
                        batxvel = 0;
                        ballxvel = 0;
                    }
                }
                if (key == KeyEvent.VK_RIGHT) {
                    if (batxpos + batwidth <= width) {
                        batxvel = 5;
                        ballxvel = 5;
                    } else {
                        batxvel = 0;
                        ballxvel = 0;
                    }
                }
            }

            if (startgame) {
                if (key == KeyEvent.VK_LEFT) {
                    if (batxpos >= 0) {
                        batxvel = -10;

                    } else
                        batxvel = 0;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    if (batxpos + batwidth <= width) {
                        batxvel = 10;

                    } else
                        batxvel = 0;
                }
            }

            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }

            if (key == KeyEvent.VK_R) {

                batxpos = 500;
                batypos = 550;


                ballxpos = (batxpos + (batwidth / 2) - (balldia / 2));
                ballypos = batypos - balldia - 3;
                ballxvel = 0;
                ballyvel = 0;

                bricksleft = rows * cols;

                gameover = false;
                startgame = false;
                winner = false;
                setValue();
                s.life = 3;
                s.score = 0;
                s.refresh();
                t.start();
            }

            repaint();


        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            if (!startgame) {
                batxvel = 0;
                ballxvel = 0;
            } else
                batxvel = 0;

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
            g.drawString("SCORE : " + s.score, width / 2 - 150, height / 2 + 60);

        }

        void win(Graphics g) {

            g.setColor(Color.ORANGE);
            g.setFont(new Font("Times new roman", Font.ITALIC, 40));
            g.drawString("You Have Cleared The Game.", width / 2 - 260, height / 2 - 120);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times new roman", Font.BOLD, 42));
            g.drawString("SCORE : " + s.score, width / 2 - 150, height / 2 - 70);

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

    public static int[][] sortRow(int[][] matrix, int i, int x) {
        for(int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length - 1; ++i) {
            int x = i;

            for(int j = i + 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] < matrix[0][x]) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }

    public static int[][] sortLine(int[][] matrix, int i, int x) {
        for(int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrixBrick(int[][] matrix) {
        for(int i = 0; i < matrix[0].length - 1; ++i) {
            int x = i;

            for(int j = i + 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] < matrix[0][x]) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }

    public static int[][] sortMatrixRow(int[][] matrix, int i, int x) {
        for(int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrixCol(int[][] matrix) {
        for(int i = 0; i < matrix[0].length - 1; ++i) {
            int x = i;

            for(int j = i + 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] < matrix[0][x]) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }

    public static int[][] sortRow12(int[][] matrix, int i, int x) {
        for(int k = 0; k < matrix.length; ++k) {
            int buf = matrix[k][i];
            matrix[k][i] = matrix[k][x];
            matrix[k][x] = buf;
        }

        return matrix;
    }

    public static int[][] orderMatrixLine1771(int[][] matrix) {
        for(int i = 0; i < matrix[0].length - 1; ++i) {
            int x = i;

            for(int j = i + 1; j < matrix[0].length; ++j) {
                if (matrix[0][j] < matrix[0][x]) {
                    x = j;
                }
            }

            sortRow(matrix, i, x);
        }

        return matrix;
    }
}
