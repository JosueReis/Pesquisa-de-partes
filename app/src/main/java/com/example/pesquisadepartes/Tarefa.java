package com.example.pesquisadepartes;

import java.io.Serializable;

/**
 * Created by jamiltondamasceno
 */

public class Tarefa implements Serializable {

    private Integer id;
    private String nomeTarefa;
    private String cpfTarefa;
    private String nascimentoTarefa;
    private String enderecoTarefa;
    private String enderecoAbordagemTarefa;
    private String telefoneTarefa;
    private String paiTarefa;
    private String maeTarefa;
    private String idDoLinearLayoutTarefa;
    private String horarioTarefa;
    private byte[] fotoTarefa;
    private String numeroTalaoTarefa;
    private String horaFinalTarefa;
    private String observacoesTarefa;
    private String caminhoTarefa;

//    public int tamanho() {return size();}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdDoLinearLayoutTarefa() {
        return idDoLinearLayoutTarefa;
    }

    public void setIdDoLinearLayoutTarefa(String idDoLinearLayoutTarefa) {
        this.idDoLinearLayoutTarefa = idDoLinearLayoutTarefa;
    }

    public String getHorarioTarefa() {
        return horarioTarefa;
    }

    public void setHorarioTarefa(String horarioTarefa) {
        this.horarioTarefa = horarioTarefa;
    }

    public byte[] getFotoTarefa() {
        return fotoTarefa;
    }

    public void setFotoTarefa(byte[] fotoTarefa) {
        this.fotoTarefa = fotoTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getEnderecoTarefa() {
        return enderecoTarefa;
    }

    public void setEnderecoTarefa(String enderecoTarefa) {
        this.enderecoTarefa = enderecoTarefa;
    }

    public String getTelefoneTarefa() {
        return telefoneTarefa;
    }

    public void setTelefoneTarefa(String telefoneTarefa) {
        this.telefoneTarefa = telefoneTarefa;
    }

    public String getPaiTarefa() {
        return paiTarefa;
    }

    public void setPaiTarefa(String paiTarefa) {
        this.paiTarefa = paiTarefa;
    }

    public String getMaeTarefa() {
        return maeTarefa;
    }

    public void setMaeTarefa(String maeTarefa) {
        this.maeTarefa = maeTarefa;
    }

    public String getCpfTarefa() {
        return cpfTarefa;
    }

    public void setCpfTarefa(String cpfTarefa) {
        this.cpfTarefa = cpfTarefa;
    }

    public String getNascimentoTarefa() {
        return nascimentoTarefa;
    }

    public void setNascimentoTarefa(String nascimentoTarefa) {
        this.nascimentoTarefa = nascimentoTarefa;
    }

    public String getEnderecoAbordagemTarefa() {
        return enderecoAbordagemTarefa;
    }

    public void setEnderecoAbordagemTarefa(String enderecoAbordagemTarefa) {
        this.enderecoAbordagemTarefa = enderecoAbordagemTarefa;
    }

    public String getNumeroTalaoTarefa() {
        return numeroTalaoTarefa;
    }

    public void setNumeroTalaoTarefa(String numeroTalaoTarefa) {
        this.numeroTalaoTarefa = numeroTalaoTarefa;
    }

    public String getHoraFinalTarefa() {
        return horaFinalTarefa;
    }

    public void setHoraFinalTarefa(String horaFinalTarefa) {
        this.horaFinalTarefa = horaFinalTarefa;
    }

    public String getObservacoesTarefa() {
        return observacoesTarefa;
    }

    public void setObservacoesTarefa(String observacoesTarefa) {
        this.observacoesTarefa = observacoesTarefa;
    }

    public String getCaminhoTarefa() {
        return caminhoTarefa;
    }

    public void setCaminhoTarefa(String caminhoTarefa) {
        this.caminhoTarefa = caminhoTarefa;
    }
}
