package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.model.NhanVat;

public class Gacha_1x extends AppCompatActivity {

    private Button btn1xThoat;
    private ImageView imgView1x;
    private TextView txtName1x, txtRarity1x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gacha1x);

        txtName1x = findViewById(R.id.txtName1x);
        imgView1x = findViewById(R.id.imgView1x);
        txtRarity1x = findViewById(R.id.txtRarity1x);
        btn1xThoat = findViewById(R.id.btn1xThoat);
        btn1xThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        NhanVat nhanVat = (NhanVat) intent.getSerializableExtra("nhanVat");


        if (nhanVat != null) {

            txtName1x.setText(nhanVat.getName());

            String rarityText = "";
            switch (nhanVat.getRarity()) {
                case 5:
                    rarityText = "5 sao";
                    break;
                case 4:
                    rarityText = "4 sao";
                    break;
                case 3:
                    rarityText = "3 sao";
                    break;
                default:
                    rarityText = "Unknown rarity";
                    break;
            }
            txtRarity1x.setText(rarityText);

            String iconUrl = "https://genshin.jmp.blue/characters/" + nhanVat.getId() + "/gacha-splash";
            Glide.with(this).load(iconUrl).into(imgView1x);
        }
    }
}