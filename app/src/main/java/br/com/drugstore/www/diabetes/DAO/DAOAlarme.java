package br.com.drugstore.www.diabetes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.drugstore.www.diabetes.Domain.Alarme;

/**
 * Created by alexa on 02/11/2016.
 */
public class DAOAlarme {

    private SQLiteDatabase db;
    private ConexaoSQLite conexaoSQLite;

    public DAOAlarme(Context context) {
        conexaoSQLite = new ConexaoSQLite(context);
    }

    public long inserirAlarme(Alarme alarme){
        // recebe os valores a serem inserido na tabela
        ContentValues values = new ContentValues();
        // recebe o valor de retorno após a inserção (caso =-1, ocorreu um erro)
        long resultado;
        // permite que o banco realize ação de escrita
        db = conexaoSQLite.getWritableDatabase();
        // set dados
        values.put("nomeMedicamento",alarme.getMedicamento());
        values.put("dosagem",alarme.getDosagem());
        values.put("status",alarme.isRepetir());
        values.put("segunda",alarme.isSegunda());
        values.put("terca",alarme.isTerca());
        values.put("quarta",alarme.isQuarta());
        values.put("quinta",alarme.isQuinta());
        values.put("sexta",alarme.isSexta());
        values.put("sabado",alarme.isSabado());
        values.put("domingo",alarme.isDomingo());
        // inserção e verificação passando o nome da tabela e seus respectivos valores
        resultado = db.insert("alarme",null,values);
        // fechamaneto do banco
        db.close();
        // retorna o valor da verificação
        return resultado;
    }

    public ArrayList<Alarme> getTodosAlarmes(){
        //
        db = conexaoSQLite.getWritableDatabase();
        // lista que salvará todos os resultados
        ArrayList<Alarme> list = new ArrayList<>();
        // comando SQL
        String sql = "select * from alarme";
        // apontador de dados (permite o acesso aos dados retornados pelo comando SQL)
        Cursor cursor = db.rawQuery(sql,null);
        // loop para coleta de dados e inserção na lista
        while(cursor.moveToNext()){
            Alarme alarme = new Alarme();
            alarme.setId(cursor.getInt(0));
            alarme.setMedicamento(cursor.getString(1));
            alarme.setDosagem(cursor.getDouble(2));
            // o cursor não trabalha com getBoolean, logo será feita o getInt e realizado uma comparação para se obter o Boolean
            alarme.setRepetir(cursor.getInt(3) == 1);
            alarme.setSegunda(cursor.getInt(4) == 1);
            alarme.setTerca(cursor.getInt(5) == 1);
            alarme.setQuarta(cursor.getInt(6) == 1);
            alarme.setQuinta(cursor.getInt(7) == 1);
            alarme.setSexta(cursor.getInt(8) == 1);
            alarme.setSabado(cursor.getInt(9) == 1);
            alarme.setDomingo(cursor.getInt(10) == 1);
            list.add(alarme);
        }
        // fechamaneto do banco
        db.close();
        // retorno da lista
        return list;
    }

}
