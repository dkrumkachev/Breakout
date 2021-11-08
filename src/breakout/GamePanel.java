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
    final static int width = 1220;
    static ScoreBoard scBoard;

    public GamePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        scBoard = new ScoreBoard();
        MainPanel mainPanel = new MainPanel();
        this.add(scBoard);
        this.add(mainPanel);
    }

    public static class ScoreBoard extends JPanel {
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
}


