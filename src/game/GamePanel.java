/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import objects.Bird;

/**
 *
 * @author Thu Hiền
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Bird bird;
    private Timer timer;

    public GamePanel() {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setBackground(Color.CYAN);

        bird = new Bird();

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ chim
        g.setColor(Color.YELLOW);
        g.fillOval(bird.getX(), bird.getY(), 40, 40);

        // Vẽ ống trên và dưới
        g.setColor(Color.GREEN);
        g.fillRect(650, 0, 60, 200);
        g.fillRect(650, 350, 60, 250);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}