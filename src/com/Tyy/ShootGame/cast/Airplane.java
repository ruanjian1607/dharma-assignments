package com.Tyy.ShootGame.cast;
/*
需求：敌飞机继承自父类FlyingObject，拥有父类的五个属性；
      而且它有被打中会给英雄机加分的功能，所以要实现Enemy接口
*/

public class Airplane extends FlyingObject implements Enemy{
    //除了继承了父类的五个属性和get/set方法之外
    // 敌机还需要实现Enemy接口、有移动速度的属性（针对于敌机移动事件）
    private int speed = 2;
    //实现Enemy接口
    public int getScore(){
        return 5;
    }             //！！！！！！该方法是击中敌机后，英雄机获得的分数？还是撞到敌机，把英雄机分数置零？
    //添加构造方法
    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        //初始化敌机的初始位置
        y  = -height;
        x = (int)(Math.random()*(ShootGame.WIDTH - width));
        //x = 100;
       // y = 100;
    }
     @Override
    public void  step(){
        y+=speed;
     }

    @Override
    public boolean outOfRounds() {
        return y>ShootGame.HEIGHT;
    }
}
