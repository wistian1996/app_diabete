package br.com.drugstore.www.diabetes.Domain;

/**
 * Created by wisti on 29/10/2016.
 */
public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String tipoDiabete;

    public Usuario() {
    }

    public Usuario(int id, String nome, int idade, String sexo, String tipoDiabete) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.tipoDiabete = tipoDiabete;
    }

    public Usuario(String nome , int idade , String sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Usuario(int id ,String nome , int idade , String sexo){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoDiabete() {
        return tipoDiabete;
    }

    public void setTipoDiabete(String tipoDiabete) {
        this.tipoDiabete = tipoDiabete;
    }

}
