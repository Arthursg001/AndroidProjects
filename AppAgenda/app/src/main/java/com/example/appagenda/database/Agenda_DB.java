package com.example.appagenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Agenda_DB extends SQLiteOpenHelper {
    private static String DB_NAME = "Lista_DB";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public Agenda_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TabelaLista
                = "CREATE TABLE Lista (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT," +
                "conteudo TEXT,"+
                "data TEXT)";


        db.execSQL(TabelaLista);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarDados(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);

    }

    public void limparTabela(String tabela) {
        if (db == null || !db.isOpen()) {
            db = getWritableDatabase();
        }
        db.delete(tabela, null, null);
    }
}