package Javaa.PhanSo;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PhanSo> danhSach = Arrays.asList(
                new PhanSo(1, 2),
                new PhanSo(3, 4),
                new PhanSo(5, 2),
                new PhanSo(6, 3)
        );

        PhanSo tong = new PhanSo();
        PhanSo lonNhat = danhSach.get(0);
        int soPhanSoKhongNguyen = 0;

        for (PhanSo phanSo : danhSach) {
            System.out.println(phanSo);
            tong = tong.cong(phanSo);
            if (phanSo.soSanh(lonNhat) > 0) {
                lonNhat = phanSo;
            }
            if (!phanSo.laSoNguyen()) {
                soPhanSoKhongNguyen++;
            }
        }

        System.out.println("Phan so lon nhat: " + lonNhat);
        System.out.println("Tong cac phan so: " + tong);
        System.out.println("So phan so khong phai so nguyen: " + soPhanSoKhongNguyen);
    }
}
