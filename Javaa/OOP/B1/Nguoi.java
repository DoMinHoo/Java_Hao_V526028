package Javaa.OOP.B1;

import java.util.Scanner;

public class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(scanner.nextLine());
    }

    public void xuat() {
        System.out.printf("Ho ten: %s, Tuoi: %d", hoTen, tuoi);
    }
}