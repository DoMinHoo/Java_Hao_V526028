package Javaa.OOP;

public class Poin2d {
    private double x;
    private double y;

    public Poin2d() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Poin2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }

    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distance(Poin2d p) {
        return Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y, 2));
    }
    // Xác định điểm đối xứng qua gốc tọa độ
    public Poin2d symmetricPoint() {
        return new Poin2d(-this.x, -this.y);
    }

    // Tịnh tiến điểm đi một vị trí với độ lệch deltaX, deltaY
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}
