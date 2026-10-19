import java.util.Scanner;

public class B3 {

    // ==========================================
    // CAC LOP CO SO (DIEM, DUONG THANG, HINH)
    // ==========================================

    // 1. Lop Diem
    public static class Diem {
        private double x;
        private double y;

        public Diem(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() { return x; }
        public void setX(double x) { this.x = x; }

        public double getY() { return y; }
        public void setY(double y) { this.y = y; }

        // Phuong thuc tinh khoang cach giua 2 diem
        public double tinhKhoangcach(Diem d) {
            return Math.sqrt(Math.pow(this.x - d.x, 2) + Math.pow(this.y - d.y, 2));
        }
    }

    // 2. Lop DuongThang
    public static class DuongThang {
        private Diem A;
        private Diem B;

        public DuongThang(Diem A, Diem B) {
            this.A = A;
            this.B = B;
        }

        public Diem getA() { return A; }
        public Diem getB() { return B; }

        public double tinhDoDai() {
            return A.tinhKhoangcach(B);
        }
    }

    // 4. Lop truu tuong Hinh (phuc vu bai 4 ve tinh ke thua)
    public static abstract class Hinh {
        public abstract double tinhChuVi();
        public abstract double tinhDienTich();
        public abstract String getTenLoai();
    }

    // 3. Lop TamGiac (ke thua Hinh cho Bai 4)
    public static class TamGiac extends Hinh {
        private Diem d1, d2, d3;
        private double a, b, c; // do dai 3 canh

        public TamGiac(Diem d1, Diem d2, Diem d3) {
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
            this.a = d1.tinhKhoangcach(d2);
            this.b = d2.tinhKhoangcach(d3);
            this.c = d3.tinhKhoangcach(d1);
        }

        @Override
        public double tinhChuVi() {
            return a + b + c;
        }

        @Override
        public double tinhDienTich() {
            // Cong thuc Heron
            double p = tinhChuVi() / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public String getTenLoai() {
            return "Tam Giac";
        }
    }

    // 3. Lop ChuNhat (ke thua Hinh cho Bai 4)
    public static class ChuNhat extends Hinh {
        private double dai;
        private double rong;

        public ChuNhat(double dai, double rong) {
            this.dai = dai;
            this.rong = rong;
        }

        @Override
        public double tinhChuVi() {
            return (dai + rong) * 2;
        }

        @Override
        public double tinhDienTich() {
            return dai * rong;
        }

        @Override
        public String getTenLoai() {
            return "Chu Nhat";
        }
    }

    // 3. Lop HinhTron (ke thua Hinh cho Bai 4)
    public static class HinhTron extends Hinh {
        private Diem O;
        private double banKinh;

        public HinhTron(Diem O, double banKinh) {
            this.O = O;
            this.banKinh = banKinh;
        }

        @Override
        public double tinhChuVi() {
            return 2 * Math.PI * banKinh;
        }

        @Override
        public double tinhDienTich() {
            return Math.PI * banKinh * banKinh;
        }

        @Override
        public String getTenLoai() {
            return "Hinh Tron";
        }
    }


    // ==========================================
    // CAC HAM THUC THI TUNG BAI TAP
    // ==========================================

    // Giai Bai 1: Diem va DuongThang
    public static void chayBai1(Scanner scanner) {
        System.out.println("\n--- CHAY BAI 1: DIEM VA DUONG THANG ---");
        System.out.println("Nhap toa do diem A (x y): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Diem A = new Diem(x1, y1);

        System.out.println("Nhap toa do diem B (x y): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Diem B = new Diem(x2, y2);

        DuongThang dt = new DuongThang(A, B);
        System.out.println("Do dai duong thang AB la: " + dt.tinhDoDai());
    }

    // Giai Bai 2: Khoi tao 2 TamGiac, 2 ChuNhat, 2 HinhTron bat ky
    public static void chayBai2() {
        System.out.println("\n--- CHAY BAI 2: KHOI TAO SAN VA TINH TOAN ---");
        
        TamGiac tg1 = new TamGiac(new Diem(0, 0), new Diem(3, 0), new Diem(0, 4));
        TamGiac tg2 = new TamGiac(new Diem(1, 1), new Diem(5, 1), new Diem(3, 4));

        ChuNhat cn1 = new ChuNhat(4, 5);
        ChuNhat cn2 = new ChuNhat(3.5, 7);

        HinhTron ht1 = new HinhTron(new Diem(0, 0), 3);
        HinhTron ht2 = new HinhTron(new Diem(2, 2), 5.5);

        System.out.println("Tam Giac 1 - Chu vi: " + tg1.tinhChuVi() + " | Dien tich: " + tg1.tinhDienTich());
        System.out.println("Tam Giac 2 - Chu vi: " + tg2.tinhChuVi() + " | Dien tich: " + tg2.tinhDienTich());
        System.out.println("Chu Nhat 1  - Chu vi: " + cn1.tinhChuVi() + " | Dien tich: " + cn1.tinhDienTich());
        System.out.println("Chu Nhat 2  - Chu vi: " + cn2.tinhChuVi() + " | Dien tich: " + cn2.tinhDienTich());
        System.out.println("Hinh Tron 1 - Chu vi: " + ht1.tinhChuVi() + " | Dien tich: " + ht1.tinhDienTich());
        System.out.println("Hinh Tron 2 - Chu vi: " + ht2.tinhChuVi() + " | Dien tich: " + ht2.tinhDienTich());
    }

    // Giai Bai 3 & 4: Nhap tu ban phim va luu vao mang Hinh (Tinh da hinh)
    public static void chayBai3Va4(Scanner scanner) {
        System.out.println("\n--- CHAY BAI 3 & 4: NHAP HINH TU BAN PHIM & LUU VAO MANG HINH ---");
        System.out.print("Ban muon nhap bao nhieu hinh? ");
        int n = scanner.nextInt();

        Hinh[] danhSachHinh = new Hinh[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap thong tin cho hinh thu " + (i + 1) + " ---");
            System.out.println("Chon loai hinh (1. Tam Giac, 2. Chu Nhat, 3. Hinh Tron): ");
            int chon = scanner.nextInt();

            switch (chon) {
                case 1:
                    System.out.print("Nhap toa do 3 diem (x1 y1 x2 y2 x3 y3): ");
                    double x1 = scanner.nextDouble(), y1 = scanner.nextDouble();
                    double x2 = scanner.nextDouble(), y2 = scanner.nextDouble();
                    double x3 = scanner.nextDouble(), y3 = scanner.nextDouble();
                    danhSachHinh[i] = new TamGiac(new Diem(x1, y1), new Diem(x2, y2), new Diem(x3, y3));
                    break;
                case 2:
                    System.out.print("Nhap chieu dai va chieu rong: ");
                    double dai = scanner.nextDouble();
                    double rong = scanner.nextDouble();
                    danhSachHinh[i] = new ChuNhat(dai, rong);
                    break;
                case 3:
                    System.out.print("Nhap toa do tam O (x y) va ban kinh: ");
                    double ox = scanner.nextDouble(), oy = scanner.nextDouble();
                    double r = scanner.nextDouble();
                    danhSachHinh[i] = new HinhTron(new Diem(ox, oy), r);
                    break;
                default:
                    System.out.println("Lua chon khong hop le, mac dinh tao hinh Chu Nhat(1,1).");
                    danhSachHinh[i] = new ChuNhat(1, 1);
            }
        }

        // In ra danh sach ket qua su dung mang Hinh (Polymorphism)
        System.out.println("\n==========================================");
        System.out.println("       DANH SACH CAC HINH DA NHAP         ");
        System.out.println("==========================================");
        for (int i = 0; i < danhSachHinh.length; i++) {
            Hinh h = danhSachHinh[i];
            System.out.println("Hinh " + (i + 1) + " [" + h.getTenLoai() + "] -> Chu vi: " + h.tinhChuVi() + " | Dien tich: " + h.tinhDienTich());
        }
    }


    // ==========================================
    // HAM MAIN (MENU TRUNG TAM)
    // ==========================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Dung menu switch thong thuong.
            System.out.println("\n==========================================");
            System.out.println("          MENU QUAN LY HINH HOC           ");
            System.out.println("==========================================");
            System.out.println("1. Chay Bai 1 (Lop Diem & DuongThang)");
            System.out.println("2. Chay Bai 2 (Khoi tao san 2 TamGiac, ChuNhat, HinhTron)");
            System.out.println("3. Chay Bai 3 & 4 (Nhap tu ban phim & Luu vao mang Hinh)");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon cua ban (0-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chayBai1(scanner);
                    break;
                case 2:
                    chayBai2();
                    break;
                case 3:
                    chayBai3Va4(scanner);
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap lai.");
            }
        } while (choice != 0);

        scanner.close();
    }
}