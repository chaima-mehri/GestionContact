package com.example.gestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String Table_contats="Contacts";
    public static final String nom="Nom";
    public static final String prenom="Prenom";
    public static final String numero="Numero";

    //String requete="create table "+Table_contats+ "("+nom+" Text not null,"+prenom+" Text not null,"+numero+" Text not null)";
String s="CREATE TABLE " +Table_contats+ " (" + nom + " Text not null, " + prenom + " Text not null, " +numero + " Text not null "+ ")";
    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    //lors de lancement de la base pour la 1 ere fois
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //modification de la version
        sqLiteDatabase.execSQL("drop table "+Table_contats);
        onCreate(sqLiteDatabase);
    }
}
