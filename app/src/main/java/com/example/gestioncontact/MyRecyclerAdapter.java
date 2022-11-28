package com.example.gestioncontact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    Context con;
    ArrayList<Contact> data;
    public MyRecyclerAdapter(Context con,ArrayList<Contact> data){
        this.con=con;
        this.data=data;
    }
    @NonNull
    @Override


    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creation d'une vue
        LayoutInflater inf= LayoutInflater.from(con);
        View v=inf.inflate(R.layout.view_contact,null);
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.MyViewHolder holder, int position) {
        //affectation holders
        Contact c=data.get(position);
        holder.tvnom.setText(c.nom);
        holder.tvprenom.setText(c.prenom);
        holder.tvnumero.setText(c.numero);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnom,tvprenom,tvnumero;
        ImageView img_call,img_edit,img_delete;
        //represents holders
        public MyViewHolder(@NonNull View v) {
            super(v);
            //recuperer les holders
             tvnom=v.findViewById(R.id.tv_nom_contact);
             tvprenom=v.findViewById(R.id.tv_prenom_contact);
             tvnumero=v.findViewById(R.id.tv_numero_contact);
             img_call=v.findViewById(R.id.imageView_call_contact);
             img_edit=v.findViewById(R.id.imageView_edit_contact);
             img_delete=v.findViewById(R.id.imageView_delete_contact);
            //events

            img_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice =getAdapterPosition();//indice de l'element selectionné

                    ContactManager manager=new ContactManager(con);
                    manager.ouvrir();
                    manager.supprimer(data.get(getAdapterPosition()).numero);
                    data.remove(indice);
                    notifyDataSetChanged();
                }
            });
            img_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a =new Intent(Intent.ACTION_DIAL);
                    a.setData(Uri.parse("tel:"+data.get(getAdapterPosition()).numero));
                    con.startActivity(a);
                }
            });
            img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a=new Intent(con,Edit_contact.class);
                    a.putExtra("num",data.get(getAdapterPosition()).numero);
                    con.startActivity(a);
                }
            });

        }
    }
}
//zid recherche ,designe base de donees

/*  Context con;
    ArrayList<Contact> data;
    public MyRecyclerAdapter(Context con,ArrayList<Contact> data){
        this.con=con;
        this.data=data;
    }*/