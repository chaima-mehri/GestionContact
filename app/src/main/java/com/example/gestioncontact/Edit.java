package com.example.gestioncontact;

import static com.example.gestioncontact.Accueil.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {
    RecyclerView rv;
    EditText search;
    private ArrayList<Contact> filtredContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        search=findViewById(R.id.search);
        rv=findViewById(R.id.rv);


        ContactManager manager=new ContactManager(Edit.this);
        manager.ouvrir();
        //manager.ajout("chaima1","mehri1","123");
        data=manager.getAllContatcs();

       //ArrayAdapter ad= new ArrayAdapter(Edit.this, android.R.layout.simple_list_item_1,Accueil.data);
       MyRecyclerAdapter  ad=new MyRecyclerAdapter(Edit.this,data);

       rv.setAdapter(ad);
       search.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
               String searchValue = editable.toString().toUpperCase();

               if(searchValue.length() == 0) {
                   filtredContacts = data;
                   MyListViewAdapter pAdapter = new MyListViewAdapter(Edit.this, filtredContacts);
                   MyRecyclerAdapter rvAdapter = new MyRecyclerAdapter(
                           Edit.this,
                           filtredContacts);
                   rv.setAdapter(rvAdapter);
               }else{
                   filtredContacts = new ArrayList<Contact>();
                   data.forEach((contact)->{
                       if(contact.nom.toUpperCase().contains(searchValue)){
                           filtredContacts.add(contact);
                       }else if(contact.prenom.toUpperCase().contains(searchValue)){
                           filtredContacts.add(contact);
                       }else if(contact.numero.toUpperCase().contains(searchValue)){
                           filtredContacts.add(contact);
                       }
                   });
                   MyRecyclerAdapter rvAdapter = new MyRecyclerAdapter(
                           Edit.this,
                           filtredContacts);
                   MyListViewAdapter pAdapter = new MyListViewAdapter(
                           Edit.this,
                           filtredContacts);
                   rv.setAdapter(rvAdapter);
               }

           }
       });

    }
}/* */