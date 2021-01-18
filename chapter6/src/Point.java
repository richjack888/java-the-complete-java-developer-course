public class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * ((this.y - y)));
    }

    public double distance(Point xy) {
        return Math.sqrt((this.x - xy.x) * (this.x - xy.x) + (this.y - xy.y) * (this.y - xy.y));
    }

}
