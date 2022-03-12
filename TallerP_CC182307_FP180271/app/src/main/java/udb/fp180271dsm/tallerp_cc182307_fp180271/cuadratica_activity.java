package udb.fp180271dsm.tallerp_cc182307_fp180271;

import static java.util.stream.Collectors.toMap;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class cuadratica_activity extends AppCompatActivity {

    private TextView txta;
    private TextView txtb;
    private TextView txtc;
    private TextView txtx1;
    private TextView txtx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadratica);
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtHours);
        txtc = findViewById(R.id.txtc);
        txtx1 = findViewById(R.id.txtX1);
        txtx2 = findViewById(R.id.txtX2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calculateResults(View v)
    {
        Double a = Double.parseDouble(String.valueOf(txta.getText()));
        Double b = Double.parseDouble(String.valueOf(txtb.getText()));
        Double c = Double.parseDouble(String.valueOf(txtc.getText()));
        double b2 = (float) Math.pow(b,2);
        double cuatroac = 4*a*c;
        if (b2>cuatroac || b2==cuatroac){
            double b2_4ac = b2 - 4*a*c;
            double raiz = Math.sqrt(b2_4ac);
            double x1 = (-b+raiz)/(2*a);
            double x2 = (-b-raiz)/(2*a);
            txtx1.setText("El valor de x1 es: "+Math.round(x1*100.0)/100.0);
            txtx2.setText("El valor de x2 es: "+Math.round(x2*100.0)/100.0);
        }
        else{
            double b2_4acneg = 4*a*c - b2;
            double raizneg = Math.sqrt(b2_4acneg);
            double real = -b/(2*a);
            double imaginario = raizneg/(2*a);
            txtx1.setText("El valor de x1 es: "+Math.round(real*100.0)/100.0+"+"+Math.round(imaginario*100.0)/100.0+"i");
            txtx2.setText("El valor de x2 es: "+Math.round(real*100.0)/100.0+"-"+Math.round(imaginario*100.0)/100.0+"i");
        }
    }
}