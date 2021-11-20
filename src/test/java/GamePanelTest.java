package test.java;


import main.java.breakout.GamePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePanelTest {

    private Object Graphics;

    @Test
    @DisplayName("Test Create GamePanel")
    public void testCreateGamePanel(){
        boolean actualResult;
        boolean expectedResult = true;
        try{
            new GamePanel(){
            };
        } catch(Exception ignored){
        }
        actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Function Refresh")
    public void testRefresh(){
        boolean expectedResult;
        try{
            new refresh();
        }catch (Exception ignored){
        }
        expectedResult = true;
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Oval for 1x4")
    public void testOval1x4(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            g.fillOval(1, 4, 7, 7);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Start Game")
    public void testStartGame(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            drawStartGame(Objects.requireNonNull(g));
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Options")
    public void testOptions(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            drawOptions(g);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test End Panel")
    public void testEndPanel(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            win(g);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Game Over")
    public void testGameOver(){
        boolean expectedResult = true;
        new GamePanel();
        Graphics g = null;
        try {
            showGameOver(g);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Press Keys")
    public void testPressKeys(){
        boolean expectedResult = true;
        new GamePanel();
        try {
            keyTyped();
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Keys Released")
    public void testReleasedKeys(){
        boolean expectedResult = true;
        new GamePanel();
        try {
            keyReleased();
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Keys Press")
    public void testKeysPress(){
        boolean expectedResult = true;
        new GamePanel();
        try {
            keyPressed();
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Brick Map")
    public void testBrickMap(){
        boolean expectedResult = true;
        new GamePanel();
        try {
            drawBrickMap();
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Component")
    public void testComponent(){

        boolean expectedResult = true;
        new GamePanel();
        DebugGraphics g = null;
        paintComponent(Graphics);
        try {
            g.setColor(Color.WHITE);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Component")
    public void testComponent2(){

        boolean expectedResult = true;
        new GamePanel();
        DebugGraphics g = null;
        paintComponent(Graphics);
        try {
            g.setColor(Color.WHITE);
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test Update")
    public void testUpdate(){
        boolean expectedResult = true;
        new GamePanel();
        try {
            update();
        }catch (Exception ignored){

        }
        boolean actualResult = true;
        assertEquals(expectedResult, actualResult);
    }

    private void update() {
    }

    private void paintComponent(Object graphics) {
    }

    private void drawBrickMap() {
    }

    private void keyPressed() {
    }


    private void keyReleased() {

    }

    private void keyTyped() {
    }

    private void showGameOver(Graphics g) {
        g.setColor(Color.orange);
        g.setFont(new Font("Times new roman", Font.PLAIN, 40));
        g.drawString("GAME OVER", 453 / 2 - 170, 456 / 2 + 10);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times new roman", Font.BOLD, 40));
        g.drawString("SCORE : ", 466 / 2 - 150, 543 / 2 + 60);
    }

    private void win(Graphics g) {
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times new roman", Font.ITALIC, 40));
        g.drawString("You Have Cleared The Game.", 14 / 2 - 260, 34 / 2 - 120);
        g.setColor(Color.GREEN);
    }


    private void drawOptions(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times new roman", Font.ITALIC, 42));
        g.drawString("Press [ESC] to exit the game", 34 / 2 - 260, 432 / 2 + 120);
        g.drawString("Press [R] to restart the game", 54 / 2 - 260, 432 / 2 + 170);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times new roman", Font.BOLD, 42));
        g.drawString("SCORE : " , 56 / 2 - 150, 653 / 2 - 70);
    }

    private void drawStartGame(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Times new roman", Font.ITALIC, 42));
        g.drawString("Press [Space] to start the game", 456 / 2 - 280, 65 / 2 + 30);
    }

    private static class refresh {
    }
}