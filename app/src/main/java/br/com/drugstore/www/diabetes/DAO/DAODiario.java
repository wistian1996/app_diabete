package br.com.drugstore.www.diabetes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import br.com.drugstore.www.diabetes.Domain.Diario;

/**
 * Created by Alexandre Andrade on 02/11/2016.
 */
public class DAODiario {

    private SQLiteDatabase db;
    private ConexaoSQLite conexaoSQLite;

    public DAODiario(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    public long inserirDiario(Diario diario){
        // recebe os valores a serem inserido na tabela
        ContentValues values = new ContentValues();
        // recebe o valor de retorno após a inserção (caso =-1, ocorreu um erro)
        long resultado;
        // permite que o banco realize ação de escrita
        db = conexaoSQLite.getWritableDatabase();
        // set dados
        values.put("data",diario.getData().toString());
        values.put("data",diario.getAnotacao());
        values.put("data",diario.getGlicemia());
        // inserção e verificação passando o nome da tabela e seus respectivos valores
        resultado = db.insert("diario",null,values);
        // fechamaneto do banco
        db.close();
        // retorna o valor da verificação
        return resultado;
    }

    public ArrayList<Diario> getTodosDiario() {
        //
        db = conexaoSQLite.getReadableDatabase();
        // lista que salvará todos os resultados
        ArrayList<Diario> list = new ArrayList<>();
        // comando SQL
        String sql = "select * from diario";
        // apontador de dados (permite o acesso aos dados retornados pelo comando SQL)
        Cursor cursor = db.rawQuery(sql,null);
        // loop para coleta de dados e inserção na lista
        while(cursor.moveToNext()){
            Diario diario = new Diario();
            diario.setId(cursor.getInt(0));
            diario.setData(new java.util.Date(cursor.getLong(1)));
            diario.setAnotacao(cursor.getString(2));
            diario.setGlicemia(cursor.getDouble(3));
            list.add(diario);
        }
        // fechamaneto do banco
        db.close();
        // retorno da lista
        return list;
    }

    public ArrayList<Diario> getTodosDiario(Date date) {
        //
        db = conexaoSQLite.getReadableDatabase();
        // lista que salvará todos os resultados
        ArrayList<Diario> list = new ArrayList<>();
        // comando SQL
        String sql = "select * from diario data="+date;
        // apontador de dados (permite o acesso aos dados retornados pelo comando SQL)
        Cursor cursor = db.rawQuery(sql,null);
        // loop para coleta de dados e inserção na lista
        while(cursor.moveToNext()){
            Diario diario = new Diario();
            diario.setId(cursor.getInt(0));
            diario.setData(new java.util.Date(cursor.getLong(1)));
            diario.setAnotacao(cursor.getString(2));
            diario.setGlicemia(cursor.getDouble(3));
            list.add(diario);
        }
        // fechamaneto do banco
        db.close();
        // retorno da lista
        return list;
    }

}
