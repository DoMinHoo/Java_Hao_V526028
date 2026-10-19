import java.util.Scanner;

public class B2 {

    // --- HAM GIAI TOAN BO BAI 1 ---
    public static void giaiBai1(Scanner scanner) {
        System.out.println("\n==================================");
        System.out.println("          DANG CHAY BAI 1         ");
        System.out.println("==================================");
        
        // 1. Nhap n phan tu, in mang va tong
        System.out.println("\n[Phan 1] Nhap mang n phan tu, in mang va tong:");
        System.out.print("Nhap so luong phan tu n: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        int sum1 = 0;
        System.out.println("Nhap " + n1 + " phan tu:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
            sum1 += arr1[i];
        }
        System.out.print("Mang vua nhap: ");
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println("\nTong cac phan tu: " + sum1);

        // 2. Nhap n phan tu, tim chi so cua 1 so nguyen
        System.out.println("\n[Phan 2] Nhap mang va tim chi so cua 1 so:");
        System.out.print("Nhap so luong phan tu n: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Nhap " + n2 + " phan tu:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        System.out.print("Nhap so nguyen can tim chi so: ");
        int target = scanner.nextInt();
        boolean found = false;
        System.out.print("Cac chi so cua " + target + " trong mang la: ");
        for (int i = 0; i < n2; i++) {
            if (arr2[i] == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("Khong tim thay trong mang!");
        }
        System.out.println();

        // 3. Tim phan tu lon nhat dung Math.max()
        System.out.println("\n[Phan 3] Tim phan tu lon nhat (dung Math.max):");
        System.out.print("Nhap so luong phan tu n: ");
        int n3 = scanner.nextInt();
        if (n3 > 0) {
            int[] arr3 = new int[n3];
            System.out.println("Nhap " + n3 + " phan tu:");
            for (int i = 0; i < n3; i++) {
                arr3[i] = scanner.nextInt();
            }
            int maxVal = arr3[0];
            for (int i = 1; i < n3; i++) {
                maxVal = Math.max(maxVal, arr3[i]);
            }
            System.out.println("Phan tu lon nhat la: " + maxVal);
        } else {
            System.out.println("So luong phan tu khong hop le!");
        }

        // 4. Nhap cac so nguyen, dung khi tong > 50
        System.out.println("\n[Phan 4] Nhap cac so nguyen, dung khi tong > 50:");
        int tongTichLuy = 0;
        System.out.println("Nhap cac so nguyen (chuong trinh se dung khi tong > 50):");
        while (tongTichLuy <= 50) {
            System.out.print("Nhap 1 so: ");
            int num = scanner.nextInt();
            tongTichLuy += num;
            System.out.println("Tong hien tai: " + tongTichLuy);
        }
        System.out.println("Tong da vuot qua 50! Tong cuoi cung la: " + tongTichLuy);
    }

    // --- HAM GIAI TOAN BO BAI 2 ---
    public static void giaiBai2(Scanner scanner) {
        System.out.println("\n==================================");
        System.out.println("          DANG CHAY BAI 2         ");
        System.out.println("==================================");
        scanner.nextLine(); // Doc bo dong thua
        System.out.print("Nhap ho ten cua ban: ");
        String fullName = scanner.nextLine();

        // Chuan hoa khoang trang thua: xoa dau/cuoi va gom nhieu khoang trang thanh 1
        fullName = fullName.trim().replaceAll("\\s+", " ");
        
        if (fullName.isEmpty()) {
            System.out.println("Ban chua nhap ho ten!");
            return;
        }

        String[] words = fullName.split(" ");
        if (words.length == 1) {
            System.out.println("Ho: (trong)");
            System.out.println("Ten: " + words[0]);
        } else {
            String ten = words[words.length - 1];
            String ho = "";
            for (int i = 0; i < words.length - 1; i++) {
                ho += words[i] + (i == words.length - 2 ? "" : " ");
            }
            System.out.println("Ho la: \"" + ho + "\"");
            System.out.println("Ten la: \"" + ten + "\"");
        }
    }

    // --- HAM PHU TRO CHO BAI 3 (CONG 2 MANG) ---
    public static void inMangTong(int[] a1, int[] a2) {
        int maxLen = Math.max(a1.length, a2.length);
        int[] sumArr = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            int v1 = (i < a1.length) ? a1[i] : 0;
            int v2 = (i < a2.length) ? a2[i] : 0;
            sumArr[i] = v1 + v2;
        }
        System.out.print("Mang tong cua 2 mang: ");
        for (int val : sumArr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // --- HAM GIAI TOAN BO BAI 3 ---
    public static void giaiBai3(Scanner scanner) {
        System.out.println("\n==================================");
        System.out.println("          DANG CHAY BAI 3         ");
        System.out.println("==================================");

        // 1. Nhap n phan tu, tinh va in ra tong
        System.out.println("\n[Phan 1] Nhap n phan tu va tinh tong:");
        System.out.print("Nhap so luong phan tu n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.println("Nhap " + n + " phan tu:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        System.out.println("Tong cac phan tu: " + sum);

        // 2. Ham nhan vao 2 mang va in ra mang tong
        System.out.println("\n[Phan 2] Ham nhan vao 2 mang va in ra mang tong:");
        int[] mang1 = {3, 4, 5, 33};
        int[] mang2 = {1, 2, 10, 20, 50, 100};
        System.out.print("Mang 1 mau: ");
        for (int x : mang1) System.out.print(x + " ");
        System.out.println();
        System.out.print("Mang 2 mau: ");
        for (int x : mang2) System.out.print(x + " ");
        System.out.println();
        inMangTong(mang1, mang2);

        // 3. Nhap mang bang 1 chuoi duy nhat cach nhau boi dau cach
        System.out.println("\n[Phan 3] Nhap mang bang 1 chuoi duy nhat:");
        scanner.nextLine(); // Doc bo dong thua
        System.out.print("Nhap chuoi (VD: 3 4 5 33 554 67 23 6 8 5): ");
        String inputStr = scanner.nextLine().trim();

        if (!inputStr.isEmpty()) {
            String[] parts = inputStr.split("\\s+");
            int count = parts.length;
            int sumStr = 0;
            for (String s : parts) {
                sumStr += Integer.parseInt(s);
            }
            System.out.println("So phan tu: " + count + "; Tong: " + sumStr);
        } else {
            System.out.println("So phan tu: 0; Tong: 0");
        }
    }

    // --- HAM MAIN (MENU CHINH) ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n==================================");
            System.out.println("       MENU LUA CHON BAI TAP      ");
            System.out.println("==================================");
            System.out.println("1. Chay Bai 1 (Mang, tim kiem, max, vong lap > 50)");
            System.out.println("2. Chay Bai 2 (Xu ly chuoi Ho va Ten)");
            System.out.println("3. Chay Bai 3 (Tong mang, cong 2 mang, nhap chuoi)");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("==================================");
            System.out.print("Nhap lua chon cua ban (0-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    giaiBai1(scanner);
                    break;
                case 2:
                    giaiBai2(scanner);
                    break;
                case 3:
                    giaiBai3(scanner);
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap tu 0 den 3.");
            }
        } while (choice != 0);

        scanner.close();
    }
}