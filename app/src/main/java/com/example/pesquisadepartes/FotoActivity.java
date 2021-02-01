package com.example.pesquisadepartes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FotoActivity extends AppCompatActivity {

    Button btnFoto;
    Button btnGaleria;
    Bitmap imageBitmap;
    ImageView ivImagem;
    ImageView imageView;
    int fotoId;
    private final int GALERIA_IMAGENS = 1;
    private final int PERMISSAO_REQUEST = 2;
    private final int TIRAR_FOTO = 3;
    private final int CAMERA = 4;
    ArrayList<Bitmap> fotos;
    Bitmap fotoSelecionada;
    RecyclerView recyclerView;
    private Animator currentAnimator;
    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int shortAnimationDuration;
    PhotoViewAttacher photoViewAttacher;
    SpacesItemDecoration spacesItemDecoration;
    String JuntaCaminhoTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        btnFoto = (Button) findViewById(R.id.btnFoto);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnGaleria = (Button) findViewById(R.id.btnGaleria);
        fotos = new ArrayList<>();
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        fotoId = getIntent().getIntExtra("foto", 0);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
//        recyclerView.getRecycledViewPool().setMaxRecycledViews(GALERIA_IMAGENS, 3);
        spacesItemDecoration = new SpacesItemDecoration(3);
        recyclerView.addItemDecoration(spacesItemDecoration);
        recyclerView.setItemViewCacheSize(3);
        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
//        recyclerView.setHasFixedSize(true);

//        recyclerView.removeAllViews();
        carregarImagens();

//        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
//
////        Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
////        Bitmap thumbnail1 = (BitmapFactory.decodeFile(tarefa1.getCaminhoTarefa()));
////
////        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
////        Bitmap thumbnail2 = (BitmapFactory.decodeFile(tarefa2.getCaminhoTarefa()));
////
////        fotos.add(thumbnail1);
////        fotos.add(thumbnail2);
//
//        Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
//        Log.i("INFO", "tarefa1" + tarefa1.getCaminhoTarefa());
//        if (tarefa1.getCaminhoTarefa() != null) {
//            Bitmap thumbnail1 = (BitmapFactory.decodeFile(tarefa1.getCaminhoTarefa()));
//            fotos.add(thumbnail1);
//        }
//
//        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
//        Log.i("INFO", "tarefa2" + tarefa2.getCaminhoTarefa());
//        if (tarefa2.getCaminhoTarefa() != null) {
//            Bitmap thumbnail2 = (BitmapFactory.decodeFile(tarefa2.getCaminhoTarefa()));
//            fotos.add(thumbnail2);
//        }
//
////        GridView gridView = (GridView) findViewById (R.id.recycler);
//        FotosAdapter fotosAdapter = new FotosAdapter( this, fotos);
//        recyclerView.setAdapter(fotosAdapter);
////        RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(), GridLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layout);
//        recyclerView.setHasFixedSize(true);
//        final View thumb1View = findViewById(R.id.thumb_button_1);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
//                                zoomImageFromThumb(view.findViewById(R.id.thumb_button_1));
                                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
                                Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
                                Tarefa tarefa3 = tarefaDAO.listarCaminhoFoto3(fotoId);
                                Tarefa tarefa4 = tarefaDAO.listarCaminhoFoto4(fotoId);
                                Tarefa tarefa5 = tarefaDAO.listarCaminhoFoto5(fotoId);
                                Tarefa tarefa6 = tarefaDAO.listarCaminhoFoto6(fotoId);
                                Tarefa tarefa7 = tarefaDAO.listarCaminhoFoto7(fotoId);
                                Tarefa tarefa8 = tarefaDAO.listarCaminhoFoto8(fotoId);
                                Tarefa tarefa9 = tarefaDAO.listarCaminhoFoto9(fotoId);
                                Tarefa tarefa10 = tarefaDAO.listarCaminhoFoto10(fotoId);
                                Tarefa tarefa11 = tarefaDAO.listarCaminhoFoto11(fotoId);
                                Tarefa tarefa12 = tarefaDAO.listarCaminhoFoto12(fotoId);
                                Tarefa tarefa13 = tarefaDAO.listarCaminhoFoto13(fotoId);
                                Tarefa tarefa14 = tarefaDAO.listarCaminhoFoto14(fotoId);
                                Tarefa tarefa15 = tarefaDAO.listarCaminhoFoto15(fotoId);
                                Tarefa tarefa16 = tarefaDAO.listarCaminhoFoto16(fotoId);
                                Tarefa tarefa17 = tarefaDAO.listarCaminhoFoto17(fotoId);
                                Tarefa tarefa18 = tarefaDAO.listarCaminhoFoto18(fotoId);
                                Tarefa tarefa19 = tarefaDAO.listarCaminhoFoto19(fotoId);
                                Tarefa tarefa20 = tarefaDAO.listarCaminhoFoto20(fotoId);

                                if (position == 0) {
                                    transition(view, tarefa1.getCaminhoTarefa());
                                } else if(position == 1) {
                                    transition(view, tarefa2.getCaminhoTarefa());
                                } else if(position == 2) {
                                    transition(view, tarefa3.getCaminhoTarefa());
                                } else if(position == 3) {
                                    transition(view, tarefa4.getCaminhoTarefa());
                                } else if(position == 4) {
                                    transition(view, tarefa5.getCaminhoTarefa());
                                } else if(position == 5) {
                                    transition(view, tarefa6.getCaminhoTarefa());
                                } else if(position == 6) {
                                    transition(view, tarefa7.getCaminhoTarefa());
                                } else if(position == 7) {
                                    transition(view, tarefa8.getCaminhoTarefa());
                                } else if(position == 8) {
                                    transition(view, tarefa9.getCaminhoTarefa());
                                } else if(position == 9) {
                                    transition(view, tarefa10.getCaminhoTarefa());
                                } else if(position == 10) {
                                    transition(view, tarefa11.getCaminhoTarefa());
                                } else if(position == 11) {
                                    transition(view, tarefa12.getCaminhoTarefa());
                                } else if(position == 12) {
                                    transition(view, tarefa13.getCaminhoTarefa());
                                } else if(position == 13) {
                                    transition(view, tarefa14.getCaminhoTarefa());
                                } else if(position == 14) {
                                    transition(view, tarefa15.getCaminhoTarefa());
                                } else if(position == 15) {
                                    transition(view, tarefa16.getCaminhoTarefa());
                                } else if(position == 16) {
                                    transition(view, tarefa17.getCaminhoTarefa());
                                } else if(position == 17) {
                                    transition(view, tarefa18.getCaminhoTarefa());
                                } else if(position == 18) {
                                    transition(view, tarefa19.getCaminhoTarefa());
                                } else if(position == 19) {
                                    transition(view, tarefa20.getCaminhoTarefa());
                                }

//                                //Recuperar tarefa para edicao
//                                Tarefa tarefaSelecionada = listaTarefas.get( position );
//
//                                //Envia tarefa para tela adicionar tarefa
//                                Intent intent = new Intent(FotoActivity.this, PanActivity.class);
//                                intent.putExtra("tarefaSelecionada", tarefaSelecionada );

//                                startActivity( intent );

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //Recupera tarefa para deletar
//                                fotoSelecionada = fotos.get( position );

                                AlertDialog.Builder dialog = new AlertDialog.Builder(FotoActivity.this);

                                //Configura título e mensagem
                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir a foto " + (position + 1) + "?" );

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                                        if (position == 0) {
                                            Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
                                            if (!tarefa1.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto1(fotoId, "");

                                                atualizaCaminhoFoto1_excluiCaminhoFoto2(tarefaDAO);
                                                atualizaCaminhoFoto2_excluiCaminhoFoto3(tarefaDAO);
                                                atualizaCaminhoFoto3_excluiCaminhoFoto4(tarefaDAO);
                                                atualizaCaminhoFoto4_excluiCaminhoFoto5(tarefaDAO);
                                                atualizaCaminhoFoto5_excluiCaminhoFoto6(tarefaDAO);
                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto1!",
                                                    Toast.LENGTH_SHORT).show();

                                        } else if (position == 1) {
                                            Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
                                            if (!tarefa2.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto2(fotoId, "");

                                                atualizaCaminhoFoto2_excluiCaminhoFoto3(tarefaDAO);
                                                atualizaCaminhoFoto3_excluiCaminhoFoto4(tarefaDAO);
                                                atualizaCaminhoFoto4_excluiCaminhoFoto5(tarefaDAO);
                                                atualizaCaminhoFoto5_excluiCaminhoFoto6(tarefaDAO);
                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto2!",
                                                    Toast.LENGTH_SHORT).show();

                                        } else if (position == 2) {
                                            Tarefa tarefa3 = tarefaDAO.listarCaminhoFoto3(fotoId);
                                            if (!tarefa3.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto3(fotoId, "");

                                                atualizaCaminhoFoto3_excluiCaminhoFoto4(tarefaDAO);
                                                atualizaCaminhoFoto4_excluiCaminhoFoto5(tarefaDAO);
                                                atualizaCaminhoFoto5_excluiCaminhoFoto6(tarefaDAO);
                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 3) {
                                            Tarefa tarefa4 = tarefaDAO.listarCaminhoFoto4(fotoId);
                                            if (!tarefa4.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto4(fotoId, "");

                                                atualizaCaminhoFoto4_excluiCaminhoFoto5(tarefaDAO);
                                                atualizaCaminhoFoto5_excluiCaminhoFoto6(tarefaDAO);
                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 4) {
                                            Tarefa tarefa5 = tarefaDAO.listarCaminhoFoto5(fotoId);
                                            if (!tarefa5.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto5(fotoId, "");

                                                atualizaCaminhoFoto5_excluiCaminhoFoto6(tarefaDAO);
                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 5) {
                                            Tarefa tarefa6 = tarefaDAO.listarCaminhoFoto6(fotoId);
                                            if (!tarefa6.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto6(fotoId, "");

                                                atualizaCaminhoFoto6_excluiCaminhoFoto7(tarefaDAO);
                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 6) {
                                            Tarefa tarefa7 = tarefaDAO.listarCaminhoFoto7(fotoId);
                                            if (!tarefa7.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto7(fotoId, "");

                                                atualizaCaminhoFoto7_excluiCaminhoFoto8(tarefaDAO);
                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 7) {
                                            Tarefa tarefa8 = tarefaDAO.listarCaminhoFoto8(fotoId);
                                            if (!tarefa8.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto8(fotoId, "");

                                                atualizaCaminhoFoto8_excluiCaminhoFoto9(tarefaDAO);
                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 8) {
                                            Tarefa tarefa9 = tarefaDAO.listarCaminhoFoto9(fotoId);
                                            if (!tarefa9.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto9(fotoId, "");

                                                atualizaCaminhoFoto9_excluiCaminhoFoto10(tarefaDAO);
                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 9) {
                                            Tarefa tarefa10 = tarefaDAO.listarCaminhoFoto10(fotoId);
                                            if (!tarefa10.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto10(fotoId, "");

                                                atualizaCaminhoFoto10_excluiCaminhoFoto11(tarefaDAO);
                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 10) {
                                            Tarefa tarefa11 = tarefaDAO.listarCaminhoFoto11(fotoId);
                                            if (!tarefa11.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto11(fotoId, "");

                                                atualizaCaminhoFoto11_excluiCaminhoFoto12(tarefaDAO);
                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 11) {
                                            Tarefa tarefa12 = tarefaDAO.listarCaminhoFoto12(fotoId);
                                            if (!tarefa12.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto12(fotoId, "");

                                                atualizaCaminhoFoto12_excluiCaminhoFoto13(tarefaDAO);
                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 12) {
                                            Tarefa tarefa13 = tarefaDAO.listarCaminhoFoto13(fotoId);
                                            if (!tarefa13.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto13(fotoId, "");

                                                atualizaCaminhoFoto13_excluiCaminhoFoto14(tarefaDAO);
                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 13) {
                                            Tarefa tarefa14 = tarefaDAO.listarCaminhoFoto14(fotoId);
                                            if (!tarefa14.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto14(fotoId, "");

                                                atualizaCaminhoFoto14_excluiCaminhoFoto15(tarefaDAO);
                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 14) {
                                            Tarefa tarefa15 = tarefaDAO.listarCaminhoFoto15(fotoId);
                                            if (!tarefa15.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto15(fotoId, "");

                                                atualizaCaminhoFoto15_excluiCaminhoFoto16(tarefaDAO);
                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 15) {
                                            Tarefa tarefa16 = tarefaDAO.listarCaminhoFoto16(fotoId);
                                            if (!tarefa16.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto16(fotoId, "");

                                                atualizaCaminhoFoto16_excluiCaminhoFoto17(tarefaDAO);
                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 16) {
                                            Tarefa tarefa17 = tarefaDAO.listarCaminhoFoto17(fotoId);
                                            if (!tarefa17.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto17(fotoId, "");

                                                atualizaCaminhoFoto17_excluiCaminhoFoto18(tarefaDAO);
                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 17) {
                                            Tarefa tarefa18 = tarefaDAO.listarCaminhoFoto18(fotoId);
                                            if (!tarefa18.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto18(fotoId, "");

                                                atualizaCaminhoFoto18_excluiCaminhoFoto19(tarefaDAO);
                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 18) {
                                            Tarefa tarefa19 = tarefaDAO.listarCaminhoFoto19(fotoId);
                                            if (!tarefa19.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto19(fotoId, "");

                                                atualizaCaminhoFoto19_excluiCaminhoFoto20(tarefaDAO);
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (position == 19) {
                                            Tarefa tarefa20 = tarefaDAO.listarCaminhoFoto20(fotoId);
                                            if (!tarefa20.getCaminhoTarefa().equals("")) {
                                                tarefaDAO.atualizarCaminhoFoto20(fotoId, "");
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Sucesso ao excluir foto3!",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(),
                                                    "Erro ao excluir tarefa!",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                        carregarImagens();

                                    }
                                });

                                dialog.setNegativeButton("Não", null );

                                //Exibir dialog
                                dialog.create();
                                dialog.show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

//        List<Tarefa> tarefas;
//        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
//        tarefas = tarefaDAO.listarFoto(fotoId);
//
//        if (tarefas.get(0).getFotoTarefa() != null) {
//            byte[] outImage = tarefas.get(0).getFotoTarefa();
//            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
//            Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
//            ivImagem.setImageBitmap(imageBitmap);
//        }

//        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
//
//        Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
//        Bitmap thumbnail1 = (BitmapFactory.decodeFile(tarefa1.getCaminhoTarefa()));
//
//        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
//        Bitmap thumbnail2 = (BitmapFactory.decodeFile(tarefa2.getCaminhoTarefa()));
//
//        fotos.add(thumbnail1);
//        fotos.add(thumbnail2);
//
////        GridView gridView = (GridView) findViewById (R.id.recycler);
//        FotosAdapter fotosAdapter = new FotosAdapter( this, fotos);
//        recyclerView.setAdapter(fotosAdapter);
//        RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(), GridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layout);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

//        fotos.clear();

//        ivImagem.setImageBitmap(thumbnail);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALERIA_IMAGENS);
            }
        });

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    try {
                        arquivoFoto = criarArquivo();
                    } catch (IOException ex) {
                        // Manipulação em caso de falha de criação do arquivo
                    }
                    if (arquivoFoto != null) {
                        Uri photoURI = FileProvider.getUriForFile(getBaseContext(),
                                getBaseContext().getApplicationContext().getPackageName() +
                                        ".provider", arquivoFoto);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(takePictureIntent, CAMERA);
//                    startActivityForResult(takePictureIntent, TIRAR_FOTO);
                    }
                }
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                byte imagemBytes[] = stream.toByteArray();
//
////                startPostponedEnterTransition();
//                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
//                tarefaDAO.atualizar(fotoId, imagemBytes);
            }
        });
    }

    private File arquivoFoto = null;

    private File criarArquivo() throws IOException {
        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File pasta = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File imagem = new File(pasta.getPath() + File.separator
                + "JPG_" + timeStamp + ".jpg");
        return imagem;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
//            ivImagem.setImageBitmap(thumbnail);
            Bitmap b = getResizedBitmap(thumbnail, thumbnail.getWidth()/3,thumbnail.getHeight()/4);

            fotos.add(b);

            RecyclerView recyclerView = (RecyclerView) findViewById (R.id.recycler);
            FotosAdapter fotosAdapter = new FotosAdapter( this, fotos);
            recyclerView.setAdapter(fotosAdapter);
            RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(), 3);
//            RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layout);
            recyclerView.setItemViewCacheSize(3);
            recyclerView.setDrawingCacheEnabled(true);

//            recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));


//            fotos.clear();

//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            byte imagemBytes[] = stream.toByteArray();
            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

            Log.i("INFO", "carregando");


            Tarefa tarefaCaminhoFoto1 = tarefaDAO.listarCaminhoFoto1(fotoId);
            Tarefa tarefaCaminhoFoto2 = tarefaDAO.listarCaminhoFoto2(fotoId);
            Tarefa tarefaCaminhoFoto3 = tarefaDAO.listarCaminhoFoto3(fotoId);
            Tarefa tarefaCaminhoFoto4 = tarefaDAO.listarCaminhoFoto4(fotoId);
            Tarefa tarefaCaminhoFoto5 = tarefaDAO.listarCaminhoFoto5(fotoId);
            Tarefa tarefaCaminhoFoto6 = tarefaDAO.listarCaminhoFoto6(fotoId);
            Tarefa tarefaCaminhoFoto7 = tarefaDAO.listarCaminhoFoto7(fotoId);
            Tarefa tarefaCaminhoFoto8 = tarefaDAO.listarCaminhoFoto8(fotoId);
            Tarefa tarefaCaminhoFoto9 = tarefaDAO.listarCaminhoFoto9(fotoId);
            Tarefa tarefaCaminhoFoto10 = tarefaDAO.listarCaminhoFoto10(fotoId);
            Tarefa tarefaCaminhoFoto11 = tarefaDAO.listarCaminhoFoto11(fotoId);
            Tarefa tarefaCaminhoFoto12 = tarefaDAO.listarCaminhoFoto12(fotoId);
            Tarefa tarefaCaminhoFoto13 = tarefaDAO.listarCaminhoFoto13(fotoId);
            Tarefa tarefaCaminhoFoto14 = tarefaDAO.listarCaminhoFoto14(fotoId);
            Tarefa tarefaCaminhoFoto15 = tarefaDAO.listarCaminhoFoto15(fotoId);
            Tarefa tarefaCaminhoFoto16 = tarefaDAO.listarCaminhoFoto16(fotoId);
            Tarefa tarefaCaminhoFoto17 = tarefaDAO.listarCaminhoFoto17(fotoId);
            Tarefa tarefaCaminhoFoto18 = tarefaDAO.listarCaminhoFoto18(fotoId);
            Tarefa tarefaCaminhoFoto19 = tarefaDAO.listarCaminhoFoto19(fotoId);
            Tarefa tarefaCaminhoFoto20 = tarefaDAO.listarCaminhoFoto20(fotoId);

            Log.i("INFO", "caminho "+tarefaCaminhoFoto1.getCaminhoTarefa());

            if (tarefaCaminhoFoto1.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto1(fotoId, picturePath);
            } else if (tarefaCaminhoFoto2.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto2(fotoId, picturePath);
            } else if (tarefaCaminhoFoto3.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto3(fotoId, picturePath);
            } else if (tarefaCaminhoFoto4.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto4(fotoId, picturePath);
            } else if (tarefaCaminhoFoto5.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto5(fotoId, picturePath);
            } else if (tarefaCaminhoFoto6.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto6(fotoId, picturePath);
            } else if (tarefaCaminhoFoto7.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto7(fotoId, picturePath);
            } else if (tarefaCaminhoFoto8.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto8(fotoId, picturePath);
            } else if (tarefaCaminhoFoto9.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto9(fotoId, picturePath);
            } else if (tarefaCaminhoFoto10.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto10(fotoId, picturePath);
            } else if (tarefaCaminhoFoto11.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto11(fotoId, picturePath);
            } else if (tarefaCaminhoFoto12.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto12(fotoId, picturePath);
            } else if (tarefaCaminhoFoto13.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto13(fotoId, picturePath);
            } else if (tarefaCaminhoFoto14.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto14(fotoId, picturePath);
            } else if (tarefaCaminhoFoto15.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto15(fotoId, picturePath);
            } else if (tarefaCaminhoFoto16.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto16(fotoId, picturePath);
            } else if (tarefaCaminhoFoto17.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto17(fotoId, picturePath);
            } else if (tarefaCaminhoFoto18.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto18(fotoId, picturePath);
            } else if (tarefaCaminhoFoto19.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto19(fotoId, picturePath);
            } else if (tarefaCaminhoFoto20.getCaminhoTarefa().equals("")) {
                tarefaDAO.atualizarCaminhoFoto20(fotoId, picturePath);
            }

        }
//        if (resultCode == RESULT_OK && requestCode == TIRAR_FOTO) {
//
//            Bundle extras = data.getExtras();
//            imageBitmap = (Bitmap) extras.get("data");
////            ivImagem.setImageBitmap(imageBitmap);
//
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            byte imagemBytes[] = stream.toByteArray();
//
////                startPostponedEnterTransition();
//            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
//            tarefaDAO.atualizarFoto(fotoId, imagemBytes);
//        }
        if (resultCode == RESULT_OK && requestCode == CAMERA) {
            sendBroadcast(new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.fromFile(arquivoFoto))
            );
            exibirImagem();
        }
    }

    private void exibirImagem() {
//        int targetW = imageView.getWidth();
//        int targetH = imageView.getHeight();
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        bmOptions.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(arquivoFoto.getAbsolutePath(), bmOptions);
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scaleFactor;


        Bitmap bitmap = BitmapFactory.decodeFile(arquivoFoto.getAbsolutePath());
//        RotateBitmap(bitmap, 90);
//        Matrix matrix = new Matrix();
//        matrix.postRotate(270);
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 1024, 720 , true);
//        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
//        imageView.setImageBitmap(rotatedBitmap);
//        Bitmap bitmap = getResizedBitmap(bitmap2, 1024, 768);
//        Matrix mMatrix = new Matrix();
//        Matrix mat = imageView.getImageMatrix();
//        mMatrix.set(mat);
//        mMatrix.setRotate(90);
//        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
//                bitmap.getHeight(), mMatrix, false);


//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte imagemBytes[] = stream.toByteArray();

        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

        Tarefa tarefaCaminhoFoto1 = tarefaDAO.listarCaminhoFoto1(fotoId);
        Tarefa tarefaCaminhoFoto2 = tarefaDAO.listarCaminhoFoto2(fotoId);
        Tarefa tarefaCaminhoFoto3 = tarefaDAO.listarCaminhoFoto3(fotoId);
        Tarefa tarefaCaminhoFoto4 = tarefaDAO.listarCaminhoFoto4(fotoId);
        Tarefa tarefaCaminhoFoto5 = tarefaDAO.listarCaminhoFoto5(fotoId);
        Tarefa tarefaCaminhoFoto6 = tarefaDAO.listarCaminhoFoto6(fotoId);
        Tarefa tarefaCaminhoFoto7 = tarefaDAO.listarCaminhoFoto7(fotoId);
        Tarefa tarefaCaminhoFoto8 = tarefaDAO.listarCaminhoFoto8(fotoId);
        Tarefa tarefaCaminhoFoto9 = tarefaDAO.listarCaminhoFoto9(fotoId);
        Tarefa tarefaCaminhoFoto10 = tarefaDAO.listarCaminhoFoto10(fotoId);
        Tarefa tarefaCaminhoFoto11 = tarefaDAO.listarCaminhoFoto11(fotoId);
        Tarefa tarefaCaminhoFoto12 = tarefaDAO.listarCaminhoFoto12(fotoId);
        Tarefa tarefaCaminhoFoto13 = tarefaDAO.listarCaminhoFoto13(fotoId);
        Tarefa tarefaCaminhoFoto14 = tarefaDAO.listarCaminhoFoto14(fotoId);
        Tarefa tarefaCaminhoFoto15 = tarefaDAO.listarCaminhoFoto15(fotoId);
        Tarefa tarefaCaminhoFoto16 = tarefaDAO.listarCaminhoFoto16(fotoId);
        Tarefa tarefaCaminhoFoto17 = tarefaDAO.listarCaminhoFoto17(fotoId);
        Tarefa tarefaCaminhoFoto18 = tarefaDAO.listarCaminhoFoto18(fotoId);
        Tarefa tarefaCaminhoFoto19 = tarefaDAO.listarCaminhoFoto19(fotoId);
        Tarefa tarefaCaminhoFoto20 = tarefaDAO.listarCaminhoFoto20(fotoId);

        Log.i("INFO", "caminho "+tarefaCaminhoFoto1.getCaminhoTarefa());

        if (tarefaCaminhoFoto1.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto1(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto2.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto2(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto3.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto3(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto4.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto4(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto5.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto5(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto6.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto6(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto7.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto7(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto8.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto8(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto9.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto9(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto10.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto10(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto11.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto11(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto12.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto12(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto13.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto13(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto14.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto14(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto15.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto15(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto16.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto16(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto17.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto17(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto18.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto18(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto19.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto19(fotoId, arquivoFoto.getAbsolutePath());
        } else if (tarefaCaminhoFoto20.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto20(fotoId, arquivoFoto.getAbsolutePath());
        }

        Bitmap b = getResizedBitmap(bitmap, bitmap.getWidth()/3,bitmap.getHeight()/4);

        fotos.add(b);

        RecyclerView recyclerView = (RecyclerView) findViewById (R.id.recycler);
        FotosAdapter fotosAdapter = new FotosAdapter( this, fotos);
        recyclerView.setAdapter(fotosAdapter);
        RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(), 3);
//        RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setItemViewCacheSize(3);
        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // A permissão foi concedida. Pode continuar
            } else {
                // A permissão foi negada. Precisa ver o que deve ser desabilitado
            }
            return;
        }
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

    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public void carregarImagens() {
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

//        Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
//        Bitmap thumbnail1 = (BitmapFactory.decodeFile(tarefa1.getCaminhoTarefa()));
//
//        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
//        Bitmap thumbnail2 = (BitmapFactory.decodeFile(tarefa2.getCaminhoTarefa()));
//
//        fotos.add(thumbnail1);
//        fotos.add(thumbnail2);

//        Log.i("INFO", "carregando");
//        recyclerView.removeAllViews();
        fotos.clear();

        Tarefa tarefa1 = tarefaDAO.listarCaminhoFoto1(fotoId);
        Log.i("INFO", "tarefa1" + tarefa1.getCaminhoTarefa());
        if (!tarefa1.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail1 = (BitmapFactory.decodeFile(tarefa1.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto1(fotoId, tarefa1.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail1, thumbnail1.getWidth()/3,thumbnail1.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
        Log.i("INFO", "tarefa2" + tarefa2.getCaminhoTarefa());
        if (!tarefa2.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail2 = (BitmapFactory.decodeFile(tarefa2.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail2, thumbnail2.getWidth()/3,thumbnail2.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa3 = tarefaDAO.listarCaminhoFoto3(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa3.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail3 = (BitmapFactory.decodeFile(tarefa3.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail3, thumbnail3.getWidth()/3,thumbnail3.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa4 = tarefaDAO.listarCaminhoFoto4(fotoId);
        Log.i("INFO", "tarefa3" + tarefa4.getCaminhoTarefa());
        if (!tarefa4.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail4 = (BitmapFactory.decodeFile(tarefa4.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail4, thumbnail4.getWidth()/3,thumbnail4.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa5 = tarefaDAO.listarCaminhoFoto5(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa5.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail5 = (BitmapFactory.decodeFile(tarefa5.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail5, thumbnail5.getWidth()/3,thumbnail5.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa6 = tarefaDAO.listarCaminhoFoto6(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa6.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail6 = (BitmapFactory.decodeFile(tarefa6.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail6, thumbnail6.getWidth()/3,thumbnail6.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa7 = tarefaDAO.listarCaminhoFoto7(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa7.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail7 = (BitmapFactory.decodeFile(tarefa7.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail7, thumbnail7.getWidth()/3,thumbnail7.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa8 = tarefaDAO.listarCaminhoFoto8(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa8.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail8 = (BitmapFactory.decodeFile(tarefa8.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail8, thumbnail8.getWidth()/3,thumbnail8.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa9 = tarefaDAO.listarCaminhoFoto9(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa9.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail9 = (BitmapFactory.decodeFile(tarefa9.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail9, thumbnail9.getWidth()/3,thumbnail9.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa10 = tarefaDAO.listarCaminhoFoto10(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa10.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail10 = (BitmapFactory.decodeFile(tarefa10.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail10, thumbnail10.getWidth()/3,thumbnail10.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa11 = tarefaDAO.listarCaminhoFoto11(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa11.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail11 = (BitmapFactory.decodeFile(tarefa11.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail11, thumbnail11.getWidth()/3,thumbnail11.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa12 = tarefaDAO.listarCaminhoFoto12(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa12.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail12 = (BitmapFactory.decodeFile(tarefa12.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail12, thumbnail12.getWidth()/3,thumbnail12.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa13 = tarefaDAO.listarCaminhoFoto13(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa13.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail13 = (BitmapFactory.decodeFile(tarefa13.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail13, thumbnail13.getWidth()/3,thumbnail13.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa14 = tarefaDAO.listarCaminhoFoto14(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa14.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail14 = (BitmapFactory.decodeFile(tarefa14.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail14, thumbnail14.getWidth()/3,thumbnail14.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa15 = tarefaDAO.listarCaminhoFoto15(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa15.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail15 = (BitmapFactory.decodeFile(tarefa15.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail15, thumbnail15.getWidth()/3,thumbnail15.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa16 = tarefaDAO.listarCaminhoFoto16(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa16.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail16 = (BitmapFactory.decodeFile(tarefa16.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail16, thumbnail16.getWidth()/3,thumbnail16.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa17 = tarefaDAO.listarCaminhoFoto17(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa17.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail17 = (BitmapFactory.decodeFile(tarefa17.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail17, thumbnail17.getWidth()/3,thumbnail17.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa18 = tarefaDAO.listarCaminhoFoto18(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa18.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail18 = (BitmapFactory.decodeFile(tarefa18.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail18, thumbnail18.getWidth()/3,thumbnail18.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa19= tarefaDAO.listarCaminhoFoto19(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa19.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail19 = (BitmapFactory.decodeFile(tarefa19.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail19, thumbnail19.getWidth()/3,thumbnail19.getHeight()/4);
            fotos.add(b);
        }

        Tarefa tarefa20 = tarefaDAO.listarCaminhoFoto20(fotoId);
        Log.i("INFO", "tarefa3" + tarefa3.getCaminhoTarefa());
        if (!tarefa20.getCaminhoTarefa().equals("")) {
            Bitmap thumbnail20 = (BitmapFactory.decodeFile(tarefa20.getCaminhoTarefa()));
//            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa2.getCaminhoTarefa());
            Bitmap b = getResizedBitmap(thumbnail20, thumbnail20.getWidth()/3,thumbnail20.getHeight()/4);
            fotos.add(b);
        }

//        GridView gridView = (GridView) findViewById (R.id.recycler);
        FotosAdapter fotosAdapter = new FotosAdapter( this, fotos);
        recyclerView.setAdapter(fotosAdapter);
//        fotosAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layout = new GridLayoutManager(getApplicationContext(), 3);
//        RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemViewCacheSize(12);
    }

    private void transition(View view, String caminho) {
        if (Build.VERSION.SDK_INT < 21) {
            Toast.makeText(FotoActivity.this, "21+ only, keep out", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(FotoActivity.this, ActivityTransitionToActivity.class);
            intent.putExtra("foto", caminho);

            LinearLayout l = (LinearLayout) view;
            ImageView i = (ImageView) l.getChildAt(0);
            i.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            i.setRotation(0);

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(FotoActivity.this, i, getString(R.string.transition_test));

            startActivity(intent, options.toBundle());
        }
    }

    public void atualizaCaminhoFoto1_excluiCaminhoFoto2(TarefaDAO tarefaDAO) {
        Tarefa tarefa2 = tarefaDAO.listarCaminhoFoto2(fotoId);
        if (!tarefa2.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto1(fotoId, tarefa2.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto2(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto2_excluiCaminhoFoto3(TarefaDAO tarefaDAO) {
        Tarefa tarefa3 = tarefaDAO.listarCaminhoFoto3(fotoId);
        if (!tarefa3.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto2(fotoId, tarefa3.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto3(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto3_excluiCaminhoFoto4(TarefaDAO tarefaDAO) {
        Tarefa tarefa4 = tarefaDAO.listarCaminhoFoto4(fotoId);
        if (!tarefa4.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto3(fotoId, tarefa4.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto4(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto4_excluiCaminhoFoto5(TarefaDAO tarefaDAO) {
        Tarefa tarefa5 = tarefaDAO.listarCaminhoFoto5(fotoId);
        if (!tarefa5.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto4(fotoId, tarefa5.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto5(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto5_excluiCaminhoFoto6(TarefaDAO tarefaDAO) {
        Tarefa tarefa6 = tarefaDAO.listarCaminhoFoto6(fotoId);
        if (!tarefa6.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto5(fotoId, tarefa6.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto6(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto6_excluiCaminhoFoto7(TarefaDAO tarefaDAO) {
        Tarefa tarefa7 = tarefaDAO.listarCaminhoFoto7(fotoId);
        if (!tarefa7.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto6(fotoId, tarefa7.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto7(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto7_excluiCaminhoFoto8(TarefaDAO tarefaDAO) {
        Tarefa tarefa8 = tarefaDAO.listarCaminhoFoto8(fotoId);
        if (!tarefa8.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto7(fotoId, tarefa8.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto8(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto8_excluiCaminhoFoto9(TarefaDAO tarefaDAO) {
        Tarefa tarefa9 = tarefaDAO.listarCaminhoFoto9(fotoId);
        if (!tarefa9.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto8(fotoId, tarefa9.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto9(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto9_excluiCaminhoFoto10(TarefaDAO tarefaDAO) {
        Tarefa tarefa10 = tarefaDAO.listarCaminhoFoto10(fotoId);
        if (!tarefa10.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto9(fotoId, tarefa10.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto10(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto10_excluiCaminhoFoto11(TarefaDAO tarefaDAO) {
        Tarefa tarefa11 = tarefaDAO.listarCaminhoFoto11(fotoId);
        if (!tarefa11.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto10(fotoId, tarefa11.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto11(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto11_excluiCaminhoFoto12(TarefaDAO tarefaDAO) {
        Tarefa tarefa12 = tarefaDAO.listarCaminhoFoto12(fotoId);
        if (!tarefa12.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto11(fotoId, tarefa12.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto12(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto12_excluiCaminhoFoto13(TarefaDAO tarefaDAO) {
        Tarefa tarefa13 = tarefaDAO.listarCaminhoFoto13(fotoId);
        if (!tarefa13.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto12(fotoId, tarefa13.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto13(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto13_excluiCaminhoFoto14(TarefaDAO tarefaDAO) {
        Tarefa tarefa14 = tarefaDAO.listarCaminhoFoto14(fotoId);
        if (!tarefa14.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto13(fotoId, tarefa14.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto14(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto14_excluiCaminhoFoto15(TarefaDAO tarefaDAO) {
        Tarefa tarefa15 = tarefaDAO.listarCaminhoFoto15(fotoId);
        if (!tarefa15.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto14(fotoId, tarefa15.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto15(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto15_excluiCaminhoFoto16(TarefaDAO tarefaDAO) {
        Tarefa tarefa16 = tarefaDAO.listarCaminhoFoto16(fotoId);
        if (!tarefa16.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto15(fotoId, tarefa16.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto16(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto16_excluiCaminhoFoto17(TarefaDAO tarefaDAO) {
        Tarefa tarefa17 = tarefaDAO.listarCaminhoFoto17(fotoId);
        if (!tarefa17.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto16(fotoId, tarefa17.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto17(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto17_excluiCaminhoFoto18(TarefaDAO tarefaDAO) {
        Tarefa tarefa18 = tarefaDAO.listarCaminhoFoto18(fotoId);
        if (!tarefa18.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto17(fotoId, tarefa18.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto18(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto18_excluiCaminhoFoto19(TarefaDAO tarefaDAO) {
        Tarefa tarefa19 = tarefaDAO.listarCaminhoFoto19(fotoId);
        if (!tarefa19.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto18(fotoId, tarefa19.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto19(fotoId, "");
        }
    }
    public void atualizaCaminhoFoto19_excluiCaminhoFoto20(TarefaDAO tarefaDAO) {
        Tarefa tarefa20 = tarefaDAO.listarCaminhoFoto20(fotoId);
        if (!tarefa20.getCaminhoTarefa().equals("")) {
            tarefaDAO.atualizarCaminhoFoto19(fotoId, tarefa20.getCaminhoTarefa());
            tarefaDAO.atualizarCaminhoFoto20(fotoId, "");
        }
    }
}