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
import objects.Pipe;

/**
 *
 * @author Thu Hiền
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Bird bird;
    private Timer timer;
    private Pipe pipe;

    public GamePanel() {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setBackground(Color.CYAN);

        bird = new Bird();
        pipe = new Pipe(800);

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        bird.update();
        pipe.update();

        // Khi ống đi hết màn hình
        if (pipe.getX() + pipe.getWidth() < 0) {
            pipe.reset(800);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ chim
        g.setColor(Color.YELLOW);
        g.fillOval(bird.getX(), bird.getY(), 40, 40);

        // Vẽ ống trên và dưới
        pipe.draw(g);
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