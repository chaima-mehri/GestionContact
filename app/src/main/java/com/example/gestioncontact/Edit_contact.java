package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_contact extends AppCompatActivity {
    EditText edName,edlastname;
    Button btncancel,btnedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Intent x=this.getIntent();
        Bundle b=x.getExtras();
        String numero=b.getString("num");

        edName=findViewById(R.id.ednom_edit_contact);
        edlastname=findViewById(R.id.edlastname_edit_contact);

        btnedit=findViewById(R.id.btned_edit_contact);
        btncancel=findViewById(R.id.btncan_edit_contact);

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edName.setText("");
                edlastname.setText("");

            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String lastName=edlastname.getText().toString();



                ContactManager manager=new ContactManager(Edit_contact.this);
                manager.ouvrir();
                manager.modifier(name,lastName,numero);
                edName.setText(null);
                edlastname.setText(null);

                Toast.makeText(Edit_contact.this, "the contact is modified ", Toast.LENGTH_SHORT).show();
                Intent a=new Intent(Edit_contact.this,Edit.class);
                startActivity(a);
            }
        });

    }
}