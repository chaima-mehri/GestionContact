package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {

    public static ArrayList<Contact> data= new ArrayList<Contact>();
    private Button btnajout,btnaff;
    private TextView tvusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        tvusername=findViewById(R.id.tvuser_acc);
        btnajout=findViewById(R.id.btnajout_acc);
        btnaff=findViewById(R.id.btnaff_acc);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String u=b.getString("USER");
        tvusername.setText("Acceuil de "+u);

       btnajout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(Accueil.this,Ajout.class);
               startActivity(i);
           }
       });
       btnaff.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent a=new Intent(Accueil.this,Edit.class);
               startActivity(a);
           }
       });


    }
}