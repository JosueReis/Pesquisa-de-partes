package com.example.pesquisadepartes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//import android.graphics.Bitmap;

public class FotosAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final ArrayList<Bitmap> fotos;

    public FotosAdapter(Context context, ArrayList<Bitmap> fotos) {
        this.mContext = context;
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


//        imageView = (ImageView) view.findViewById(R.id.imageView);
//        imageView.setImageBitmap(fotos.get(position));
//        imageView.setImageResource(mThumbIds[position]);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
//        nameTextView.setText(mContext.getString(book.getName()));
//        authorTextView.setText(mContext.getString(book.getAuthor()));
//        notifyDataSetChanged();

        View view = LayoutInflater.from(mContext).inflate(R.layout.linear_layout_fotos, parent, false);
        MeuViewHolder holder = new MeuViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MeuViewHolder h = (MeuViewHolder) holder;
        Bitmap foto = fotos.get(position) ;
        Log.i("position ", ""  + position);
//        Matrix matrix = new Matrix();
//        matrix.postRotate(90);
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(foto, 1024, 720 , true);
//        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
//        imageView.setImageBitmap(rotatedBitmap);
//        getResizedBitmap(foto, 1280, 720);
        h.imageView.setImageBitmap(foto);
//        notifyItemRemoved(position);
//        notifyItemChanged(position);
//        notifyItemInserted(position);
//        notifyItemRangeInserted(start, end);
    }

//    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
//        int width = bm.getWidth();
//        int height = bm.getHeight();
//        float scaleWidth = ((float) newWidth) / width;
//        float scaleHeight = ((float) newHeight) / height;
//        // CREATE A MATRIX FOR THE MANIPULATION
//        Matrix matrix = new Matrix();
//        // RESIZE THE BIT MAP
//        matrix.postScale(scaleWidth, scaleHeight);
//        // "RECREATE" THE NEW BITMAP
//        Bitmap resizedBitmap = Bitmap.createBitmap(
//                bm, 0, 0, width, height, matrix, false);
//        bm.recycle();
//        return resizedBitmap;
//    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }


}
