package dev.android.mobile.santos.medianotas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Disciplina_DB extends SQLiteOpenHelper {

    private static final String DB_NAME = "disciplina.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public Disciplina_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaNotas = "CREATE TABLE Notas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NomeAluno TEXT, " +
                "Disciplina TEXT, " +
                "Nota1 REAL," +
                "Nota2 REAL," +
                "Nota3 REAL," +
                "Nota4 REAL," +
                "Media REAL, " +
                "Resultado TEXT)";
        db.execSQL(sqlTabelaNotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }
}
