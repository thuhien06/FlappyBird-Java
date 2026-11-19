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
import java.util.ArrayList;
import java.awt.Rectangle;

/**
 *
 * @author Thu Hiền
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Bird bird;
    private Timer timer;
    private ArrayList<Pipe> pipes;

    public GamePanel() {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setBackground(Color.CYAN);

        bird = new Bird();
        pipes = new ArrayList<>();

        pipes.add(new Pipe(800));
        pipes.add(new Pipe(1100));
        pipes.add(new Pipe(1400));

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();

        for (Pipe pipe : pipes) {
            pipe.update();

            if (pipe.getX() + pipe.getWidth() < 0) {
                pipe.reset(pipe.getX() + 900);
            }
        }

        if (checkCollision()) {
            timer.stop();
            System.out.println("GAME OVER!");
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
        for (Pipe pipe : pipes) {
            pipe.draw(g);
        }
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
    
    private boolean checkCollision() {
        Rectangle birdBounds = new Rectangle(
                bird.getX(),
                bird.getY(),
                bird.getWidth(),
                bird.getHeight()
        );
        if (birdBounds.y <= 0
                || birdBounds.y + birdBounds.height >= 600) {
            return true;
        }

        for (Pipe pipe : pipes) {
            Rectangle topPipe = new Rectangle(
                    pipe.getX(),
                    0,
                    pipe.getWidth(),
                    pipe.getGapY()
            );

            Rectangle bottomPipe = new Rectangle(
                    pipe.getX(),
                    pipe.getGapY() + pipe.getGap(),
                    pipe.getWidth(),
                    600 - (pipe.getGapY() + pipe.getGap())
            );

            if (birdBounds.intersects(topPipe)
                    || birdBounds.intersects(bottomPipe)) {
                return true;
            }
        }

        return false;
    }
}