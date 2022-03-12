package udb.fp180271dsm.tallerp_cc182307_fp180271;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;

public class resultadossalarios_activity extends AppCompatActivity {

    public TextView txtNombre, txtApellido, txtAFP, txtISSS, txtRenta, txtSalarioNeto, txtmayor, txtmenor, txt300;
    public TextView txtNombre2, txtApellido2,  txtAFP2, txtISSS2, txtRenta2, txtSalarioNeto2;
    public TextView txtNombre3, txtApellido3, txtAFP3, txtISSS3, txtRenta3, txtSalarioNeto3;
    private double salario1;
    private double salario2;
    private double salario3;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadossalarios);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtAFP = findViewById(R.id.txtAFP);
        txtISSS = findViewById(R.id.txtISSS);
        txtRenta = findViewById(R.id.txtRenta);
        txtSalarioNeto = findViewById(R.id.txtSalarioNeto);

        txtNombre2 = findViewById(R.id.txtNombre2);
        txtApellido2 = findViewById(R.id.txtApellido2);
        txtAFP2 = findViewById(R.id.txtAFP2);
        txtISSS2 = findViewById(R.id.txtISSS2);
        txtRenta2 = findViewById(R.id.txtRenta2);
        txtSalarioNeto2 = findViewById(R.id.txtSalarioNeto2);

        txtNombre3 = findViewById(R.id.txtNombre3);
        txtApellido3 = findViewById(R.id.txtApellido3);
        txtAFP3 = findViewById(R.id.txtAFP3);
        txtISSS3 = findViewById(R.id.txtISSS3);
        txtRenta3 = findViewById(R.id.txtRenta3);
        txtSalarioNeto3 = findViewById(R.id.txtSalarioNeto3);

        txtmayor = findViewById(R.id.txtmayor);
        txtmenor = findViewById(R.id.txtmenor);
        txt300 = findViewById(R.id.txt300);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("txtName");
        String apellido = bundle.getString("txtApellido");
        String completo = nombre+" "+apellido;
        double horas = bundle.getDouble("txtHours");
        String cargo = bundle.getString("txtJob");
        String nombre2 = bundle.getString("txtName2");
        String apellido2 = bundle.getString("txtApellido2");
        String completo2 = nombre2+" "+apellido2;
        double horas2 = bundle.getDouble("txtHours2");
        String cargo2 = bundle.getString("txtJob2");
        String nombre3 = bundle.getString("txtName3");
        String apellido3 = bundle.getString("txtApellido3");
        String completo3 = nombre3+" "+apellido3;
        double horas3 = bundle.getDouble("txtHours3");
        String cargo3 = bundle.getString("txtJob3");
        txtNombre.setText(""+ completo);
        txtNombre2.setText(""+ completo2);
        txtNombre3.setText(""+ completo3);

        String gerente = cargo.toUpperCase();
        String asistente = cargo2.toUpperCase();
        String secretaria = cargo3.toUpperCase();
        if(gerente.equals("GERENTE") && asistente.equals("ASISTENTE") && secretaria.equals("SECRETARIA")) {
            Gerente(horas);
            Asistente(horas2);
            Secretaria(horas3);
            Toast.makeText(this, "No hay bono", Toast.LENGTH_SHORT).show();
        }
        else {
        switch (cargo) {
            case "Gerente":
            case "gerente":
                if (horas <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                }
                break;
            case "Asistente":
            case "asistente":
                if (horas <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                }
                break;
            case "Secretaria":
            case "secretaria":
                if (horas <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                }
                break;
            default:
                if (horas <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario1 = salarioNeto + bono;
                    txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
                }
                break;
        }
        switch (cargo2) {
            case "Gerente":
            case "gerente":
                if (horas2 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas2;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas2 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                }
                break;
            case "Asistente":
            case "asistente":
                if (horas2 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas2;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas2 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                }
                break;
            case "Secretaria":
            case "secretaria":
                if (horas2 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas2;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas2 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                }
                break;
            default:
                if (horas2 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas2;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas2 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario2 = salarioNeto + bono;
                    txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
                }
                break;
        }
        switch (cargo3) {
            case "Gerente":
            case "gerente":
                if (horas3 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas3;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas3 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.1;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                }
                break;
            case "Asistente":
            case "asistente":
                if (horas3 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas3;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas3 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.05;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                }
                break;
            case "Secretaria":
            case "secretaria":
                if (horas3 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas3;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas3 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.03;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                }
                break;
            default:
                if (horas3 <= 160) {
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * horas3;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                } else {
                    double horasmayor = horas3 - 160;
                    double valorHora = 9.75;
                    double salarioBruto = valorHora * 160 + horasmayor * 11.5;
                    double afp = 0.0688 * salarioBruto;
                    double isss = 0.0525 * salarioBruto;
                    double renta = 0.1 * salarioBruto;
                    double salarioNeto = salarioBruto - afp - isss - renta;
                    double bono = salarioNeto * 0.02;
                    salario3 = salarioNeto + bono;
                    txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
                    txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
                    txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
                    txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
                }
                break;
            }
        }

        if(salario3>salario2 && salario3 > salario1){
            txtmayor.setText(""+ completo3);
        }
        else if(salario2>salario1 && salario2 > salario3){
            txtmayor.setText(""+ completo2);
        }
        else{
            txtmayor.setText(""+ completo);
        }

        if(salario3<salario2 && salario3 < salario1){
            txtmenor.setText(""+ completo3);;
        }
        else if(salario2<salario1 && salario2 < salario3){
            txtmenor.setText(""+ completo2);
        }
        else{
            txtmenor.setText(""+ completo);
        }

        if(salario1>=300 && salario2 >=300 && salario3 >=300){
            txt300.setText("" +completo+", "+completo2+", "+completo3);
        }
        else if(salario1>=300 && salario2 >=300 ){
            txt300.setText("" + completo+", "+completo2);
        }
        else if(salario1>=300 && salario3 >=300){
            txt300.setText("" + completo+", "+completo3);
        }
        else if(salario2 >=300 && salario3 >=300){
            txt300.setText(""+completo2+", "+completo3);
        }
        else if(salario1>=300){
            txt300.setText("" + completo);
        }
        else if(salario2>=300){
            txt300.setText("" + completo2);
        }
        else if(salario3>=300){
            txt300.setText("" + completo3);
        }
        else{
            txt300.setText("Nadie gana más de $300");
        }

    }

    @SuppressLint("SetTextI18n")
    public void Gerente(double horitas){
        if (horitas <= 160) {
            double valorHora = 9.75;
            double salarioBruto = valorHora * horitas;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario1 = salarioBruto - afp - isss - renta;
            txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);

        } else {
            double horasmayor = horitas - 160;
            double valorHora = 9.75;
            double salarioBruto = valorHora * 160 + horasmayor * 11.5;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario1 = salarioBruto - afp - isss - renta;
            txtAFP.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto.setText("$" + Math.round(salario1 * 100.0) / 100.0);
        }
    }

    @SuppressLint("SetTextI18n")
    public void Asistente(double horitas){
        if (horitas <= 160) {
            double valorHora = 9.75;
            double salarioBruto = valorHora * horitas;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario2 = salarioBruto - afp - isss - renta;
            txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
        } else {
            double horasmayor = horitas - 160;
            double valorHora = 9.75;
            double salarioBruto = valorHora * 160 + horasmayor * 11.5;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario2 = salarioBruto - afp - isss - renta;
            txtAFP2.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS2.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta2.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto2.setText("$" + Math.round(salario2 * 100.0) / 100.0);
        }
    }

    @SuppressLint("SetTextI18n")
    public void Secretaria(double horitas){
        if (horitas <= 160) {
            double valorHora = 9.75;
            double salarioBruto = valorHora * horitas;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario3 = salarioBruto - afp - isss - renta;
            txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
        } else {
            double horasmayor = horitas - 160;
            double valorHora = 9.75;
            double salarioBruto = valorHora * 160 + horasmayor * 11.5;
            double afp = 0.0688 * salarioBruto;
            double isss = 0.0525 * salarioBruto;
            double renta = 0.1 * salarioBruto;
            salario3 = salarioBruto - afp - isss - renta;
            txtAFP3.setText("- $" + Math.round(afp * 100.0) / 100.0);
            txtISSS3.setText("- $" + Math.round(isss * 100.0) / 100.0);
            txtRenta3.setText("- $" + Math.round(renta * 100.0) / 100.0);
            txtSalarioNeto3.setText("$" + Math.round(salario3 * 100.0) / 100.0);
        }
    }
    public void FinishA(View v)
    {
        finish();
    }
}