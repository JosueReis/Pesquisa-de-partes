package com.example.pesquisadepartes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.IOException;

import static com.example.pesquisadepartes.RotacionaImagem.handleSamplingAndRotationBitmap;

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
        File file = (File) getIntent().getSerializableExtra("file");

        Bitmap b = (BitmapFactory.decodeFile(foto));
//        Bitmap thumbnail1 = rotateImage(b, 90);

//        largura = thumbnail1.getWidth();
//        altura = thumbnail1.getHeight();
//
//        try {
//            thumbnail1 = RotacionaImagem.handleSamplingAndRotationBitmap(getApplicationContext(), Uri.fromFile(file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Uri arquivo = getUriFromPath(getApplicationContext(), foto);

        try {
            b = handleSamplingAndRotationBitmap(getApplicationContext(), arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Drawable d = new BitmapDrawable(getResources(), b);
        PhotoView photoView = (PhotoView) findViewById(R.id.iv_photo);
        photoView.setImageDrawable(d);
    }

    public Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }

    public Uri getUriFromPath(Context context, String destination) {
        File file =  new File(destination);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
        } else {
            return Uri.fromFile(file);
        }
    }
}
