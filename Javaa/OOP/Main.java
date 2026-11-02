package Javaa.OOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {
        // Yêu cầu 3.1: Tạo một danh sách điểm bao gồm 2D và 3D
        List<Poin2d> l_points = new ArrayList<>();

        // Thêm các điểm 2D
        l_points.add(new Poin2d(1.0, 5.0));
        l_points.add(new Poin2d(3.0, 7.0));

        // Thêm các điểm 3D
        l_points.add(new Point3d(1.0, 5.0, 3.5));
        l_points.add(new Point3d(3.0, 7.0, 2.0));

        System.out.println("=== DANH SACH CAC DIEM BAN DAU ===");
        for (Poin2d point : l_points) {
            System.out.println(point.toString());
        }

        // Yêu cầu 3.2: Tính tổng khoảng cách các điểm 2D và tổng khoảng cách các điểm 3D
        double sum2D = 0.0;
        double sum3D = 0.0;

        for (Poin2d point : l_points) {
            if (point instanceof Point3d) {
                sum3D += point.distance();
            } else {
                sum2D += point.distance();
            }
        }

        System.out.println("\n=== TONG KHOANG CACH ===");
        System.out.println("Tong khoảng cách các điểm 2D: " + sum2D);
        System.out.println("Tong khoảng cách các điểm 3D: " + sum3D);

        // Bổ sung: Tịnh tiến các điểm trong danh sách với một khoảng lệch (Ví dụ: Δx=1.0, Δy=2.0, Δz=1.5)
        System.out.println("\n=== DANH SACH SAU KHI TINH TIEN (dx=1.0, dy=2.0, dz=1.5) ===");
        for (Poin2d point : l_points) {
            if (point instanceof Point3d) {
                ((Point3d) point).translate(1.0, 2.0, 1.5);
            } else {
                point.translate(1.0, 2.0);
            }
            System.out.println(point.toString());
        }

        // Yêu cầu 3.3: Đưa các điểm đối xứng vào danh sách và hiển thị danh sách các điểm
        List<Poin2d> symmetricPointsList = new ArrayList<>();
        for (Poin2d point : l_points) {
            symmetricPointsList.add(point.symmetricPoint());
        }
        l_points.addAll(symmetricPointsList);

        System.out.println("\n=== DANH SACH SAU KHI THEM CAC DIEM DOI XUNG ===");
        for (Poin2d point : l_points) {
            System.out.println(point.toString());
        }
    }
}
