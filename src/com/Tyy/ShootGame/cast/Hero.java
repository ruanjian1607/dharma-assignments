package com.Tyy.ShootGame.cast;


import java.awt.image.BufferedImage;


/*
需求：英雄机类

分析：1.继承与FlyingObject类
      2.由于英雄机在击中蜜蜂时，会有增命或者双倍火力奖励，
        所以将LIFE和DOUBLE_FIRE作为英雄机类的属性
*/
public class Hero extends  FlyingObject{
    private  int DOUBLE_FIRE;
    private  int LIFE;
    //image表示英雄机的贴图，由于英雄机的移动是由俩张图片的交替显示来实现的，所以这两张图片用数组来存
    //index表示数组下标
    private BufferedImage[] images = {};
    private  int index = 0;

    public  Hero(){
        LIFE = 3;
        DOUBLE_FIRE = 0;
        this.image = ShootGame.hero0;
        images = new BufferedImage[]{ ShootGame.hero0,ShootGame.hero1 };
        width = image.getWidth();
        height = image.getHeight();
        x = 150;
        y = 400;
    }
    @Override
    public void step(){
        if(images.length>0){
            image = images[index++/10%images.length];
        }
    }
   //!!!!!!11代码中没有实现这一方法
    @Override
    public boolean outOfRounds() {
        return false;
    }

    public Bullet[] shoot(){
        int xStep = width /4 ;
        int yStep = 20;
        if(DOUBLE_FIRE>0){
            Bullet[] bullets = new Bullet[2];
            bullets[0] = new Bullet(x+xStep,y-yStep);
            bullets[1] = new Bullet(x+3*xStep,y-yStep);
            DOUBLE_FIRE-=2;
            return bullets;
        }else{
            Bullet[] bullets = new Bullet[1];
            bullets[0] = new Bullet(x+2*xStep,y-yStep);
            return bullets;
        }
    }

    public void moveTo(int x,int y){
        this.x = x - width/2;
        this.y = y - height/2;
    }
    //双倍火力
    public void addDoubleFire(){
        DOUBLE_FIRE+=40;
    }
    //加命
    public void addLife(){
        LIFE++;
    }
    //获取英雄机的命数
    public int getLIFE(){ return LIFE;}
    public void subtractLife(){
        LIFE--;
    }
    public  void setDOUBLE_FIRE(int DOUBLE_FIRE){
        this.DOUBLE_FIRE=DOUBLE_FIRE;
    }
    public boolean  hit(FlyingObject other){
        int x1 = other.x - this.width/2 ;
        int x2 = other.x + other.width + this.width/2 ;
        int y1 = other.y - this.height/2 ;
        int y2 = other.y + other.height + this.height/2 ;
        return this.x + this.width/2 > x1 && this.x + this.width/2 < x2 && this.y + this.height/2 > y1 && this.y + this.width/2 <y2 ;
    }

}
