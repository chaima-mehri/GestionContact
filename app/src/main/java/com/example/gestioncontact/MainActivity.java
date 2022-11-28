package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edmp,ednom;
    private Button btn_val;
    private Button btn_qte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edmp=findViewById(R.id.edmp_auth);
        ednom=findViewById(R.id.ednom_auth);

        btn_val=findViewById(R.id.btnval_auth);
        btn_qte=findViewById(R.id.btnqte_auth);





        //ecouteur d'acceuill
        btn_qte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=ednom.getText().toString();
                String email=ednom.getText().toString();
                String mdp=edmp.getText().toString();
                if(nom.equalsIgnoreCase("chaima")&& mdp.equalsIgnoreCase("0000")){
                    Intent i=new Intent(MainActivity.this,Accueil.class);
                    i.putExtra("USER",nom);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "valeur non valide", Toast.LENGTH_SHORT).show();
                    /*Intent a =new Intent(Intent.ACTION_CALL);
                    a.setData((Uri.parse("tel:222"));
                    startActivity(a);*/
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}/* contexte activite courante



*/