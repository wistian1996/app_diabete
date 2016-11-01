package br.com.drugstore.www.diabetes.Domain;

/**
 * Created by wisti on 31/10/2016.
 */
public class TiposDiabete {
    int id;
    String tipo;

    public TiposDiabete(int id , String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
