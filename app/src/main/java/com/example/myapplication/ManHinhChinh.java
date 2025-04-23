package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.model.NhanVat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManHinhChinh extends AppCompatActivity {

    TextView txtPity, txtRoll;
    Button btnThemRoll, btnTTSV, btn1x, btn10x, btnThuVien;
    int pity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_man_hinh_chinh);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();
        initializeCharacterLists();
    }

    private void addControls() {
        txtPity = findViewById(R.id.txtPity);
        txtRoll = findViewById(R.id.txtRoll);
        btnThemRoll = findViewById(R.id.btnThemRoll);
        btnTTSV = findViewById(R.id.btnTTSV);
        btn1x = findViewById(R.id.btn1x);
        btn10x = findViewById(R.id.btn10x);
        btnThuVien = findViewById(R.id.btnThuVien);

        pity = Integer.parseInt(String.valueOf(txtPity.getText()));
    }

    private void addEvents() {
        btnTTSV.setOnClickListener(view -> {
            Intent intent = new Intent(ManHinhChinh.this, ThongTinSinhVien.class);
            startActivity(intent);
        });

        btnThuVien.setOnClickListener(view -> {
            Intent intent = new Intent(ManHinhChinh.this, DanhSachNhanVat.class);
            startActivity(intent);
        });

        btnThemRoll.setOnClickListener(view -> them10Roll(view));

        btn1x.setOnClickListener(view -> tru1Roll(view));

        btn10x.setOnClickListener(view -> tru10Roll(view));
    }

    // Thêm 10 roll
    private void them10Roll(View view) {
        int rolls = Integer.parseInt(String.valueOf(txtRoll.getText()));
        rolls += 10;
        txtRoll.setText(String.valueOf(rolls));
    }

    // Trừ 1 roll
    private void tru1Roll(View view) {
        int rolls = Integer.parseInt(String.valueOf(txtRoll.getText()));
        if (rolls <= 0) {
            Toast.makeText(this, "Không đủ lượt cầu nguyện", Toast.LENGTH_SHORT).show();
        } else {
            rolls -= 1;
            txtRoll.setText(String.valueOf(rolls));
            pity += 1;
            txtPity.setText(String.valueOf(pity));

            NhanVat nhanVat = getRandomNhanVat();
            Intent intent = new Intent(ManHinhChinh.this, Gacha_1x.class);
            intent.putExtra("nhanVat", nhanVat);
            startActivity(intent);
        }
    }

    // Trừ 10 roll
    private void tru10Roll(View view) {
        int rolls = Integer.parseInt(String.valueOf(txtRoll.getText()));
        if (rolls < 10) {
            Toast.makeText(this, "Không đủ lượt cầu nguyện", Toast.LENGTH_SHORT).show();
        } else {
            rolls -= 10;
            txtRoll.setText(String.valueOf(rolls));
            pity += 10;
            txtPity.setText(String.valueOf(pity));

            List<NhanVat> nhanVatList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                NhanVat nhanVat = getRandomNhanVat();
                nhanVatList.add(nhanVat);
            }

            Intent intent = new Intent(ManHinhChinh.this, Gacha_10x.class);
            intent.putExtra("nhanVatList", (Serializable) nhanVatList);
            startActivity(intent);
        }
    }

    private List<String> threeStar = new ArrayList<>();
    private List<String> fourStar = new ArrayList<>();
    private List<String> fourStarUp = new ArrayList<>();
    private List<String> fiveStar = new ArrayList<>();
    private List<String> fiveStarUp = new ArrayList<>();

    private void initializeCharacterLists() {

        threeStar.add("amber");
        threeStar.add("kaeya");
        threeStar.add("lisa");


        fourStar.add("beidou");
        fourStar.add("bennett");
        fourStar.add("chongyun");
        fourStar.add("ningguang");
        fourStar.add("noelle");
        fourStar.add("razor");
        fourStar.add("sucrose");
        fourStar.add("xingqiu");


        fourStarUp.add("barbara");
        fourStarUp.add("fischl");
        fourStarUp.add("xiangling");


        fiveStar.add("diluc");
        fiveStar.add("jean");
        fiveStar.add("mona");
        fiveStar.add("keqing");
        fiveStar.add("qiqi");


        fiveStarUp.add("venti");
    }

    private String getRandomFromList(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    private NhanVat getRandomNhanVat() {
        Random random = new Random();
        int randNum = random.nextInt(1000) + 1;

        String characterId = "";
        String characterName = "";
        String characterImage = "";
        String characterTitle = "Gacha Character";
        String characterVision = "Unknown Vision";
        String characterWeapon = "Unknown Weapon";
        int rarity = 3;
        String description = "Default description";

        if (randNum >= 1 && randNum <= 8) {
            if (random.nextBoolean()) {
                characterId = getRandomFromList(fiveStar);
                characterName = characterId;
                rarity = 5;
            } else {
                characterId = getRandomFromList(fiveStarUp);
                characterName = characterId;
                rarity = 5;
            }
        } else if (randNum >= 9 && randNum <= 20) {
            if (random.nextBoolean()) {
                characterId = getRandomFromList(fourStar);
                characterName = characterId;
                rarity = 4;
            } else {
                characterId = getRandomFromList(fourStarUp);
                characterName = characterId;
                rarity = 4;
            }
        } else {
            characterId = getRandomFromList(threeStar);
            characterName = characterId;
            rarity = 3;
        }


        return new NhanVat(characterId, characterName, characterImage, characterTitle, characterVision, characterWeapon, rarity, description);
    }
}
