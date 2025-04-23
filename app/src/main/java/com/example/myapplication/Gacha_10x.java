package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.NhanVat;

import java.util.List;

public class Gacha_10x extends AppCompatActivity {

    Button btn10xThoat;
    ImageView img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8, img_9, img_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gacha10x);

        // Get the data passed from the Intent
        Intent intent = getIntent();
        List<NhanVat> nhanVatList = (List<NhanVat>) intent.getSerializableExtra("nhanVatList");

        // Set up the button to close the activity
        btn10xThoat = findViewById(R.id.btn10xThoat);
        btn10xThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialize ImageViews for each Gacha pull result
        img_1 = findViewById(R.id.img_1);
        img_2 = findViewById(R.id.img_2);
        img_3 = findViewById(R.id.img_3);
        img_4 = findViewById(R.id.img_4);
        img_5 = findViewById(R.id.img_5);
        img_6 = findViewById(R.id.img_6);
        img_7 = findViewById(R.id.img_7);
        img_8 = findViewById(R.id.img_8);
        img_9 = findViewById(R.id.img_9);
        img_10 = findViewById(R.id.img_10);

        // Load images into ImageViews if the list is not null
        if (nhanVatList != null && nhanVatList.size() == 10) {
            for (int i = 0; i < 10; i++) {
                NhanVat nhanVat = nhanVatList.get(i);
                String iconUrl = "https://genshin.jmp.blue/characters/" + nhanVat.getId().toLowerCase() + "/gacha-card";
                loadCharacterImage(i, iconUrl);
            }
        }
    }
    // Method to load character images dynamically based on index
    private void loadCharacterImage(int index, String iconUrl) {
        switch (index) {
            case 0:
                Glide.with(this).load(iconUrl).into(img_1);
                break;
            case 1:
                Glide.with(this).load(iconUrl).into(img_2);
                break;
            case 2:
                Glide.with(this).load(iconUrl).into(img_3);
                break;
            case 3:
                Glide.with(this).load(iconUrl).into(img_4);
                break;
            case 4:
                Glide.with(this).load(iconUrl).into(img_5);
                break;
            case 5:
                Glide.with(this).load(iconUrl).into(img_6);
                break;
            case 6:
                Glide.with(this).load(iconUrl).into(img_7);
                break;
            case 7:
                Glide.with(this).load(iconUrl).into(img_8);
                break;
            case 8:
                Glide.with(this).load(iconUrl).into(img_9);
                break;
            case 9:
                Glide.with(this).load(iconUrl).into(img_10);
                break;
        }
    }
}
