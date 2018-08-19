package com.Tyy.ShootGame.cast;
/*
需求：ShootGame类继承于JPanel，用于加载图片。
分析：利用ImageI()和read()方法加载图片；
      使用静态常量定义面板的宽和高
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ShootGame extends JPanel {
    public static final int WIDTH = 400;  //面板的宽
    public static  final int HEIGHT = 654; //面板的高

    private int score = 0;

    public static BufferedImage background ;
    public static BufferedImage start ;
    public static BufferedImage airplane ;
    public static BufferedImage bee ;
    public static BufferedImage bullet;
    public static BufferedImage gameover ;
    public static BufferedImage hero0 ;
    public static BufferedImage hero1 ;
    public static BufferedImage pause ;

    private int state;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2 ;
    public static final int GAME_OVER = 3 ;

    private FlyingObject[] flyings = {};  //敌机数组
    private Bullet[] bullets = {}; //子弹数组
    private Hero hero = new Hero();  //英雄机对象
    //构造方法
    public ShootGame(){
        //初始化一只蜜蜂和敌机
      /*  flyings = new FlyingObject[2];
        flyings[1] = new Airplane();
        flyings[2] = new Bee();
        //初始化一颗子弹
        bullets = new Bullet[1];
        bullets[0] = new Bullet(200,300);*/
    }
    static {
        try{
            //backgound = ImageIO.read(ShootGame.class.getResource("backgound.png"));
            background = ImageIO.read(ShootGame.class.getResource("background.png"));
            start = ImageIO.read(ShootGame.class.getResource("start.png"));
            airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
            bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
            bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
            gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
            hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
            hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
            pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(background,0,0,null); //画背景图
        paintHero(g);  //画英雄机
        paintBullets(g);//画子弹
        paintFlyingObjects(g);//画敌机和蜜蜂
        paintScore(g); //画分数
        paintState(g);
    }

    private void paintFlyingObjects(Graphics g) {
       for(int i = 0;i < flyings.length;i++){
            FlyingObject f = flyings[i];
            g.drawImage(f.getImage(),f.getX(),f.getY(),null);
       }
    }

    private void paintBullets(Graphics g) {
        for(int j = 0 ; j<bullets.length; j++){
            Bullet b = bullets[j];
            g.drawImage(b.getImage(),b.getX(),b.getY(),null);
        }
    }

    private void paintHero(Graphics g) {
        g.drawImage(hero.getImage(),hero.getX(),hero.getY(),null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fly");
        ShootGame game = new ShootGame();  //创建面板对象
        frame.add(game);
        frame.setSize(WIDTH,HEIGHT);  //设置面板大小
        frame.setAlwaysOnTop(true);  //设置为一直在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置点击叉号关闭窗体
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.action();
    }

    public static FlyingObject nextone(){
        Random rand  = new Random();
        int type = rand.nextInt(20); //0~9
        if(type == 0){
            return new Bee();
        }else{
            return new Airplane();
        }
    }

    int flyEnteredIndex = 0;  //飞行物的入场数
    public void enterAction(){
        flyEnteredIndex++;
        if(flyEnteredIndex % 40 == 0){
            FlyingObject obj = nextone();  //随机生成飞行物
            flyings = Arrays.copyOf(flyings,flyings.length+1);
            flyings[flyings.length-1] = obj; //新生成的飞行物加入最后
        }
    }

    public void stepAction(){
        //飞行物走一步（蜜蜂敌机）
        for(int i = 0 ;i<flyings.length;i++){
            FlyingObject f = flyings[i];
            f.step();
        }
        //子弹走一步
        for(int i= 0 ; i < bullets.length;i++){
            Bullet b =bullets[i];
            b.step();
        }
        hero.step();
    }
    private Timer  timer;  //定时器
    private int intervel = 1000/100; //时间间隔为毫秒


    public void action(){

        //鼠标监听事件
        MouseAdapter l = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                if(state == RUNNING) {
                    int x = e.getX();
                    int y = e.getY();
                    hero.moveTo(x, y);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){ //鼠标进入
                if(state == PAUSE){
                    state = RUNNING;
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(state != GAME_OVER){
                    state = PAUSE;
                }
            }
            @Override
            public void mouseClicked(MouseEvent e){
                switch (state){
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER:
                        flyings  =  new FlyingObject[0];
                        bullets = new Bullet[0];
                        hero = new Hero();
                        score = 0;
                        state = START;
                        break;
                }
            }
        };
        this.addMouseListener(l);
        this.addMouseMotionListener(l);  //处理鼠标滑动操作

        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
                    public void run(){
                    if(state == RUNNING) {
                        enterAction();
                        stepAction();
                        shootAction();
                        bangAction();
                        outOfBoundsAction();
                        checkGameOverAction();
                    }
                        repaint();
                    }
        },intervel,intervel);
    }


    int shootIndex = 0;
    public void shootAction(){
        shootIndex++;
        //Hero hero = new Hero();
        if(shootIndex%30==0){
            Bullet[] bs = hero.shoot();
            bullets = Arrays.copyOf(bullets,bullets.length+bs.length);
            System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);
        }
    }
    //子弹与飞行物的碰撞检测
    public  void bangAction(){
        for(int i = 0 ;i<bullets.length;i++){
            Bullet b = bullets[i];
            bang(b);
        }
    }
    //子弹和飞行物之间的碰撞检查
    public void bang(Bullet bullet){
        int index = -1 ;
        for(int i = 0;i<flyings.length;i++){
            FlyingObject obj = flyings[i];
            if(obj.shootBy(bullet)){
                index = i;
                break;
            }
        }
        if(index!=-1){
            FlyingObject one = flyings[index];
            FlyingObject temp = flyings[index];
            flyings[index]=flyings[flyings.length-1];
            flyings[flyings.length-1] = temp;

            //删除最后一个飞行物
            flyings = Arrays.copyOf(flyings,flyings.length-1);
            //判断One的类型，如果是敌机就算分
            if(one instanceof  Enemy){
                Enemy e = (Enemy)one;
                score +=e.getScore();
            }
            if(one instanceof Award){
                Award a = (Award)one;
                int type = a.GetType();
                switch(type){
                    case Award.DOUBLE_FIRE:
                        hero.addDoubleFire();
                        break;
                    case Award.Life:
                        hero.addLife();
                        break;
                }
            }
        }
    }
    public void paintScore(Graphics g){
        int x = 10;
        int y = 25;
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,14);
        g.setColor(new Color(0X3A3B3B));
        g.setFont(font);
        g.drawString("SCORE:"+score,x,y);
        y +=20;
        g.drawString("LIFE:"+hero.getLIFE(),x,y);
    }
    public void outOfBoundsAction(){
        int index = 0;
        //存活着的飞行物
        FlyingObject[] flyingLives = new FlyingObject[flyings.length];
        for(int i = 0;i<flyings.length;i++){
            FlyingObject f = flyings[i];
            if(!f.outOfRounds()){
                flyingLives[index++] = f;
            }
        }
        flyings = Arrays.copyOf(flyingLives,index);
        index = 0;
        Bullet[] bulletLives = new Bullet[bullets.length];
        for(int i = 0; i<bullets.length;i++){
            Bullet b = bullets[i];
            if(!b.outOfRounds()){
                bulletLives[index++] = b;
            }
        }
        bullets = Arrays.copyOf(bulletLives,index);
    }

    public boolean isGameOver(){
        for(int i = 0;i<flyings.length;i++){
            int index= -1;
            FlyingObject obj = flyings[i];
            if(hero.hit(obj)){
                hero.subtractLife();
                hero.setDOUBLE_FIRE(0);
                index = i;
            }
            if(index!=-1){
                FlyingObject t = flyings[index];
                flyings[index] = flyings[flyings.length-1];
                flyings[flyings.length-1] = t ;
                flyings = Arrays.copyOf(flyings,flyings.length-1);
            }
        }
        return hero.getLIFE() <= 0;
    }

    public void checkGameOverAction(){
        if(isGameOver()){
            state = GAME_OVER;
        }
    }

    public void paintState(Graphics g){
        switch (state){
            case START:
                g.drawImage(start,0,0,null);
                break;
            case PAUSE:
                g.drawImage(pause,0,0,null);
                break;
            case GAME_OVER:
                g.drawImage(gameover,0,0,null);
                break;
        }
    }

}
