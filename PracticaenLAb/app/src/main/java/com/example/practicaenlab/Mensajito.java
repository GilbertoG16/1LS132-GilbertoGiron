package com.example.practicaenlab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Mensajito extends DialogFragment {
    String titulo,mensaje,boton;

    public Mensajito(String t,String m,String b){
        this.titulo=t;
        this.mensaje=m;
        this.boton=boton;
    }

    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Este es un mensaje de prueba")
                .setTitle("Este es un título quemado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {dialog.cancel();}
                });
        return builder.create();
    }

}
