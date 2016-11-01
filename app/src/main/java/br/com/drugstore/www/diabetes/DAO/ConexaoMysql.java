package br.com.drugstore.www.diabetes.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wisti on 31/10/2016.
 */
public class ConexaoMysql {

    private SQLiteDatabase db;

    public ConexaoMysql (Context context){
        DB auxDB = new DB(context);
        db = auxDB.getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
