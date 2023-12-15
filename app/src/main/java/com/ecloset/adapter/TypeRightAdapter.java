package com.ecloset.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecloset.Bean.clothes;
import com.ecloset.R;

import java.io.File;
import java.util.List;

public class TypeRightAdapter extends RecyclerView.Adapter<TypeRightAdapter.ClothesViewHolder> {
    private Context mContext;
    private List<clothes> list_clothes;
    private LayoutInflater inflater;


    public TypeRightAdapter(Context context, List<clothes> listClothes) {
        this.mContext = context;
        this.list_clothes = listClothes;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_ordinary_right, parent, false);
        return new ClothesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder holder, int position) {
        clothes item = list_clothes.get(position);
        Bitmap bitmap = BitmapFactory.decodeFile(item.getImg_clothes());
        holder.ivClothesImage.setImageBitmap(bitmap);
        holder.tvClothesName.setText(item.getName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list_clothes.size();
    }

    class ClothesViewHolder extends RecyclerView.ViewHolder {
        ImageView ivClothesImage;
        TextView tvClothesName;

        public ClothesViewHolder(View itemView) {
            super(itemView);
            ivClothesImage = itemView.findViewById(R.id.iv_clothes);
            tvClothesName = itemView.findViewById(R.id.tv_clothes);

        }
    }
}
