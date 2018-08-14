package com.Burningjungle.shoot;

import java.util.Random;

public class Bee extends FlyingObject implements Award {
    private int xSpeed = 1;//x坐标移动速度
    private int ySpeed = 2;//y坐标移动项目
    private int awardType; //奖励类型


    public Bee() {
        this.image = ShootGame.bee;
        width = image.getWidth();
        height = image.getHeight();

        y = -height;

        Random rand = new Random();

        x =  rand.nextInt(ShootGame.WIDTH - width);

        //x = 100;
        //y = 200;

        awardType = rand.nextInt(2);
    }
    @Override
    public void step(){
        x += xSpeed;
        y += ySpeed;
        if (x > ShootGame.WIDTH - width){
            xSpeed = -1;
        }
        if (x < 0){
            xSpeed = 1;
        }
    }
    public int getType(){
        return awardType;
    }
    @Override
    public boolean outOfBounds(){
        return y > ShootGame.HEIGHT;
    }
}