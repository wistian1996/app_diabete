package br.com.drugstore.www.diabetes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.drugstore.www.diabetes.Domain.Usuario;

/**
 * Created by Alexandre Andrade on 02/11/2016.
 */
public class DAOUsuario {

    private SQLiteDatabase db;
    private ConexaoSQLite conexaoSQLite;

    public DAOUsuario(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    public long inserirUsuario(Usuario usuario){
        // recebe os valores a serem inserido na tabela
        ContentValues values = new ContentValues();
        // recebe o valor de retorno após a inserção (caso =-1, ocorreu um erro)
        long resultado;
        // permite que o banco realize ação de escrita
        db = conexaoSQLite.getWritableDatabase();
        // set dados
        values.put("nome",usuario.getNome());
        values.put("idade",usuario.getIdade());
        values.put("sexo",usuario.getSexo());
        values.put("tipoDiabete",usuario.getTipoDiabete());
        // inserção e verificação passando o nome da tabela e seus respectivos valores
        resultado = db.insert("usuario",null,values);
        // fechamaneto do banco
        db.close();
        // retorna o valor da verificação
        return resultado;
    }

    public ArrayList<Usuario> getTodosUsuarios(){
        //
        db = conexaoSQLite.getReadableDatabase();
        // lista que salvará todos os resultados
        ArrayList<Usuario> list = new ArrayList<>();
        // comando SQL
        String sql = "select * from usuario";
        // apontador de dados (permite o acesso aos dados retornados pelo comando SQL)
        Cursor cursor = db.rawQuery(sql,null);
        // loop para coleta de dados e inserção na lista
        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setIdade(cursor.getInt(2));
            usuario.setSexo(cursor.getString(3));
            usuario.setTipoDiabete(cursor.getString(4));
            // inserção do dado na lista
            list.add(usuario);
        }
        // fechamaneto do banco
        db.close();
        // retorno da lista
        return list;
    }

}
