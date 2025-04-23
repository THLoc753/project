package com.example.myapplication.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://genshin.jmp.blue/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            // Tạo HttpLoggingInterceptor để log các yêu cầu và phản hồi HTTP
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client) // Thiết lập OkHttpClient
                    .addConverterFactory(GsonConverterFactory.create()) // Chuyển đổi JSON thành đối tượng Java
                    .build();
        }
        return retrofit;
    }

}
