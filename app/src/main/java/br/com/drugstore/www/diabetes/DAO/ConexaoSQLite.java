package br.com.drugstore.www.diabetes.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexandre Andrade on 02/11/2016.
 */

/**
 * gerencia toda operação com o banco de dados
 * criação, remoção ou atualização das tabelas
 */

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static final int versao = 1;
    private static final String nomeBD = "diabete";
    private static final String tabAlarme = "alarme";
    private static final String tabDiario = "diario";
    private static final String tabHorario = "horario";
    private static final String tabUsuario = "usuario";

    public ConexaoSQLite(Context context) {
        super(context, nomeBD, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // criação das tabelas chamados seus respectivos comandos SQL através de cada método
        sqLiteDatabase.execSQL(criarTabelaAlarme());
        sqLiteDatabase.execSQL(criarTabelaDiario());
        sqLiteDatabase.execSQL(criarTabelaHorario());
        sqLiteDatabase.execSQL(criarTabelaUsuario());
    }

    /**
     * caso a versão seja superior a antiga, este método será chamado para deletar as tabelas já existentes e
     * em seguida criar todas novamente chamando o método onCreate()
     * @param sqLiteDatabase
     * @param versaoAntiga
     * @param versaoNova
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabUsuario);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabHorario);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabDiario);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tabAlarme);

        onCreate(sqLiteDatabase);
    }

    /**
     * criação do comando SQL em String
     * obs: realizado este processo para que o método onCretate(), não fique muito grande com os comandos SQL
     * @return
     */
    public String criarTabelaAlarme(){
        // nomes das colunas com os seus respectivos tipos
        String col1 = "id integer primary key autoincrement,";
        String col2 = "nomeMedicamento text,";
        String col3 = "dosagem real,";
        String col4 = "status boolean,";
        String col5 = "segunda boolean,";
        String col6 = "terca boolean,";
        String col7 = "quarta boolean,";
        String col8 = "quinta boolean,";
        String col9 = "sexta boolean,";
        String col10 = "sabado boolean,";
        String col11 = "domingo boolean";
        // formação do comando com o nome da tabela e suas colunas
        String sql = "create table "+tabAlarme+"("+col1+col2+col3+col4+col5+col6+col7+col8+col9+col10+col11+")";
        // retorno do comando
        return sql;
    }

    /**
     * criação do comando SQL em String
     * obs: realizado este processo para que o método onCretate(), não fique muito grande com os comandos SQL
     * @return
     */
    public String criarTabelaDiario(){
        // nomes das colunas com os seus respectivos tipos
        String col1 = "id integer primary key autoincrement,";
        String col2 = "data datetime,";
        String col3 = "anotacao text,";
        String col4 = "glicemia real";
        // formação do comando com o nome da tabela e suas colunas
        String sql = "create table "+tabDiario+"("+col1+col2+col3+col4+")";
        // retorno do comando
        return sql;
    }

    /**
     * criação do comando SQL em String
     * obs: realizado este processo para que o método onCretate(), não fique muito grande com os comandos SQL
     * @return
     */
    public String criarTabelaHorario(){
        // nomes das colunas com os seus respectivos tipos
        String col1 = "id integer primary key autoincrement,";
        String col2 = "idAlarme boolean,";
        String col3 = "horario datetime,";
        String col4 = "glicemia real";
        // formação do comando com o nome da tabela e suas colunas
        String sql = "create table "+tabHorario+"("+col1+col2+col3+col4+")";
        // retorno do comando
        return sql;
    }

    /**
     * criação do comando SQL em String
     * obs: realizado este processo para que o método onCretate(), não fique muito grande com os comandos SQL
     * @return
     */
    public String criarTabelaUsuario(){
        // nomes das colunas com os seus respectivos tipos
        String col1 = "id integer primary key autoincrement,";
        String col2 = "nome text,";
        String col3 = "idade integer,";
        String col4 = "sexo text,";
        String col5 = "tipoDiabete text";
        // formação do comando com o nome da tabela e suas colunas
        String sql = "create table "+tabUsuario+"("+col1+col2+col3+col4+col5+")";
        // retorno do comando
        return sql;
    }

}
