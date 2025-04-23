package com.example.myapplication.API;

import com.example.myapplication.model.ListNhanVat;
import com.example.myapplication.model.NhanVat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GenshinApi {
    @GET("characters/all")
    Call<List<NhanVat>> getNhanVats();
}
