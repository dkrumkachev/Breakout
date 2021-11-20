package main.java.breakout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
/**
 *Test javadock
 *  */
public class BreakOut extends JFrame {
    public BreakOut(){
        super("BreakOut");


    }
    public static void main(String[] args) {
        BreakOut game = new BreakOut();
        Container c = game.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        GamePanel p = new GamePanel();
        c.add(p);
        game.pack();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setBackground(Color.blue);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }
     public static int Sum(int a, int b){
         return a + b;
     }

    public static int SumQ(int a, int b){
        return a + b;
    }

    public static int SumE(int a, int b){
        return a + b;
    }

    public static int SumR(int a, int b){
        return a + b;
    }

    public static int SumT(int a, int b){
        return a + b;
    }
}
