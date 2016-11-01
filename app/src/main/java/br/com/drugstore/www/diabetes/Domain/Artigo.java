package br.com.drugstore.www.diabetes.Domain;

/**
 * Created by wisti on 28/10/2016.
 */
public class Artigo {

    private String titulo;
    private String texto;

    public Artigo(String titulo , String texto){
        this.titulo = titulo;
        this.texto = texto;
    }


    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }
}
