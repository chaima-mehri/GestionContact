package com.example.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db=null;
    Context con;
    ContactManager(Context con){
        this.con=con;

    }
    public void ouvrir(){
        ContactHelper helper=new ContactHelper(con, "mabase.db",null,1);
        db=helper.getWritableDatabase();
    }
    public long ajout(String nom,String prenom, String numero){
        long a=0;

        ContentValues values= new ContentValues();
        values.put(ContactHelper.nom,nom);
        values.put(ContactHelper.prenom,prenom);
        values.put(ContactHelper.numero,numero);
        a =db.insert(ContactHelper.Table_contats,null,values);
        return a;
    }
    public ArrayList<Contact> getAllContatcs(){
        ArrayList<Contact> l=new ArrayList<Contact>();
        Cursor cr=db.query(ContactHelper.Table_contats,
                new String[]{
                        ContactHelper.nom,
                        ContactHelper.prenom,
                        ContactHelper.numero},null,null,null,null,null);
        cr.moveToFirst();
        while(!cr.isAfterLast()) {
            String i1 = cr.getString(0);
            String i2 = cr.getString(1);
            String i3 = cr.getString(2);
            l.add(new Contact(i1, i2, i3));
            cr.moveToNext();
        }
        return l;
    }
    long  supprimer(String num){
        int a=-1;
        a=db.delete(ContactHelper.Table_contats,ContactHelper.numero+'='+num,null);
        return a;
    }
    long modifier(String nom,String prenom, String numero){
        int a =-1;
        ContentValues values= new ContentValues();
        values.put(ContactHelper.nom,nom);
        values.put(ContactHelper.prenom,prenom);

        a=db.update(ContactHelper.Table_contats,values,ContactHelper.numero+"="+numero,null);
        return a;
    }
    public void fermer(){

}
}
