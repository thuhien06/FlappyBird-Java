/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
/**
 *
 * @author Thu Hiền
 */
public class Pipe {
    private int x;
    private int gapY;
    private boolean passed = false;

    private final int width = 60;
    private final int gap = 170;
    private final int speed = 3;

    private final int screenHeight = 600;

    private Random random = new Random();

    public Pipe(int x) {
        this.x = x;
        this.gapY = 150 + random.nextInt(250);
    }

    // Di chuyển ống sang trái
    public void update() {
        x -= speed;
    }

    // Vẽ hai ống trên và dưới
    public void draw(Graphics g) {

        g.setColor(Color.GREEN);

        // Ống phía trên
        g.fillRect(x, 0, width, gapY);

        // Ống phía dưới
        g.fillRect(x, gapY + gap, width,
                screenHeight - (gapY + gap));
    }

    // Đưa ống trở lại bên phải màn hình
    public void reset(int newX) {
        x = newX;
        gapY = 150 + random.nextInt(250);
        passed = false;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getGapY() {
        return gapY;
    }

    public int getGap() {
        return gap;
    }
    
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
