package com.example.practicaenlab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtDescripcion;
    CheckBox chkProg,chkVag,chkCom;
    RadioGroup rgbExcusa;
    Spinner spnSalon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
    }
    private void InicializarControles(){
        txtNombre=(EditText)findViewById(R.id.txtNombreProfesor);
        txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);

        chkProg=(CheckBox)findViewById(R.id.chkProgramando);
        chkCom=(CheckBox)findViewById(R.id.chkComiendo);
        chkVag=(CheckBox)findViewById(R.id.chkVagueando);

        rgbExcusa=(RadioGroup)findViewById(R.id.rbgExcusa);
        spnSalon=(Spinner)findViewById(R.id.spnSalon);
    }
    @SuppressLint("NonConstantResourceId")
    public void EnviarDatos(View v){
        try {
            String nombre = txtNombre.getText().toString();
            String descripcion = txtDescripcion.getText().toString();

            String motivos = ObtenerCheckBox();

            String excusa="";

            if (rgbExcusa.getCheckedRadioButtonId() == R.id.rbtExcusaSi){
                excusa="Sí";
            }
            else if(rgbExcusa.getCheckedRadioButtonId() == R.id.rbtExcusaNO){
                excusa = "No";
            }
            else{
                excusa = "Ni le importa";
            }
            Toast.makeText(this, "Aqui imprime mis datos io =>"+nombre+" "+descripcion+" "+motivos+" "+excusa, Toast.LENGTH_SHORT).show();

            new Mensajito("New Mensajito",
                    "mis datos io => "+nombre+" "+descripcion+" "+motivos+" "+excusa,"OKIS" )
                    .show(getSupportFragmentManager(),"EQUIDE");
        }
        catch(Exception e){
            Toast.makeText(this, "Error io"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String ObtenerCheckBox() {
        String checkbox = "";

        if(chkProg.isChecked())
            checkbox += chkProg.getText().toString()+", ";
        if(chkVag.isChecked())
            checkbox += chkVag.getText().toString()+", ";
        if(chkCom.isChecked())
            checkbox += chkCom.getText().toString();

        return checkbox;
    }

}