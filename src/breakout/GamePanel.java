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

    /***
     * Class ScoreBoard. This class includes counters of lives, points and draws them.
     * @author Dmitry Krumkachev.
     */
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
            }
        }
    }
}