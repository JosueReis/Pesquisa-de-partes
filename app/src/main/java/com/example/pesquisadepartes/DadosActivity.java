package com.example.pesquisadepartes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextCpf;
    EditText editTextNascimento;
    EditText editTextEndereco;
    EditText editTextEnderecoAbordagem;
    EditText editTextTelefone;
    EditText editTextPai;
    EditText editTextMae;
    EditText editTextNumeroTalao;
    EditText editTextHoraFinal;
    EditText editTextObservacoes;

    Button obterHoraFinal;
    Button obterEndereco;
    Button endereco;
    Button salvar;
    Button limpar;
    int dadosId;
    String local;
    Tarefa tarefa;
    TarefaDAO tarefaDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        salvar = findViewById(R.id.salvar);
        limpar = findViewById(R.id.limpar);
        obterHoraFinal = findViewById(R.id.obterHoraFinal);
        obterEndereco = findViewById(R.id.obterEndereco);

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextCpf = (EditText) findViewById(R.id.editTextCpf);
        editTextNascimento = (EditText) findViewById(R.id.editTextNascimento);
        editTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        editTextEnderecoAbordagem = (EditText) findViewById(R.id.editTextEnderecoAbordagem);
//        editTextEndereco.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextPai = (EditText) findViewById(R.id.editTextPai);
        editTextMae = (EditText) findViewById(R.id.editTextMae);
        editTextNumeroTalao = (EditText) findViewById(R.id.editTextNumeroTalao);
        editTextHoraFinal = (EditText) findViewById(R.id.editTextHoraFinal);
        editTextObservacoes = (EditText) findViewById(R.id.editTextObservacoes);

        editTextCpf.addTextChangedListener(CpfCnpjMaks.insert(editTextCpf));
        editTextNascimento.addTextChangedListener(Mask.insert("##/##/####", editTextNascimento));
        editTextTelefone.addTextChangedListener(EditTextTelefoneMask.insert(editTextTelefone));

        tarefaDAO = new TarefaDAO(getApplicationContext());

//        Bundle bundle = getIntent().getExtras();
//        int dadosIdMaps = bundle.getInt("dadosIdMaps");
//        String localMaps = bundle.getString("localMaps");
        try {
            dadosId = getIntent().getIntExtra("dados", 0);

//        Log.i("INFO", "sucesso!" + local);
//        editTextEndereco.setText(local);
            Log.i("INFO", "sucesso2!" + dadosId);
            tarefa = tarefaDAO.listarDados(dadosId);
            local = getIntent().getStringExtra("local");

//        tarefa.setEnderecoTarefa(getIntent().getStringExtra("local"));

            if (!tarefa.getNomeTarefa().equals("null")) {
                editTextNome.setText(tarefa.getNomeTarefa());
                editTextCpf.setText(tarefa.getCpfTarefa());
                editTextNascimento.setText(tarefa.getNascimentoTarefa());
                editTextEndereco.setText(tarefa.getEnderecoTarefa());
                editTextEnderecoAbordagem.setText(tarefa.getEnderecoAbordagemTarefa());
                editTextTelefone.setText(tarefa.getTelefoneTarefa());
                editTextPai.setText(tarefa.getPaiTarefa());
                editTextMae.setText(tarefa.getMaeTarefa());
                editTextNumeroTalao.setText(tarefa.getNumeroTalaoTarefa());
                editTextHoraFinal.setText(tarefa.getHoraFinalTarefa());
                editTextObservacoes.setText(tarefa.getObservacoesTarefa());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (local != null) {
            editTextEnderecoAbordagem.setText(local);
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DadosActivity.this);

                dialog.setMessage("Salvar as alterações?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = editTextNome.getText().toString();
                        String cpf = editTextCpf.getText().toString();
                        String nascimento = editTextNascimento.getText().toString();
                        String endereco = editTextEndereco.getText().toString();
                        String enderecoAbordagem = editTextEnderecoAbordagem.getText().toString();
                        String telefone = editTextTelefone.getText().toString();
                        String pai = editTextPai.getText().toString();
                        String mae = editTextMae.getText().toString();
                        String numeroTalao = editTextNumeroTalao.getText().toString();
                        String horaFinal = editTextHoraFinal.getText().toString();
                        String observacoes = editTextObservacoes.getText().toString();

                        tarefaDAO.atualizarDados(dadosId, nome, cpf, nascimento, endereco, enderecoAbordagem, telefone, pai, mae, numeroTalao, horaFinal, observacoes);
                        Intent intent = new Intent(DadosActivity.this, MainActivity.class);
                        startActivity( intent );

                        finishAffinity();

                        Toast.makeText(getApplicationContext(),
                                "Alterações salvas com sucesso!",
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

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNome.setText("");
                editTextCpf.setText("");
                editTextNascimento.setText("");
                editTextEndereco.setText("");
                editTextEnderecoAbordagem.setText("");
                editTextTelefone.setText("");
                editTextPai.setText("");
                editTextMae.setText("");
                editTextNumeroTalao.setText("");
                editTextHoraFinal.setText("");
                editTextObservacoes.setText("");
            }
        });

        obterHoraFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(DadosActivity.this);

                dialog.setMessage("Deseja realmente atualizar a hora final?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
                        editTextHoraFinal.setText(timeStamp);

                        Toast.makeText(getApplicationContext(),
                                "Hora final atualizada com sucesso!",
                                Toast.LENGTH_SHORT).show();
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

        obterEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(DadosActivity.this);

                dialog.setMessage("Deseja realmente atualizar o endereço da abordagem?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(DadosActivity.this, MapsActivity.class);
                        intent.putExtra("dados", dadosId );
                        startActivity( intent );
                        finish();
                        Toast.makeText(getApplicationContext(),
                                "Endereço da abordagem atualizado com sucesso!",
                                Toast.LENGTH_SHORT).show();
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


    }

    protected void onStart() {
        super.onStart();

//        tarefaDAO = new TarefaDAO(getApplicationContext());
//
////        Bundle bundle = getIntent().getExtras();
////        int dadosIdMaps = bundle.getInt("dadosIdMaps");
////        String localMaps = bundle.getString("localMaps");
//        try {
//        dadosId = getIntent().getIntExtra("dados", 0);
//
////        Log.i("INFO", "sucesso!" + local);
////        editTextEndereco.setText(local);
//        Log.i("INFO", "sucesso2!" + dadosId);
//        tarefa = tarefaDAO.listarDados(dadosId);
//        local = getIntent().getStringExtra("local");
//
////        tarefa.setEnderecoTarefa(getIntent().getStringExtra("local"));
//
//            if (!tarefa.getNomeTarefa().equals("null")) {
//                editTextNome.setText(tarefa.getNomeTarefa());
//                editTextCpf.setText(tarefa.getCpfTarefa());
//                editTextNascimento.setText(tarefa.getNascimentoTarefa());
//                editTextEndereco.setText(tarefa.getEnderecoTarefa());
//                editTextEnderecoAbordagem.setText(tarefa.getEnderecoAbordagemTarefa());
//                editTextTelefone.setText(tarefa.getTelefoneTarefa());
//                editTextPai.setText(tarefa.getPaiTarefa());
//                editTextMae.setText(tarefa.getMaeTarefa());
//                editTextNumeroTalao.setText(tarefa.getNumeroTalaoTarefa());
//                editTextHoraFinal.setText(tarefa.getHoraFinalTarefa());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (local != null) {
//            editTextEnderecoAbordagem.setText(local);
//        }
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
////        super.onPause();
//        editTextNome.setText("");
//        editTextCpf.setText("");
//        editTextNascimento.setText("");
////        editTextEndereco.setText("");
//        editTextEnderecoAbordagem.setText("");
//        editTextTelefone.setText("");
//        editTextPai.setText("");
//        editTextMae.setText("");
//        editTextNumeroTalao.setText("");
//        editTextHoraFinal.setText("");
//    }

//    @Override
//    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        editTextEndereco.setText(savedInstanceState.getString("editTextEndereco"));
//        editTextCpf.setText(savedInstanceState.getString("editTextCpf"));
//    }


    //
//    protected void onResume() {
//        super.onResume();
//        editTextCpf.addTextChangedListener(CpfCnpjMaks.insert(editTextCpf));
//        Mask.insert("(##)#####-####", editTextTelefone);
//        editTextTelefone.addTextChangedListener(EditTextTelefoneMask.insert(editTextTelefone));
//    }
}