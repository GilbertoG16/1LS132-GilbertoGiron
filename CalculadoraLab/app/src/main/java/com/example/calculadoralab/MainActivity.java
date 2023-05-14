package com.example.calculadoralab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> Ops = new ArrayList<String>();
    EditText txtNum1, txtNum2;
    TextView lblResultado;
    Spinner spnOperacion;
    CheckBox chkSumar,chkRestar,chkMultipicar,chkDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        AgregandoValores();
        darClick();
    }
    //Controladores
    private void InicializarControles(){
        txtNum1=(EditText)findViewById(R.id.txtNum1);
        txtNum2=(EditText)findViewById(R.id.txtNum2);

        lblResultado = (TextView)findViewById(R.id.lblRes);

        spnOperacion = (Spinner)findViewById(R.id.spnOperacion);

        chkSumar = (CheckBox)findViewById(R.id.chkSumar);
        chkRestar = (CheckBox)findViewById(R.id.chkRestar);
        chkDividir = (CheckBox)findViewById(R.id.chkDividir);
        chkMultipicar = (CheckBox)findViewById(R.id.chkMultiplicar);
    }
    private void AgregandoValores(){
        Ops.add("Sumar");
        Ops.add("Restar");
        Ops.add("Multiplicación");
        Ops.add("División");
    }
    private void darClick(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOperacion.setAdapter(adapter);
    }
    public void Calcular(View view){

        String eleccion = spnOperacion.getSelectedItem().toString();


        try{
            Double s1 =Double.parseDouble(txtNum1.getText().toString());
            Double s2 =Double.parseDouble(txtNum2.getText().toString());
            new Calculos(s1,s2);

            if(eleccion.equals("Sumar")){
                lblResultado.setText(Double.toString(Calculos.Sumar()));
            }
            if(eleccion.equals("Restar")){
                lblResultado.setText(Double.toString(Calculos.Restar()));
            }
            if(eleccion.equals("Multiplicación")){
                lblResultado.setText(Double.toString(Calculos.Multiplicar()));
            }
            if(eleccion.equals("División")){
                lblResultado.setText(Double.toString(Calculos.Division()));
            }
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }



    }

    public void CheckB(View v){
        String suma = "", resta = "" , multiplicacion = "" , division = "";
        try{
            Double s1 =Double.parseDouble(txtNum1.getText().toString());
            Double s2 =Double.parseDouble(txtNum2.getText().toString());
            new Calculos(s1,s2);

            if(chkSumar.isChecked()==true){
                suma = "La suma es igual a = "+Calculos.Sumar()+"\n";
            }
            if(chkRestar.isChecked()==true){
                resta = "La diferencia es igual a = "+Calculos.Restar()+"\n";
            }
            if(chkMultipicar.isChecked()==true){
                multiplicacion = "El producto es igual a = "+Calculos.Multiplicar()+"\n";
            }
            if(chkDividir.isChecked()==true){
                division = "El cociente es igual a = "+Calculos.Division()+"\n";
            }

            new Mensajito("Operaciones",""+suma+" "+resta+" "+multiplicacion+" "+division, "OKIS").show(getSupportFragmentManager(),"xd");
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }



}