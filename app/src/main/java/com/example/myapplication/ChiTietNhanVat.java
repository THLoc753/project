package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.NhanVat;

public class ChiTietNhanVat extends AppCompatActivity {

    private ImageView img_nv;

    private TextView txtName, txtTitle, txtVision, txtWeapon, txtRarity, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_nhan_vat);

        txtName = findViewById(R.id.txtName);
        txtTitle = findViewById(R.id.txtTitle);
        txtVision = findViewById(R.id.txtVision);
        txtWeapon = findViewById(R.id.txtWeapon);
        txtRarity = findViewById(R.id.txtRarity);
        txtDescription = findViewById(R.id.txtDescription);
        img_nv = findViewById(R.id.img_nv);

        // Get the NhanVat object from the Intent
        Intent intent = getIntent();
        NhanVat nhanVat = (NhanVat) intent.getSerializableExtra("nhanVat");

        if (nhanVat != null) {
            // Set data to views
            txtName.setText(nhanVat.getName());
            txtTitle.setText("Title: " + nhanVat.getTitle());
            txtVision.setText("Vision: " + nhanVat.getVision());
            txtWeapon.setText("Weapon: " + nhanVat.getWeapon());
            txtRarity.setText("Rarity: " + nhanVat.getRarity());
            txtDescription.setText("Description: " + nhanVat.getDescription());

            String iconUrl = "https://genshin.jmp.blue/characters/" + nhanVat.getId().toLowerCase() + "/icon";
            Glide.with(this).load(iconUrl).into(img_nv);
        }
    }
}