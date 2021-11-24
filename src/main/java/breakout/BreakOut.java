package breakout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * Class BreakOut is the main class of project.
 *  */

public class BreakOut extends JFrame {
    public BreakOut(){
        super("BreakOut");
    }

    /**
     * This is main method which starts project running.
     * @author Daria Zavalyuk.
     * @param args string.
     *  */

    public static void main(String[] args) {
        BreakOut game = new BreakOut();
        Container c = game.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        game.pack();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setBackground(Color.blue);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }
    public static int sum(int a, int b){
         return a + b;
     }

    public static int sumQ(int a, int b){
        return a + b;
    }

    public static int sumE(int a, int b){
        return a + b;
    }

    public static int sumR(int a, int b){
        return a + b;
    }

    public static int sumT(int a, int b){
        return a + b;
    }
}
