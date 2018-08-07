package com.zhanghanwen.shoot;
import com.zhanghanwen.shoot.ShootGame;
public class Airplane extends FlyingObject implements Enemy{
    private int speed = 2;
    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        x = (int)(Math.random()*(ShootGame.WIDTH -width));

    }
    public int getScore(){
        return 5;
    }
    public void step(){
        y += speed;
    }
    public boolean outOfBounds(){
        return y>ShootGame.HEIGHT;
    }
}
