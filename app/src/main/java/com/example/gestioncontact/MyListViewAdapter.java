package com.example.gestioncontact;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    Context con;
    ArrayList<Contact> data;
    public MyListViewAdapter(Context con, ArrayList<Contact> data){
        this.con=con;
        this.data=data;
    }
    @Override
    public int getCount() {
        // retourne le nombre de vues a créer

        return data.size();
    }

    @Override
    public Contact getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //retourner vues selon getcount
        //creation d'une vue
        LayoutInflater inf= LayoutInflater.from(con);
        View v=inf.inflate(R.layout.view_contact,null);
        //recuperer les holders
        TextView tvnom=v.findViewById(R.id.tv_nom_contact);
        TextView tvprenom=v.findViewById(R.id.tv_prenom_contact);
        TextView tvnumero=v.findViewById(R.id.tv_numero_contact);
        ImageView img_call=v.findViewById(R.id.imageView_call_contact);
        ImageView img_edit=v.findViewById(R.id.imageView_edit_contact);
        ImageView img_delete=v.findViewById(R.id.imageView_delete_contact);
        //affectation holders
        Contact c=data.get(i);
        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnumero.setText(c.numero);

        //events

        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });
        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a =new Intent(Intent.ACTION_CALL);
                a.setData(Uri.parse("tel:222"));
                con.startActivity(a);
            }
        });
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;






    }
}
