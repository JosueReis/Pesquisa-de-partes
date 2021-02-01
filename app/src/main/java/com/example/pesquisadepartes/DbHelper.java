package com.example.pesquisadepartes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jamiltondamasceno
 */

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 25;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "campos";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " horario TEXT, foto BLOB, caminho1 TEXT, caminho2 TEXT, caminho3 TEXT, caminho4 TEXT, caminho5 TEXT, caminho6 TEXT, caminho7 TEXT, caminho8 TEXT, caminho9 TEXT," +
                " caminho10 TEXT, caminho11 TEXT, caminho12 TEXT, caminho13 TEXT, caminho14 TEXT, caminho15 TEXT, caminho16 TEXT, caminho17 TEXT, caminho18 TEXT, caminho19 TEXT," +
                " caminho20 TEXT, nome TEXT, cpf TEXT, nascimento TEXT, endereco TEXT, enderecoAbordagem TEXT, telefone TEXT, pai TEXT, mae TEXT, numeroTalao TEXT, horaFinal TEXT, observacoes TEXT) ";

        try {
            db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;" ;

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }

    }

//    @Override
//    public void onOpen(SQLiteDatabase db) {
//        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + ";";
//        db.execSQL( sql );
//        super.onOpen(db);
//    }
}
