package Javaa.PhanSo;

import java.math.BigInteger;

public class PhanSo implements Comparable<PhanSo> {
    private int T;
    private int M;

    public PhanSo() {
        this(0, 1);
    }

    public PhanSo(int T, int M) {
        if (M == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0");
        }
        this.T = T;
        this.M = M;
        chuanHoaDau();
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
        chuanHoaDau();
    }

    public int getM() {
        return M;
    }

    public void setM(int M) {
        if (M == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0");
        }
        this.M = M;
        chuanHoaDau();
    }

    public PhanSo cong(PhanSo other) {
        BigInteger tu = BigInteger.valueOf(T).multiply(BigInteger.valueOf(other.M))
                .add(BigInteger.valueOf(other.T).multiply(BigInteger.valueOf(M)));
        BigInteger mau = BigInteger.valueOf(M).multiply(BigInteger.valueOf(other.M));
        return taoPhanSoRutGon(tu, mau);
    }

    public PhanSo tru(PhanSo other) {
        BigInteger tu = BigInteger.valueOf(T).multiply(BigInteger.valueOf(other.M))
                .subtract(BigInteger.valueOf(other.T).multiply(BigInteger.valueOf(M)));
        BigInteger mau = BigInteger.valueOf(M).multiply(BigInteger.valueOf(other.M));
        return taoPhanSoRutGon(tu, mau);
    }

    public PhanSo nhan(PhanSo other) {
        BigInteger tu = BigInteger.valueOf(T).multiply(BigInteger.valueOf(other.T));
        BigInteger mau = BigInteger.valueOf(M).multiply(BigInteger.valueOf(other.M));
        return taoPhanSoRutGon(tu, mau);
    }

    public PhanSo chia(PhanSo other) {
        if (other.T == 0) {
            throw new IllegalArgumentException("Khong the chia cho phan so 0");
        }
        BigInteger tu = BigInteger.valueOf(T).multiply(BigInteger.valueOf(other.M));
        BigInteger mau = BigInteger.valueOf(M).multiply(BigInteger.valueOf(other.T));
        return taoPhanSoRutGon(tu, mau);
    }

    public int soSanh(PhanSo other) {
        BigInteger veTrai = BigInteger.valueOf(T).multiply(BigInteger.valueOf(other.M));
        BigInteger vePhai = BigInteger.valueOf(other.T).multiply(BigInteger.valueOf(M));
        return veTrai.compareTo(vePhai);
    }

    @Override
    public int compareTo(PhanSo other) {
        return soSanh(other);
    }

    public PhanSo rutGon() {
        PhanSo rutGon = taoPhanSoRutGon(BigInteger.valueOf(T), BigInteger.valueOf(M));
        T = rutGon.T;
        M = rutGon.M;
        return this;
    }

    public boolean laSoNguyen() {
        return T % M == 0;
    }

    private void chuanHoaDau() {
        if (M < 0) {
            T = BigInteger.valueOf(T).negate().intValueExact();
            M = BigInteger.valueOf(M).negate().intValueExact();
        }
    }

    private static PhanSo taoPhanSoRutGon(BigInteger tu, BigInteger mau) {
        if (mau.signum() == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0");
        }
        if (mau.signum() < 0) {
            tu = tu.negate();
            mau = mau.negate();
        }
        BigInteger ucln = tu.gcd(mau);
        tu = tu.divide(ucln);
        mau = mau.divide(ucln);
        return new PhanSo(tu.intValueExact(), mau.intValueExact());
    }

    @Override
    public String toString() {
        return T + "/" + M;
    }
}
