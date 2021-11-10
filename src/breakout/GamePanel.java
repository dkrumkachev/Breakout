package breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

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
        int life = 3;

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
        int ballxpos = (batxpos + (int) (batwidth / 2) - (balldia / 2)), ballypos = batypos - balldia - 3;
        int ballxvel = 0, ballyvel = 0;


        //bricks
        int rows = 5, cols = 10;
        Brick b[][] = new Brick[rows][cols];
        int brickvalue[][] = new int[rows][cols];
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

        public void actionPerformed(ActionEvent arg0) {
            A:
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (brickvalue[i][j] == 1) {
                        Rectangle2D.Double br = new Rectangle2D.Double(b[i][j].brickxpos, b[i][j].brickypos, b[i][j].brickwidth, b[i][j].brickheight);

                        if (((ballypos + balldia) == b[i][j].brickypos) &&
                                (ballxpos + (balldia / 2)) >= b[i][j].brickxpos &&
                                ((ballxpos + (balldia / 2)) <= (b[i][j].brickxpos + b[i][j].brickwidth))) {
                            System.out.println("pure vertical");
                            ballyvel = -ballyvel;
                            update(i, j);
                            break A;

                        } else if ((((ballypos) == (b[i][j].brickypos + b[i][j].brickheight)) &&
                                (ballxpos + (balldia / 2)) >= b[i][j].brickxpos) &&
                                ((ballxpos + (balldia / 2)) <= (b[i][j].brickxpos + b[i][j].brickwidth))) {
                            System.out.println("pure vertical");
                            ballyvel = -ballyvel;
                            update(i, j);
                            break A;
                        } else if (((ballxpos + balldia) == b[i][j].brickxpos) &&
                                ((ballypos + (balldia / 2)) >= b[i][j].brickypos) &&
                                ((ballypos + (balldia / 2)) <= (b[i][j].brickypos + b[i][j].brickheight))) {
                            System.out.println("pure horizontal");
                            ballxvel = -ballxvel;
                            update(i, j);
                            break A;
                        } else if (((ballxpos) == (b[i][j].brickxpos + b[i][j].brickwidth)) &&
                                ((ballypos + (balldia / 2)) >= b[i][j].brickypos) &&
                                ((ballypos + (balldia / 2)) <= (b[i][j].brickypos + b[i][j].brickheight))) {
                            System.out.println("pure horizontal");
                            ballxvel = -ballxvel;
                            update(i, j);
                            break A;
                        } else if (ball.intersects(br)) {
                            if (ballxpos < (b[i][j].brickxpos + b[i][j].brickwidth / 2) && ballypos < (b[i][j].brickypos + b[i][j].brickheight / 2)) {
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
                            } else if (ballxpos > (b[i][j].brickxpos + b[i][j].brickwidth / 2) && ballypos < (b[i][j].brickypos + b[i][j].brickheight / 2)) {
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
                            } else if (ballxpos > (b[i][j].brickxpos + b[i][j].brickwidth / 2) && ballypos > (b[i][j].brickypos + b[i][j].brickheight / 2)) {
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
                            } else if (ballxpos < (b[i][j].brickxpos + b[i][j].brickwidth / 2) && ballypos > (b[i][j].brickypos + b[i][j].brickheight / 2)) {
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
}