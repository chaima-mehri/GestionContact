package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity {

     EditText edName,edlastname,number;
     Button btncancel,btnajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        edName=findViewById(R.id.ednom_ajout);
        edlastname=findViewById(R.id.edlastname_ajout);
        btnajout=findViewById(R.id.btnaj_ajout);
        btncancel=findViewById(R.id.btncan_ajout);
        number=findViewById(R.id.edphone_ajout);


        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edName.setText("");
                edlastname.setText("");
                number.setText("");

            }
        });

        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String lastName=edlastname.getText().toString();
                String phone_number=number.getText().toString();

                ContactManager manager=new ContactManager(Ajout.this);
                manager.ouvrir();
                manager.ajout(name,lastName,phone_number);
                edName.setText(null);
                edlastname.setText(null);
                number.setText(null);
                Toast.makeText(Ajout.this, "a new contact was added", Toast.LENGTH_SHORT).show();



            }
        });


    }
}