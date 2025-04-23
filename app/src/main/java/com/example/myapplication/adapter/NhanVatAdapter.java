package com.example.myapplication.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.ChiTietNhanVat;
import com.example.myapplication.R;
import com.example.myapplication.model.NhanVat;

import java.util.List;

public class NhanVatAdapter extends RecyclerView.Adapter<NhanVatAdapter.NhanVatViewHolder> {

    private Context context;
    private List<NhanVat> nhanVatList;

    public NhanVatAdapter(Context context, List<NhanVat> nhanVatList) {
        this.context = context;
        this.nhanVatList = nhanVatList;
    }

    @NonNull
    @Override
    public NhanVatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nhan_vat, parent, false);
        return new NhanVatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVatViewHolder holder, int position) {
        NhanVat nhanVat = nhanVatList.get(position);

        holder.name.setText(nhanVat.getName());

        String iconUrl = "https://genshin.jmp.blue/characters/" + nhanVat.getId().toLowerCase() + "/icon";

        Glide.with(holder.itemView.getContext()).load(iconUrl).into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChiTietNhanVat.class);
            intent.putExtra("nhanVat", nhanVat);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return nhanVatList.size();
    }


    public static class NhanVatViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public NhanVatViewHolder(@NonNull View itemView) {
            super(itemView);
            // Liên kết các view trong item layout
            name = itemView.findViewById(R.id.nv_name);
            image = itemView.findViewById(R.id.nv_img);
        }
    }
}
