package Javaa.OOP;

public class Point3d extends Poin2d {
    private double z;

    public Point3d() {
        super();
        this.z = 0.0;
    }

    public Point3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D [x=" + this.getX() + ", y=" + this.getY() + ", z=" + this.z + "]";
    }

    @Override
    public double distance() {
        return Math.sqrt(super.distance() * super.distance() + this.z * this.z);
    }

    // Định nghĩa lại hàm xác định điểm đối xứng qua gốc tọa độ cho 3D
    @Override
    public Poin2d symmetricPoint() {
        return new Point3d(-this.getX(), -this.getY(), -this.z);
    }

    // Tịnh tiến điểm với độ lệch dx, dy và dz
    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);
        this.z += dz;
    }
}
