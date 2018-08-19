package com.Tyy.ShootGame.cast;
/*
需求：子弹类
分析：1.继承FlyingObject类
      2.子弹向上移动，所以有一个向上移动的速度
      3.添加构造方法
*/

public class Bullet extends  FlyingObject{
    private  int speed = 3;
    public Bullet(int x ,int y){
        this.image = ShootGame.bullet;
        this.x = x;
        this.y = y;
    }
    @Override
    public void step(){
        y-=speed;
    }

    @Override
    public boolean outOfRounds() {
        return y<-height;
    }
}
