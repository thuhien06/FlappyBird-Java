/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Thu Hiền
 */
public class Bird {
    private int x;
    private double y;
    private double velocity; //Vận tốc của chim
    private final int width = 30;
    private final int height = 30;

    private final double gravity = 0.5; //Lực trọng trường khiến chim rơi.
    private final double jumpStrength = -8; //Lực đẩy chim lên khi nhấn SPACE.

    public Bird() {
        x = 150;
        y = 250;
        velocity = 0;
    }

    // Cập nhật chuyển động của chim
    public void update() {
        velocity += gravity;
        y += velocity;
    }

    // Chim bay lên
    public void jump() {
        velocity = jumpStrength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return (int) y;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
