package com.example.pesquisadepartes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

//import java.sql.Blob;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private Tarefa tarefa;
    //    private final List<Tarefa> tarefas = new ArrayList<>();
    private final SQLiteDatabase escreve;
    private final SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }


    public boolean salvar(String horario, byte[] foto, String caminho1, String caminho2, String caminho3, String caminho4, String caminho5, String caminho6, String caminho7, String caminho8, String caminho9,
                          String caminho10, String caminho11, String caminho12, String caminho13, String caminho14, String caminho15, String caminho16, String caminho17, String caminho18, String caminho19, String caminho20,
                          String nome, String cpf, String nascimento, String endereco, String enderecoAbordagem, String telefone, String pai, String mae, String numeroTalao, String horaFinal, String observacoes) {

        ContentValues cv = new ContentValues();
//        cv.put("id", id);
        cv.put("horario", horario);
        cv.put("foto", String.valueOf(foto));
        cv.put("caminho1", String.valueOf(caminho1));
        cv.put("caminho2", String.valueOf(caminho2));
        cv.put("caminho3", String.valueOf(caminho3));
        cv.put("caminho4", String.valueOf(caminho4));
        cv.put("caminho5", String.valueOf(caminho5));
        cv.put("caminho6", String.valueOf(caminho6));
        cv.put("caminho7", String.valueOf(caminho7));
        cv.put("caminho8", String.valueOf(caminho8));
        cv.put("caminho9", String.valueOf(caminho9));
        cv.put("caminho10", String.valueOf(caminho10));
        cv.put("caminho11", String.valueOf(caminho11));
        cv.put("caminho12", String.valueOf(caminho12));
        cv.put("caminho13", String.valueOf(caminho13));
        cv.put("caminho14", String.valueOf(caminho14));
        cv.put("caminho15", String.valueOf(caminho15));
        cv.put("caminho16", String.valueOf(caminho16));
        cv.put("caminho17", String.valueOf(caminho17));
        cv.put("caminho18", String.valueOf(caminho18));
        cv.put("caminho19", String.valueOf(caminho19));
        cv.put("caminho20", String.valueOf(caminho20));
        cv.put("nome", String.valueOf(nome));
        cv.put("cpf", String.valueOf(cpf));
        cv.put("nascimento", String.valueOf(nascimento));
        cv.put("endereco", String.valueOf(endereco));
        cv.put("telefone", String.valueOf(telefone));
        cv.put("pai", String.valueOf(pai));
        cv.put("mae", String.valueOf(mae));
        cv.put("numeroTalao", String.valueOf(numeroTalao));
        cv.put("horaFinal", String.valueOf(horaFinal));
        cv.put("observacoes", String.valueOf(observacoes));
//        cv.put("historico", historico);

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv);
            cv.clear();
            Log.i("INFO", "Tarefa salva com sucesso!");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

//    public boolean atualizar(Integer id, byte[] foto, String nome, String endereco, String telefone, String pai, String mae) {
//
//    ContentValues cv = new ContentValues();
//    cv.put("foto", foto);
//
//        try {
//            String[] args = {id.toString()};
//            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
//            Log.i("INFO", "Tarefa atualizada com sucesso!");
//        }catch (Exception e){
//            Log.e("INFO", "Erro ao atualizar tarefa " + e.getMessage() );
//            return false;
//        }
//
//        return true;
//    }

    public boolean atualizarFoto(Integer id, byte[] foto) {

        ContentValues cv = new ContentValues();
        cv.put("foto", foto);

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto1(Integer id, String caminho) {

//        ContentValues cv = new ContentValues();
//        cv.put("caminho1", String.valueOf(caminho));
//
//        if (atualizarCaminhoFoto(id, caminho, cv) == true) {
//            return true;
//        } else {
//            return false;
//        }
        ContentValues cv = new ContentValues();
        cv.put("caminho1", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto2(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho2", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto3(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho3", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto4(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho4", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto5(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho5", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto6(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho6", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto7(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho7", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto8(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho8", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto9(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho9", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto10(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho10", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto11(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho11", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto12(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho12", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto13(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho13", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto14(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho14", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto15(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho15", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto16(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho16", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto17(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho17", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto18(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho18", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto19(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho19", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarCaminhoFoto20(Integer id, String caminho) {

        ContentValues cv = new ContentValues();
        cv.put("caminho20", String.valueOf(caminho));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Foto2 atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean atualizarDados(Integer id, String nome, String cpf, String nascimento, String endereco, String enderecoAbordagem, String telefone, String pai, String mae, String numeroTalao, String horaFinal, String observacoes) {

        ContentValues cv = new ContentValues();
        cv.put("nome", String.valueOf(nome));
        cv.put("cpf", String.valueOf(cpf));
        cv.put("nascimento", String.valueOf(nascimento));
        cv.put("endereco", String.valueOf(endereco));
        cv.put("enderecoAbordagem", String.valueOf(enderecoAbordagem));
        cv.put("telefone", String.valueOf(telefone));
        cv.put("pai", String.valueOf(pai));
        cv.put("mae", String.valueOf(mae));
        cv.put("numeroTalao", String.valueOf(numeroTalao));
        cv.put("horaFinal", String.valueOf(horaFinal));
        cv.put("observacoes", String.valueOf(observacoes));

        try {
            String[] args = {id.toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
            Log.i("INFO", "Dados atualizados com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao atualizar dados " + e.getMessage() );
            return false;
        }

        return true;
    }

    public boolean deletar(Integer id) {

        try {
            String[] args = { String.valueOf(id) };
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?", args );
            Log.i("INFO", "Tarefa removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

//    public boolean deletarFoto(Integer id, Tarefa tarefa) {
//
//        try {
//            escreve.delete(DbHelper.TABELA_TAREFAS, "id=? and caminho1=?", new String[]{String.valueOf(id), tarefa.getCaminhoTarefa()});
//            escreve.delete(DbHelper.TABELA_TAREFAS, "id=? and caminho2=?", new String[]{String.valueOf(id), tarefa.getCaminhoTarefa()});
//            Log.i("INFO", "Tarefa removida com sucesso!");
//        }catch (Exception e){
//            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
//            return false;
//        }
//
//        return true;
//    }

    public boolean deletarTudo() {

        try {
//            String[] args = { "1" };
            escreve.delete(DbHelper.TABELA_TAREFAS, null, null );
            Log.i("INFO", "Tarefa removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover tarefa " + e.getMessage() );
            return false;
        }

        return true;
    }

    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Tarefa tarefa = new Tarefa();

            Integer id = c.getInt( c.getColumnIndex("id") );
            String nomeTarefa = c.getString( c.getColumnIndex("nome") );
            String horarioTarefa = c.getString( c.getColumnIndex("horario") );

            tarefa.setId( id );
            tarefa.setNomeTarefa( nomeTarefa );
            tarefa.setHorarioTarefa( horarioTarefa );

            tarefas.add( tarefa );
            Log.i("tarefaDao", tarefa.getHorarioTarefa() );
        }

        return tarefas;

    }

    public List<Tarefa> listarFoto(Integer id) {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Tarefa tarefa = new Tarefa();

            byte[] fotoTarefa = c.getBlob( c.getColumnIndex("foto") );

            tarefa.setFotoTarefa( fotoTarefa );

            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefas;
    }

    public Tarefa listarCaminhoFoto1(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho1") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto2(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho2") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto3(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho3") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto4(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho4") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto5(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho5") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto6(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho6") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto7(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho7") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto8(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho8") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto9(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho9") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto10(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho10") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto11(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho11") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto12(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho12") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto13(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho13") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto14(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho14") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto15(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho15") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto16(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho16") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto17(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho17") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto18(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho18") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto19(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho19") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }

    public Tarefa listarCaminhoFoto20(Integer id) {
        Tarefa tarefa = new Tarefa();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);

        while ( c.moveToNext() ){

            String caminhoTarefa = c.getString( c.getColumnIndex("caminho20") );
            tarefa.setCaminhoTarefa( caminhoTarefa );
//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }
        return tarefa;
    }


    public Tarefa listarDados(Integer id) {

//        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " WHERE id = " + id + ";";
        Cursor c = le.rawQuery(sql, null);
        Tarefa tarefa = new Tarefa();

        while ( c.moveToNext() ){

//            byte[] fotoTarefa = c.getBlob( c.getColumnIndex("foto") );
            String nomeTarefa = c.getString( c.getColumnIndex("nome") );
            String cpfTarefa = c.getString( c.getColumnIndex("cpf") );
            String nascimentoTarefa = c.getString( c.getColumnIndex("nascimento") );
            Log.i("INFO", "nome!" + nomeTarefa);
            String enderecoTarefa = c.getString( c.getColumnIndex("endereco") );
            String enderecoAbordagemTarefa = c.getString( c.getColumnIndex("enderecoAbordagem") );
            Log.i("INFO", "endereco!" + enderecoTarefa);
            String telefoneTarefa = c.getString( c.getColumnIndex("telefone") );
            String paiTarefa = c.getString( c.getColumnIndex("pai") );
            String maeTarefa = c.getString( c.getColumnIndex("mae") );
            String numeroTalaoTarefa = c.getString( c.getColumnIndex("numeroTalao") );
            String horaFinalTarefa = c.getString( c.getColumnIndex("horaFinal") );
            String observacoesTarefa = c.getString( c.getColumnIndex("observacoes") );

//            tarefa.setFotoTarefa( fotoTarefa );
//            if (nomeTarefa == null) {
//                nomeTarefa = "";
//            }
//            if (enderecoTarefa == null) {
//                enderecoTarefa = "";
//            }
//            if (telefoneTarefa == null) {
//                telefoneTarefa = "";
//            }
//            if (paiTarefa == null) {
//                paiTarefa = "";
//            }
//            if (maeTarefa == null) {
//                maeTarefa = "";
//            }
            tarefa.setNomeTarefa( nomeTarefa );
            tarefa.setCpfTarefa( cpfTarefa );
            tarefa.setNascimentoTarefa( nascimentoTarefa );
            tarefa.setEnderecoTarefa( enderecoTarefa );
            tarefa.setEnderecoAbordagemTarefa( enderecoAbordagemTarefa );
            tarefa.setTelefoneTarefa( telefoneTarefa );
            tarefa.setPaiTarefa( paiTarefa );
            tarefa.setMaeTarefa( maeTarefa );
            tarefa.setNumeroTalaoTarefa( numeroTalaoTarefa );
            tarefa.setHoraFinalTarefa( horaFinalTarefa );
            tarefa.setObservacoesTarefa( observacoesTarefa );

//            tarefas.add( tarefa );
//            Log.i("tarefaDao", tarefa.getFotoTarefa() );
        }

        return tarefa;
    }

//    public boolean atualizarCaminhoFoto(Integer id, String caminho, ContentValues cv) {
//        try {
//            String[] args = {id.toString()};
//            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id=?", args );
//            Log.i("INFO", "Foto1 atualizada com sucesso!");
//        }catch (Exception e){
//            Log.e("INFO", "Erro ao atualizar Foto " + e.getMessage() );
//            return false;
//        }
//        return true;
//    }
}