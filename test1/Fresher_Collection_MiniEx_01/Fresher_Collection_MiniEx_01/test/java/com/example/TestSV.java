package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSV {
    @Test
    void tinhDiemTrungBinh() {

        // Arrangement
        SinhVien sv = new SinhVien("SV01", "LONG");

        MonHoc mh1 = new MonHoc("CTDL", 3 ,1);
        MonHoc mh2 = new MonHoc("OOP", 3 ,1);
        Diem d1 = new Diem(mh1, 5);
        Diem d2 = new Diem(mh2, 5);

        Set<Diem> listDiem = new HashSet<>();
        listDiem.add(d1);
        listDiem.add(d2);

        sv.setMonDaHoc(listDiem);

        // Action
        double avg = sv.tinhDiemTrungBinh();

        // Assert
        assertEquals(5.0, avg , 0.0001);
    }
    @Test
    void BangDiem(){
        MonHoc monHoc= new MonHoc("CSDL",3,1);
        MonHoc monHoc1= new MonHoc("toán",3,2);
        MonHoc monHoc2= new MonHoc("lý",2,1);
        Diem diem= new Diem(monHoc, 3);
        Diem diem1= new Diem(monHoc1, 5);
        Diem diem2= new Diem(monHoc2, 7);
        Set<Diem> danhsach = new HashSet<>();
        danhsach.add(diem);
        danhsach.add(diem1);
        danhsach.add(diem2);
        SinhVien sinhVien = new SinhVien("D001", "thien");
        System.out.println(sinhVien.bangDiem());

    }
}

