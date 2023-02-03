package com.example.ileite.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ileite.database.DatabaseOperations;
import com.example.ileite.database.SchemaDatabase;
import com.example.ileite.model.Cow;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Vector;

public class CowRepository {

    private Context context;

    public CowRepository(Context context) {
        this.context = context;
    }

    public boolean insertEvent(Cow newCow) {
        try (DatabaseOperations connection = new DatabaseOperations(this.context)) {

            SQLiteDatabase tran = connection.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(SchemaDatabase.Cow.NOME_COLUNA_NAME, newCow.getName());
            values.put(SchemaDatabase.Cow.NOME_COLUNA_ISHEIFER, newCow.getIsHeifer());
            values.put(SchemaDatabase.Cow.NOME_COLUNA_AGE, newCow.getAge());
            values.put(SchemaDatabase.Cow.NOME_COLUNA_AMOUNTMILK, newCow.getAmountMilk());
            values.put(SchemaDatabase.Cow.NOME_COLUNA_WEIGHT, newCow.getWeight());
            values.put(SchemaDatabase.Cow.NOME_COLUNA_DATE, newCow.getRegisterDate().toEpochDay());

            Long idDatabase = tran.insert(SchemaDatabase.Cow.NOME_TABELA, null, values);

            if (idDatabase > 0) {
                newCow.setId(idDatabase);
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public Vector<Cow> searchEvents() {

        Vector<Cow> result = new Vector<>();

        try (DatabaseOperations connection = new DatabaseOperations(this.context)) {
            String sql_Busca = "";


            SQLiteDatabase tran = connection.getReadableDatabase();

            Cursor tuplas = tran.query(SchemaDatabase.Cow.NOME_TABELA,
                    SchemaDatabase.Cow.COLUNAS,
                    sql_Busca,
                    new String[]{}, null,
                    null, null);

            while (tuplas.moveToNext()) {

                Cow entradaBd = new Cow(
                        tuplas.getLong(0),
                        tuplas.getString(1),
                        tuplas.getInt(2),
                        tuplas.getInt(3),
                        tuplas.getDouble(4),
                        tuplas.getDouble(5),
                        Instant.ofEpochMilli(tuplas.getLong(6)).atZone(ZoneId.systemDefault()).toLocalDate()
                );

                result.add(entradaBd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
