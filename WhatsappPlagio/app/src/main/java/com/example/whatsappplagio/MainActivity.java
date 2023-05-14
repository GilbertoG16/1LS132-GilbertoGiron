package com.example.whatsappplagio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstChats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChats = (ListView)findViewById(R.id.lstChats) ;
        //Adapter sencillo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                LlenarListViewSimple()
        );
        //Adapter Complejo
        ChatsAdapter adapterComp = new ChatsAdapter(
                getApplicationContext(),
                LlenarListViewCompuesto()
        );
    lstChats.setAdapter(adapterComp);
    }
    //Llenar ListView de forma simple.
    private List<String> LlenarListViewSimple(){
        List<String> chats = new ArrayList<String>();
        chats.add("Cristobal Colón");
        chats.add("Diomedez Diaz");
        chats.add("Cristofer Robin");

        return chats;
    }
    //Llenar List View de forma compleja.
    private List<Chats> LlenarListViewCompuesto(){
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats( R.drawable.ic_launcher_background,"Camaleón","Te mentí, te ignoré","4:40","1"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Sifilis","ok","7:30","2"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Perrito","Se quedó","7:40","7"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Angel","ola","4:40","5"));
        return chats;
    }
}