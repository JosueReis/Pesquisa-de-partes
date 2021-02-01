package com.example.pesquisadepartes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * Activity that gets transitioned to
 */
public class ActivityTransitionToActivity extends AppCompatActivity {
    Bitmap b;
    int largura;
    int altura;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_to);

        String foto = getIntent().getStringExtra("foto");

        Bitmap thumbnail1 = (BitmapFactory.decodeFile(foto));

        largura = thumbnail1.getWidth();
        altura = thumbnail1.getHeight();

        if (largura > 1920 || altura > 1080) {
            if (largura > 1920) {
                largura = 1920;
            }

            if (altura > 1080) {
                altura = 1080;
            }
            thumbnail1 = getResizedBitmap(thumbnail1, largura, altura);
        }

        Drawable d = new BitmapDrawable(getResources(), thumbnail1);
        PhotoView photoView = (PhotoView) findViewById(R.id.iv_photo);
        photoView.setImageDrawable(d);
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }
}
