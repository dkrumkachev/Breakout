package breakout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class BreakOut extends JFrame {
    public BreakOut(){
        super("BreakOut");
    }

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

}
