package gof;

class PointCartesian{
    private int x,y;

    public PointCartesian(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x,int y){
        this.x += x;
        this.y += y;
    }
    @Override
    public String toString(){
        return"(" + x + "," + y + ")";
    }
}

class PointPolar{
    private double radius,angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void rorate(double angle){
        this.angle += angle % 360;
    }

    @Override
    public String toString(){
        return "(" + radius + "@" + angle + ")";
    }
}


class Point{
    private PointCartesian pointCartesian;

    public Point(int x,int y) {
        this.pointCartesian =  new PointCartesian(x,y);
    }

    public void move(int x,int y){
        pointCartesian.move(x,y);
    }

    public void rorate(double angle,Point o){
        int x = pointCartesian.getX() - o.pointCartesian.getX();
        int y = pointCartesian.getY() - o.pointCartesian.getY();
        PointPolar pointPolar = new PointPolar(Math.sqrt(x*x + y*y),Math.atan2(y,x) * 180 / Math.PI);
        pointPolar.rorate(angle);
        System.out.println("pointPolar is" + pointPolar);
        String str = pointPolar.toString();
        int i = str.indexOf("@");
        double r = Double.parseDouble(str.substring(1,i));
        double a = Double.parseDouble(str.substring(i + 1,str.length() - 1));

        pointCartesian = new PointCartesian((int) (r * Math.cos(a * Math.PI / 180))+ o.pointCartesian.getX(),
                (int)(r * Math.sin(a * Math.PI /180)) + o.pointCartesian.getY());

    }

    @Override
    public String toString() {
        return pointCartesian.toString();
    }
}


class Line{
    private Point start,end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void move(int x,int y){
        start.move(x,y);
        end.move(x,y);
    }

    public void rorate(int angle){
        end.rorate(angle,start);
    }

    @Override
    public String toString(){
        return "Line[start :" + start + ",end:" + end + "]";
    }
}

public class FacadeShape {

    public static void main(String[] args) {
        Line lineA = new Line(new Point(0,0),new Point(1,1));
        lineA.move(1,1);
        System.out.println(lineA);


        lineA.rorate(45);
        System.out.println(lineA);
    }
}
