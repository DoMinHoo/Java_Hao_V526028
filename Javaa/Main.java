package Javaa;
public class Main {
    public static void main(String[] args) {
       HinhTron ht1 = new HinhTron(1, 1, 3.5);
       HinhTron ht2 = new HinhTron();
       System.out.println(ht1);
        System.out.println(ht2);
        System.out.println("Dien tich hinh tron 1: " + ht1.tinhDienTich());
        System.out.println("Dien tich hinh tron 2: " + ht2.tinhDienTich());
        if(ht1.tinhDienTich() > ht2.tinhDienTich()) {
            System.out.println("Hinh tron 1 co dien tich lon hon hinh tron 2");
        } else if(ht1.tinhDienTich() < ht2.tinhDienTich()) {
            System.out.println("Hinh tron 2 co dien tich lon hon hinh tron 1");
        } else {
            System.out.println("Hai hinh tron co dien tich bang nhau");
        }


        
    }   
}
