/**
 * Created by wisti on 28/10/2016.
 */
public class Artigo {
    private String titulo;
    private String texto;

    Artigo(String titulo , String texto){
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
