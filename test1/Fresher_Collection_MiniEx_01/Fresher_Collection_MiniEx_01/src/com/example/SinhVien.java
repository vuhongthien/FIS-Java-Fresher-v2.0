package com.example;

import java.util.*;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();



    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
        this.monDaHoc = monDaHoc;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1

    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong
        Integer sum = monDaHoc.stream().mapToInt(Diem::getDiemMonHoc).sum();
        Integer count = monDaHoc.stream().mapToInt(Diem::getSoTinChi).sum();
        //...
        return (float)sum/count;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder info =new StringBuilder("");
        info.append("MSSV"+":"+this.mssv +"\n");
        info.append("Ten"+":"+this.ten +"\n");
        info.append("Danh sách điểm"+"\n");
        int i=1;
        for (Diem diem: monDaHoc){
            info.append(i+" ");
            int sotin = diem.getMon().getTcLT()+diem.getMon().getTcTH();
            info.append(diem.getMon().getTen() + " "+ diem.getDiem() +" "+ sotin);
            info.append("\n");
            i++;
        }
        info.append("Diem trung binh"+" "+ tinhDiemTrungBinh());
        return info.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        //...
        return null;
    }

    public void setMonDaHoc(Set<Diem> listDiem) {
    }
}
