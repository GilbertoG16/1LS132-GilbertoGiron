package com.example.whatsappplagio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatsAdapter extends ArrayAdapter<Chats> {
    List<Chats> opciones;
    public ChatsAdapter(Context context, List<Chats> datos){
        super(context, R.layout.listview_chats, datos);

        opciones=datos;
    }
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_chats,null);

        ImageView foto = (ImageView)item.findViewById(R.id.imvFoto);
        foto.setImageResource(opciones.get(position).getImagen());

        TextView nombre = (TextView)item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView chat = (TextView)item.findViewById(R.id.txtChat);
        chat.setText(opciones.get(position).getChat());

        TextView hora = (TextView)item.findViewById(R.id.txtHora);
        hora.setText(opciones.get(position).getHora());

        TextView chatcount = (TextView)item.findViewById(R.id.txtChatCount);
        chatcount.setText(opciones.get(position).getChatCount());



        return item;
    }
}
