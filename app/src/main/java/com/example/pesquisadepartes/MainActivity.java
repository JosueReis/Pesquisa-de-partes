package com.example.pesquisadepartes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button criar;
    Button excluirTudo;
    Tarefa tarefa;
    TarefaDAO tarefaDAO;
    Button dados;
    Button foto;
    Button mapa;
    Button exclui;
    Button limparNome;
    LinearLayout linearHorizontalFilho1;
    LinearLayout linearHorizontalFilho2;
    LinearLayout linearVerticalPai;
    LinearLayout linearVerticalFilho3;
    LinearLayout layoutMestre;
    List<Tarefa> tarefas;
    List<Tarefa> tarefasPesquisa;
    String getLocation;
    TextView textView;
    TextView labelNome;
    TextView horario;
    TextView textViewNome;
    ArrayList pesquisaNome;
    ScrollView scrollView;
    EditText pesquisa;
    int a = 0;
    String b;
    ArrayList nomeDoPesquisado;
    private AutoCompleteTextView autoComplete;
    private ArrayAdapter<String> adapter;
    Set nomeDoPesquisadoHashSet;
    int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criar = findViewById(R.id.criar);
//        textViewNome = findViewById(R.id.pesquisa);
        excluirTudo = findViewById(R.id.excluirTudo);
        tarefaDAO = new TarefaDAO(getApplicationContext());
        autoComplete = findViewById(R.id.autoComplete);
        pesquisaNome = new ArrayList();
        scrollView = findViewById(R.id.scrollView);
        nomeDoPesquisado = new ArrayList();
        limparNome = findViewById(R.id.limparNome);
        nomeDoPesquisadoHashSet = new HashSet();

//        nomeDoPesquisado = new ArrayList(nomeDoPesquisadoHashSet);
//        pesquisa = findViewById(R.id.pesquisa);
//        l = new LinearLayout(getApplicationContext());
//        foto = new Button(getApplicationContext());
//        mapa = new Button(getApplicationContext());
        layoutMestre = findViewById(R.id.layoutMestre);
//        getLocation = getIntent().getStringExtra("local");


//        textView = findViewById(R.id.textView);
//        textView.setText(getLocation);

//        linearHorizontalFilho2setOrientation(LinearLayout.HORIZONTAL);
//        mapa.setText("mapa");
//        foto.setText("foto");
//
//        TextView textView = new TextView(getApplicationContext());
//        textView.setWidth(550);
//        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
////        tarefaDAO.salvar(timeStamp);
//        textView.setText(timeStamp);
//        linearHorizontalFilho2addView(textView);
//        linearHorizontalFilho2addView(foto);
//        linearHorizontalFilho2addView(mapa);
//        layoutMestre.addView(l);
//        pesquisaNome[0] = (String) textViewNome.getText();
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tarefa tarefa = tarefaDAO.obtemNome(autoComplete.getText().toString());
                layoutMestre.removeAllViews();
                carregaPesquisas(tarefa);
            }
        });

        if (autoComplete.getText().toString().equals("")){
            autoComplete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    autoComplete.showDropDown();
                }
            });
        }

        limparNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMestre.removeAllViews();
                autoComplete.setText("");
                carregaPesquisas(null);
                View v = getCurrentFocus();
                if (v != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        excluirTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setMessage("Deseja realmente excluir todas as pesquisas?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tarefaDAO.deletarTudo();
                        ViewGroup row = layoutMestre;
                        row.removeAllViews();

                        Toast.makeText(getApplicationContext(),
                                "Pesquisas excluídas com sucesso!",
                                Toast.LENGTH_SHORT).show();
//                        escondeTeclado(v);
                    }
                });
                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                });
                //Exibir dialog
                dialog.create();
                dialog.show();
            }
        });



//        layoutMestre.getChildAt(0).setVisibility(layoutMestre.getChildAt(0).INVISIBLE);

//        autoComplete.getOnItemSelectedListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onClick(View view) {
//              tarefas = tarefaDAO.listar();
//                for (Tarefa t: tarefas) {
//                    if (textViewNome.getText().equals("              " + t.getNomeTarefa())) {
//                        ViewGroup row = (ViewGroup) textViewNome.getParent().getParent();
//                        row.setVisibility(row.INVISIBLE);
//                    }
//                }
//            }
//        });

//        tarefas = tarefaDAO.listar();
//        for (Tarefa t: tarefas) {
//            if (textViewNome.getText().equals("              " + t.getNomeTarefa())) {
//                ViewGroup row = (ViewGroup) textViewNome.getParent().getParent();
//                row.setVisibility(row.INVISIBLE);
//            }
//        }

        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearVerticalPai = new LinearLayout(getApplicationContext());
                linearHorizontalFilho1 = new LinearLayout(getApplicationContext());
                linearHorizontalFilho2 = new LinearLayout(getApplicationContext());
                linearVerticalFilho3 = new LinearLayout(getApplicationContext());

                labelNome = new TextView(getApplicationContext());
                horario = new TextView(getApplicationContext());
                dados = new Button(getApplicationContext());
                foto = new Button(getApplicationContext());
                mapa = new Button(getApplicationContext());
                exclui = new Button(getApplicationContext());

                linearVerticalPai.setOrientation(LinearLayout.VERTICAL);
                linearHorizontalFilho1.setOrientation(LinearLayout.VERTICAL);
                linearHorizontalFilho2.setOrientation(LinearLayout.HORIZONTAL);
                linearVerticalFilho3.setOrientation(LinearLayout.VERTICAL);

                labelNome.setText("nome");
                mapa.setText("mapa");
                foto.setText("foto");
                exclui.setText("exclui");
                dados.setText("dados");

                dados.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        String teste = "alves";
                        ViewGroup row = (ViewGroup) view.getParent().getParent();
                        Intent intent = new Intent(MainActivity.this, DadosActivity.class);
                        intent.putExtra("dados", row.getId() );
                        startActivity( intent );
                    }
                });

                foto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        String teste = "alves";
                        ViewGroup row = (ViewGroup) view.getParent().getParent();
                        Intent intent = new Intent(MainActivity.this, FotoActivity.class);
                        intent.putExtra("foto", row.getId() );
                        startActivity( intent );
                    }
                });

//                mapa.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        String teste = "alves";
//                        ViewGroup row = (ViewGroup) view.getParent().getParent();
//                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//                        intent.putExtra("dados", row.getId() );
////                        intent.putExtra("EXTRA_MESSAGE", teste );
//                        startActivity( intent );
//                        finish();
//                    }
//                });

                exclui.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

//                        Log.i("INFO", row.toString());
//                        for(Tarefa t:tarefas) {
//                            TextView textView = (TextView) row.getChildAt(0);
//                            if (t.getHorarioTarefa().equals(textView.getText())) {
//                                Log.i("tarefaAdapter", t.getHorarioTarefa() );
//                                tarefaDAO.deletar(t.getId().intValue());
//                                row.removeAllViewsInLayout();
//                            }
//                        }
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                        dialog.setMessage("Deseja realmente excluir esta pesquisa?");

                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ViewGroup row = (ViewGroup) view.getParent().getParent();
                                tarefaDAO.deletar(row.getId());
                                row.removeAllViews();

                                Toast.makeText(getApplicationContext(),
                                        "Pesquisa excluída com sucesso!",
                                        Toast.LENGTH_SHORT).show();
//                        escondeTeclado(v);
                            }
                        });
                        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            }
                        });
                        //Exibir dialog
                        dialog.create();
                        dialog.show();
                    }
                });


                horario.setWidth(250);
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
                linearHorizontalFilho1.addView(labelNome);
                linearHorizontalFilho2.addView(horario);
                linearHorizontalFilho2.addView(foto, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                linearHorizontalFilho2.addView(exclui, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                linearVerticalFilho3.addView(dados);
//                int v = View.generateViewId();

                tarefaDAO.salvar(timeStamp, null, "", "", "", "", "", "", "", "", "", "",
                        "", "", "", "", "", "", "", "", "", "","","",
                        "", "", "","", "", "", "", "", "");

                tarefas = tarefaDAO.listar();

                linearVerticalPai.setId(tarefas.get(tarefas.size() - 1).getId());

                horario.setText(timeStamp);

                linearVerticalPai.addView(linearHorizontalFilho1);
                linearVerticalPai.addView(linearHorizontalFilho2);
                linearVerticalPai.addView(linearVerticalFilho3);
                layoutMestre.addView(linearVerticalPai);
            }
        });

//        pesquisa.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                for (int x = 0; x < layoutMestre.getChildCount(); x++) {
//                    LinearLayout layoutVerticalPai = (LinearLayout) layoutMestre.getChildAt(x);
//                    LinearLayout layoutHorizontalFilho1 = (LinearLayout) layoutVerticalPai.getChildAt(0);
//                    View v = (TextView) layoutHorizontalFilho1.getChildAt(1);
//                    b = ((TextView) v).getText().toString();
//                    Log.i("INFO", "sucesso! " + b);
//
//                }
//                return false;
//            }
//        });
//        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
//            int tamanhoDaPalavra = 1;
//            boolean excluiPesquisas = false;
//            int views = 0;
//            int totalDeViews = layoutMestre.getChildCount();
//            View v;
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
////            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                int tamanhoDaPalavra = s.toString().length();
//                Log.i("total de views ", ""+ (layoutMestre.getChildCount()));
//                Log.i("excluiPesquisas ", ""+excluiPesquisas);
//                Log.i("tamanhoDaPalavra ", ""+tamanhoDaPalavra);
//                if (filterLongEnough()) {
////                    Log.i("INFO", "attach! " + s);
//                    try{
//                    for (int x = 0; x < (layoutMestre.getChildCount()); x++) {
//                        LinearLayout layoutVerticalPai = (LinearLayout) layoutMestre.getChildAt(x);
//                        LinearLayout layoutHorizontalFilho1 = (LinearLayout) layoutVerticalPai.getChildAt(0);
//                        v = layoutHorizontalFilho1.getChildAt(1);
//                        b = ((TextView) v).getText().toString();
////                        if (excluiPesquisas == true) {
////                            if (b.equals("null")) {
////                                views++;
////                                ViewGroup row = (ViewGroup) v.getParent().getParent();
////                                row.removeAllViews();
////
//////                                finish();
//////                                startActivity(getIntent());
////
//////                                overridePendingTransition(0, 0);
//////                                finish();
//////                                overridePendingTransition(0, 0);
//////                                startActivity(getIntent());
//////                                overridePendingTransition(0, 0);
////                            }
////                        }
//                        Log.i("INFO", "completa " + b);
//                        Log.i("INFO", "parcial " + s);
//
//                            if (!b.substring(0, tamanhoDaPalavra).equals(s.toString().substring(0, tamanhoDaPalavra))) {
//                                Log.i("INFO", "sucesso! ");
////                                excluiPesquisas = true;
////                                ViewGroup row = (ViewGroup) v.getParent().getParent();
////                                row.removeAllViews();
//                                layoutMestre.removeView(layoutMestre.getChildAt(x));
////                                layoutMestre.addView(layoutMestre.getChildAt(x));
////                                layoutMestre.setVisibility(View.INVISIBLE);
//                            }
//
////                            else {
////                                tamanhoDaPalavra = 1;
////                                excluiPesquisas = false;
////                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
////                                startActivity( intent );
//////                                tarefaDAO.listar();
//////                                layoutMestre.saveHierarchyState();
////                            }
//
//                    }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    if (excluiPesquisas == true) {
//                        excluiPesquisas = false;
//                    }
////                    if (tamanhoDaPalavra < b.length()) {
////                        tamanhoDaPalavra++;
////                    }
//                }
//            }
//
//            private boolean filterLongEnough() {
//                return pesquisa.getText().toString().length() > 0;
//            }
//        };
//        pesquisa.addTextChangedListener(fieldValidatorTextWatcher);


//        View.OnKeyListener keyListener = new View.OnKeyListener() {//
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_UP) {
//                    Log.i("INFO", "sucesso! ");
//                }
//                return false;
//            }
//        };

//        scrollView.setScrollY(300);

//        scrollView.post(new Runnable() {
//            @Override
//            public void run() {
//                scrollView.scrollTo(0, layoutMestre.getChildAt(1).getBottom());
//            }
//        });

//        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                int scrollY = scrollView.getScrollY(); // For ScrollView
////                int scrollX = rootScrollView.getScrollX(); // For HorizontalScrollView
//                Toast.makeText(MainActivity.this,""+scrollY, Toast.LENGTH_LONG).show();
//            }
//        });

//        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
//                                    long id) {
//                layoutMestre.getChildAt(0).setVisibility(layoutMestre.getChildAt(0).INVISIBLE);
////                Toast.makeText(MainActivity.this,""+layoutMestre.getChildAt(2).getId(), Toast.LENGTH_LONG).show();
////                int childcount = layoutMestre.getChildCount();
////                for (int i=0; i < childcount; i++){
////                    int v = linearHorizontalFilho1.indexOfChild(linearVerticalPai);
////                    Toast.makeText(MainActivity.this,""+v, Toast.LENGTH_LONG).show();
//////                    Log.i("INFO", "crianca "+v);
////                }
//            }
//        });
    }

    @Override
    protected void onStart() {
        carregaPesquisas(null);
        super.onStart();
    }

    private void carregaPesquisas(Tarefa tarefa) {
        pesquisaNome = new ArrayList();
//        if (a == 0) {
//            a = 1;
        tarefaDAO = new TarefaDAO(getApplicationContext());
//            TarefaDAO tarefaDAO2 = new TarefaDAO(getApplicationContext());

        if (tarefa == null) {
            tarefas = tarefaDAO.listar();
        } else {
            tarefas.add(tarefa);
        }

        tarefasPesquisa = tarefaDAO.listar();
        for (Tarefa t : tarefasPesquisa) {
            if (!t.getNomeTarefa().equals("")) {
                nomeDoPesquisadoHashSet.add(t.getNomeTarefa());
            }
        }

        nomeDoPesquisado = new ArrayList(nomeDoPesquisadoHashSet);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomeDoPesquisado);
        autoComplete.setAdapter(adapter);

        nomeDoPesquisadoHashSet.clear();

        for (Tarefa t : tarefas) {
            linearVerticalPai = new LinearLayout(getApplicationContext());
            linearHorizontalFilho1 = new LinearLayout(getApplicationContext());
            linearHorizontalFilho2 = new LinearLayout(getApplicationContext());
            linearVerticalFilho3 = new LinearLayout(getApplicationContext());

            labelNome = new TextView(getApplicationContext());
            textViewNome = new TextView(getApplicationContext());
//                textViewNome.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            textViewNome.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
//                textViewNome.setSingleLine(false);
//                textViewNome.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
            dados = new Button(getApplicationContext());
            foto = new Button(getApplicationContext());
            mapa = new Button(getApplicationContext());
            exclui = new Button(getApplicationContext());

            linearVerticalPai.setOrientation(LinearLayout.VERTICAL);
            linearHorizontalFilho1.setOrientation(LinearLayout.HORIZONTAL);
            linearHorizontalFilho2.setOrientation(LinearLayout.HORIZONTAL);
            linearVerticalFilho3.setOrientation(LinearLayout.VERTICAL);

//            linearHorizontalFilho2setId(View.generateViewId());
            textViewNome.setText("               "+t.getNomeTarefa());
//                pesquisaNome.add(t.getNomeTarefa());
//                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pesquisaNome);
//                autoComplete = findViewById(R.id.pesquisa);
//                // set adapter for the auto complete fields
//                autoComplete.setAdapter(adapter);
//                // specify the minimum type of characters before drop-down list is shown
//                autoComplete.setThreshold(1);

//                textViewNome.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            labelNome.setText("nome");
            dados.setText("dados");
            mapa.setText("mapa");
            foto.setText("foto");
            exclui.setText("exclui");

            dados.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                        String teste = "alves";
                    ViewGroup row = (ViewGroup) view.getParent().getParent();
                    Intent intent = new Intent(MainActivity.this, DadosActivity.class);
                    intent.putExtra("dados", row.getId() );
                    startActivity( intent );
                }
            });

            foto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //                        String teste = "alves";
                    ViewGroup row = (ViewGroup) view.getParent().getParent();
                    Intent intent = new Intent(MainActivity.this, FotoActivity.class);
                    intent.putExtra("foto", row.getId() );
                    startActivity( intent );
                }
            });

//                mapa.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        ViewGroup row = (ViewGroup) view.getParent().getParent();
//                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//                        intent.putExtra("dados", row.getId() );
//                        startActivity(intent);
//                        finish();
//                    }
//                });

            exclui.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                    dialog.setMessage("Deseja realmente excluir esta pesquisa?");

                    dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ViewGroup row = (ViewGroup) view.getParent().getParent();
                            tarefaDAO.deletar(row.getId());
                            row.removeAllViews();

                            Toast.makeText(getApplicationContext(),
                                    "Pesquisa excluída com sucesso!",
                                    Toast.LENGTH_SHORT).show();
//                        escondeTeclado(v);
                        }
                    });
                    dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    });
                    //Exibir dialog
                    dialog.create();
                    dialog.show();
                }
            });

            horario = new TextView(getApplicationContext());
            //            textView.setId(View.generateViewId());
            horario.setWidth(250);
            horario.setText(t.getHorarioTarefa());
            linearHorizontalFilho1.addView(labelNome);
            linearHorizontalFilho1.addView(textViewNome);
            linearHorizontalFilho2.addView(horario);
            linearHorizontalFilho2.addView(foto, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            linearHorizontalFilho2.addView(exclui, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            linearVerticalFilho3.addView(dados);

            linearVerticalPai.setId(t.getId().intValue());

            linearVerticalPai.addView(linearHorizontalFilho1);
            linearVerticalPai.addView(linearHorizontalFilho2);
            linearVerticalPai.addView(linearVerticalFilho3);
//                linearVerticalPai.setVisibility(linearVerticalPai.INVISIBLE);
            layoutMestre.addView(linearVerticalPai);
        }

//        }

//                if (textViewNome.getText().equals("              " + "josue")) {
//                    Log.i("INFO", "Tarefa salva com sucesso!");
//                }

//        tarefas = tarefaDAO.listar();
//        for (Tarefa t: tarefas) {
//            if (textViewNome.getText().equals("              " + t.getNomeTarefa())) {
//                ViewGroup row = (ViewGroup) textViewNome.getParent().getParent();
//                row.setVisibility(row.INVISIBLE);
//            }
//        }

        tarefas.clear();

//        linearHorizontalFilho2setOrientation(LinearLayout.HORIZONTAL);
//        TextView textView = new TextView(getApplicationContext());
//        textView.setText("josue");
//        linearHorizontalFilho2addView(textView);
//        layoutMestre.addView(l);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}