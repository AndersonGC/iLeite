package com.example.ileite.database;

public class SchemaDatabase {

    public static final String NOME_BANCO_DADOS = "iLeite";

    public static final int VERSAO = 1;

    public static final String SQL_CREATE_TABLES = Cow.SQL_CREATE;

    public static final String SQL_DROP_TABLES = Cow.SQL_DROP;

    public static class Cow {
        public static final String NOME_TABELA = "cow";

        public static final String NOME_COLUNA_ID = "id";
        public static final String NOME_COLUNA_NAME = "name";
        public static final String NOME_COLUNA_ISHEIFER = "isHeifer";
        public static final String NOME_COLUNA_AGE = "age";
        public static final String NOME_COLUNA_AMOUNTMILK = "amount_milk";
        public static final String NOME_COLUNA_WEIGHT = "weight";
        public static final String NOME_COLUNA_DATE = "register_date";

        public static final String COLUNAS[] = {
                NOME_COLUNA_ID,
                NOME_COLUNA_NAME,
                NOME_COLUNA_ISHEIFER,
                NOME_COLUNA_AGE,
                NOME_COLUNA_AMOUNTMILK,
                NOME_COLUNA_WEIGHT,
                NOME_COLUNA_DATE
        };
        public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS " +
                "cow(" +
                NOME_COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NOME_COLUNA_NAME + " TEXT," +
                NOME_COLUNA_ISHEIFER + " INTEGER," +
                NOME_COLUNA_AGE + " INTEGER," +
                NOME_COLUNA_AMOUNTMILK + " INTEGER," +
                NOME_COLUNA_WEIGHT + " INTEGER," +
                NOME_COLUNA_DATE + " INTEGER " +
                ");";

        public static final String SQL_DROP = "DROP IF EXISTS input;";
    }
}
