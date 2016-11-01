package br.com.drugstore.www.diabetes.Domain;

/**
 * Created by wisti on 29/10/2016.
 */
public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String sexo;

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

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }
}
