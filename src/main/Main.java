/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import game.GamePanel;
import javax.swing.JFrame;

/**
 *
 * @author Thu Hiền
 */
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Flappy Bird");

        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
