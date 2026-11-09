package Javaa.OOP.B1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien n: ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<NhanVien> danhSachNV = new ArrayList<>();

        // 1. Nhập vào n nhân viên
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin nhan vien thu " + (i + 1) + ":");
            NhanVien nv = new NhanVien();
            nv.nhap();
            danhSachNV.add(nv);
        }

        // 2. Tìm nhân viên có số năm công tác nhiều nhất
        if (!danhSachNV.isEmpty()) {
            int maxSnct = danhSachNV.get(0).getSnct();
            for (NhanVien nv : danhSachNV) {
                if (nv.getSnct() > maxSnct) {
                    maxSnct = nv.getSnct();
                }
            }

            System.out.println("\n--- Nhan vien co so nam cong tac nhieu nhat (" + maxSnct + " nam) ---");
            for (NhanVien nv : danhSachNV) {
                if (nv.getSnct() == maxSnct) {
                    nv.xuat();
                }
            }
        }

        // 3. Sắp xếp và in danh sách nhân viên theo thứ tự lương từ cao đến thấp
        danhSachNV.sort((nv1, nv2) -> Double.compare(nv2.tinhTienLuong(), nv1.tinhTienLuong()));

        System.out.println("\n--- Danh sach nhan vien theo luong tu cao den thap ---");
        for (NhanVien nv : danhSachNV) {
            nv.xuat();
        }
    }
}