package udb.fp180271dsm.tallerp_cc182307_fp180271;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class salarios_activity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtApellido;
    private EditText txtHours;
    private EditText txtJob;
    private EditText txtName2;
    private EditText txtApellido2;
    private EditText txtHours2;
    private EditText txtJob2;
    private EditText txtName3;
    private EditText txtApellido3;
    private EditText txtHours3;
    private EditText txtJob3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salarios);

        txtName = findViewById(R.id.txtName);
        txtApellido = findViewById(R.id.txtApellido);
        txtHours = findViewById(R.id.txtHours);
        txtJob = findViewById(R.id.txtJob);
        txtName2 = findViewById(R.id.txtName2);
        txtApellido2 = findViewById(R.id.txtApellido2);
        txtHours2 = findViewById(R.id.txtHours2);
        txtJob2 = findViewById(R.id.txtJob2);
        txtName3 = findViewById(R.id.txtName3);
        txtApellido3 = findViewById(R.id.txtApellido3);
        txtHours3 = findViewById(R.id.txtHours3);
        txtJob3 = findViewById(R.id.txtJob3);
    }

    public void Resultados(View v)
    {
        double horas1 = Double.parseDouble(txtHours.getText().toString());
        double horas2 = Double.parseDouble(txtHours2.getText().toString());
        double horas3 = Double.parseDouble(txtHours3.getText().toString());
        if(horas1<=0 || horas2<=0 || horas3<=0){
            Toast.makeText(this, "Error: No pueden ser horas negativas o iguales a 0", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(this, resultadossalarios_activity.class);
            i.putExtra("txtName", txtName.getText().toString());
            i.putExtra("txtApellido", txtApellido.getText().toString());
            i.putExtra("txtHours", Double.valueOf(txtHours.getText().toString()));
            i.putExtra("txtJob", txtJob.getText().toString());
            i.putExtra("txtName2", txtName2.getText().toString());
            i.putExtra("txtApellido2", txtApellido2.getText().toString());
            i.putExtra("txtHours2", Double.valueOf(txtHours2.getText().toString()));
            i.putExtra("txtJob2", txtJob2.getText().toString());
            i.putExtra("txtName3", txtName3.getText().toString());
            i.putExtra("txtApellido3", txtApellido3.getText().toString());
            i.putExtra("txtHours3", Double.valueOf(txtHours3.getText().toString()));
            i.putExtra("txtJob3", txtJob3.getText().toString());
            startActivity(i);
        }
    }
}