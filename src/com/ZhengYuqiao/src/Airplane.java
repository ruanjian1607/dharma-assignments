/**
 * 地方飞机是飞行物也是敌人
 */
public class Airplane extends FLyingObject implements Enemy{
    private int speed = 2;

    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        x = (int)(Math.random()*(ShootGame.WIDTH - width));
        // y = 100;
        //x = 100;
    }
    public int getScore(){
        return 5;
    }

    @Override
    public void step(){
        y+= speed;
    }
    @Override
    public boolean outOfBounds(){
        return y>ShootGame.HEIGHT;
    }
}
