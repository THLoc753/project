package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.API.GenshinApi;
import com.example.myapplication.adapter.NhanVatAdapter;
import com.example.myapplication.model.NhanVat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DanhSachNhanVat extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NhanVatAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_nhan_vat);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));

        // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://genshin.jmp.blue/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GenshinApi api = retrofit.create(GenshinApi.class);

        // Lấy dữ liệu từ API
        progressBar.setVisibility(View.VISIBLE);
        Call<List<NhanVat>> call = api.getNhanVats();
        call.enqueue(new Callback<List<NhanVat>>() {
            @Override
            public void onResponse(Call<List<NhanVat>> call, Response<List<NhanVat>> response) {
                if (response.isSuccessful()) {
                    List<NhanVat> nhanvats = response.body();
                    adapter = new NhanVatAdapter(DanhSachNhanVat.this,nhanvats);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(DanhSachNhanVat.this, "Tải dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<NhanVat>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(DanhSachNhanVat.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        });
    }
}