package com.example.ileite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOperations extends SQLiteOpenHelper {

    public DatabaseOperations(Context context) {
        super(context, SchemaDatabase.NOME_BANCO_DADOS, null, SchemaDatabase.VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SchemaDatabase.SQL_CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SchemaDatabase.SQL_DROP_TABLES);
        onCreate(sqLiteDatabase);
    }
}
