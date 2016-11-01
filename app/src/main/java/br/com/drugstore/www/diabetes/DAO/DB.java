package br.com.drugstore.www.diabetes.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wisti on 31/10/2016.
 */
public class DB extends SQLiteOpenHelper {
    private static final String NOME_DB = "diabetes";
    private static final int VERSAO_DB = 6;

    public DB(Context ctx) {
        super(ctx, NOME_DB, null, VERSAO_DB);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario (_id integer primary key autoincrement ," +
                "nome text ," +
                "sexo text, " +
                "idade integer) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + "usuario");
        onCreate(db);
    }
}
