package com.Tyy.ShootGame.cast;
/*
需求：蜜蜂类
分析：1.继承FlyingObject
        另外，由于蜜蜂的飞行路径是不固定的，所以要添加x、y方向的速度属性
      2.实现Award接口  -->击中蜜蜂获取奖励
      3.为Bee类添加构造函数，初始化数据
*/

import java.util.Random;

public class Bee extends FlyingObject implements Award{
    private int xSpeed = 1;
    private int ySpeed = 2;
    private  int AwardType;
    public int GetType(){
        return AwardType;
    }
    //为Bee类添加构造函数，初始化数据
    public void Bee(){
        this.image = ShootGame.bee;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        Random rand = new Random();
        //x的取值范围为0~（屏幕宽度-Bee自身宽度）
        x = rand.nextInt(ShootGame.WIDTH - width);
        //x = 100;
        //y = 200;
        AwardType = rand.nextInt(2);
    }
    public int getType(){
        return  0;
    }
    @Override
    public void  step(){
        x+=xSpeed;
        y+=ySpeed;
        if(x > ShootGame.WIDTH - width){
            xSpeed = -1;
        }
        if(x<0){
            xSpeed = 1;
        }
    }

    @Override
    public boolean outOfRounds() {
        return y>ShootGame.HEIGHT;
    }
}
