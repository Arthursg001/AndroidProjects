package com.example.appgaseta.database;

import static java.text.Collator.PRIMARY;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDb extends SQLiteOpenHelper {



    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public GasEtaDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INT PRIMARY KEY AUTOINCREMENT," +
                "nomeCombustivel TEXT," +
                "precoCombustivel REAL," +
                "resultado TEXT)";

        db.execSQL(sqlTabelaCombustivel);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //TODO: criar metodos para implementar o CRUD
}
