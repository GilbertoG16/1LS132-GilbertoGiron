package com.example.tarealaboratorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText txtNumeros;
    ProgressBar prgsNumero;
    TextView lblResult;


    TimePicker dpTime;
    DatePicker dpDate;
    boolean isRun = false;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializerControllers();
    }

    private void InitializerControllers(){
        dpTime = (TimePicker)findViewById(R.id.dpTime);
        dpDate = (DatePicker)findViewById(R.id.dpDate);
        txtNumeros = (EditText)findViewById(R.id.txtNumeros);
        prgsNumero = (ProgressBar)findViewById(R.id.prgsNumero);
        lblResult = (TextView)findViewById(R.id.lblResult);
    }
    public void SetearNumero(View v){
       int hora = dpTime.getHour();
       int minuto = dpTime.getMinute();

       int dia = dpDate.getDayOfMonth();
       int mes = dpDate.getMonth()+1;
       int year = dpDate.getYear();
        try {
            double porcentaje = Double.parseDouble(txtNumeros.getText().toString());

            final Timer t = new Timer();
            if(!isRun && porcentaje<=100 && porcentaje>=1){
                TimerTask tt = new TimerTask(){
                    public void run(){
                        counter++;
                        prgsNumero.setProgress(counter);
                        if(counter==porcentaje){
                            t.cancel();
                        }

                    }
                };
                t.schedule(tt,0,100);
            }

            else if(porcentaje>100){
                Toast.makeText(this, "El porcentaje máximo de progressbar es 100%",Toast.LENGTH_SHORT).show();
            }
            else if(porcentaje==0){
                Toast.makeText(this,"El porcentaje mínimo de progressbar es de 1%",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Limpie el resultado y vuelva a setear",Toast.LENGTH_SHORT).show();
            }
            isRun=true;

            //Seteando hora y fecha con el mismo botón

            lblResult.setText("Es el día "+dia
            +" de el mes "+mes
            +" del "+year
            +"\ny su hora "+hora
            +":"+minuto);
        }catch(NumberFormatException e){
            Toast.makeText(this, "Solo puede ingresar números: ",Toast.LENGTH_SHORT).show();
        }
    }

    public void ResetearNumero(View v){
        counter=0;
        prgsNumero.setProgress(0);
        lblResult.setText("");
        isRun=false;
        txtNumeros.setText("");
    }

}