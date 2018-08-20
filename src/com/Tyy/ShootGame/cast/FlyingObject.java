package com.Tyy.ShootGame.cast;
/*
需求：FlyingObject类是所有子类的父类，其中包含各个子类共有的属性、方法。
      所有子类：英雄机、敌机、蜜蜂、子弹。
      共有的属性：图片属性、坐标x、坐标y、宽width、高height。
      共有的方法：以上五个属性的get/set方法。
注意：以上父类中的属性，后来的代码中会产生继承关系，所以属性用关键词protected修饰。
*/

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    //共有的属性：图片属性、坐标x、坐标y、宽width、高height
    protected  int x;
    protected  int y;
    protected  int width;
    protected  int height;
    protected BufferedImage image;   //BufferedImage需要导包

    //以上五个属性的get/set方法
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public abstract void step();

    public boolean shootBy(Bullet bullet){
        int x = bullet.x;
        int y = bullet.y;
        return (this.x < x) && (x<this.x + width) && (this.y < y) && (y<this.y + height);
    }

    public abstract boolean outOfRounds();
}
