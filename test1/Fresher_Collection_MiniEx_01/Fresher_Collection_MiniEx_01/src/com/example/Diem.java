package com.example;

import java.io.Serializable;

public class Diem implements Comparable<Diem>, Serializable {
    private MonHoc mon;
    private int diem;

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public boolean equals(Object that) {
        // Hai diem duoc goi la bang nhau neu cua cung mot mon
        if (that instanceof Diem) {
            return this.mon.equals(((Diem) that).mon);
        }
        return false;
    }

    @Override
    public int compareTo(Diem o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public Diem clone() {
        return null;
    }
    public int getDiemMonHoc(){
        return this.diem * ( this.getMon().getTcLT() + this.getMon().getTcTH());
    }

    public int getSoTinChi(){
        return this.getMon().getTcLT() + this.getMon().getTcTH();
    }
}
