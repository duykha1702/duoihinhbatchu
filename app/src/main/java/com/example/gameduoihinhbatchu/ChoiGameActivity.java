package com.example.gameduoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.gameduoihinhbatchu.adapter.DapAn;

import java.util.ArrayList;
import java.util.Random;

public class ChoiGameActivity extends AppCompatActivity {
    private String dapan="soctrang";

    ArrayList<String> arrCauTraLoi;
    GridView gdvCauTraLoi;

    ArrayList<String> arrDapAn;
    GridView gdvDapAn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        init();
        AnhXa();
        Data();
        hienthiCauTraLoi();
        hienthiDapAn();
    }

    private void AnhXa(){
        gdvCauTraLoi = findViewById(R.id.gdvCauTraLoi);
        gdvDapAn = findViewById(R.id.gdvDapAn);
           }
    private void init(){
        arrCauTraLoi = new ArrayList<>();

        arrDapAn = new ArrayList<>();

    }
    private void hienthiCauTraLoi(){
        gdvCauTraLoi.setNumColumns(arrCauTraLoi.size());
        gdvCauTraLoi.setAdapter(new DapAn(this,0,arrCauTraLoi));
    }

    private void hienthiDapAn(){
        gdvDapAn.setNumColumns(arrDapAn.size()/2);
        gdvDapAn.setAdapter(new DapAn(this,0,arrDapAn));
    }
    private void Data(){
        arrCauTraLoi.clear();
        Random r = new Random();

        for (int i=0;i<dapan.length();i++){
           arrCauTraLoi.add("");
           String s = "" + (char)(r.nextInt(26)+65);
           arrDapAn.add(s);

            String s1 = "" + (char)(r.nextInt(26)+65);
            arrDapAn.add(s1);
        }
        for (int i=0;i<dapan.length();i++){
            String s = "" + dapan.charAt(i);
            arrDapAn.set(i,s.toUpperCase());
        }
        for(int i=0;i<10;i++){
            String s = arrDapAn.get(i);
            int vt = r.nextInt(arrDapAn.size());
            arrDapAn.set(i,arrDapAn.get(vt));
            arrDapAn.set(vt,s);
        }
    }
}