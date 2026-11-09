package Javaa.OOP.B1;

import java.util.Scanner;

public class NhanVien extends Nguoi {
    private int snct; // Số năm công tác
    private double hsl; // Hệ số lương

    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, int tuoi, int snct, double hsl) {
        super(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    public int getSnct() {
        return snct;
    }

    public void setSnct(int snct) {
        this.snct = snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    // Công thức tính tiền lương: tienluong = lcb * hsl + phucap
    // lcb = 1.5 triệu, phucap = 0.2 triệu * snct
    public double tinhTienLuong() {
        double lcb = 1.5;
        double phucap = 0.2 * snct;
        return lcb * hsl + phucap;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap so nam cong tac (snct): ");
            snct = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap he so luong (hsl): ");
        hsl = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(", So nam cong tac: %d, He so luong: %.2f, Tien luong: %.2f trieu\n", snct, hsl, tinhTienLuong());
    }
}