package com.example.pesquisadepartes;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class MeuViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public MeuViewHolder(View view) {
        super(view);
        imageView = (ImageView) view.findViewById(R.id.imageView );
    }
}
