package br.com.drugstore.www.diabetes.Domain;

import java.util.Date;

/**
 * Created by Alexandre Andrade on 02/11/2016.
 */
public class Diario {

    private int id;
    private Date data;
    private String anotacao;
    private double glicemia;

    public Diario() {
    }

    public Diario(int id, Date data, String anotacao, double glicemia) {
        this.id = id;
        this.data = data;
        this.anotacao = anotacao;
        this.glicemia = glicemia;
    }

    public Diario( Date data, String anotacao, double glicemia) {

        this.data = data;
        this.anotacao = anotacao;
        this.glicemia = glicemia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(double glicemia) {
        this.glicemia = glicemia;
    }

}
