package udb.fp180271dsm.tallerp_cc182307_fp180271;

import static java.util.stream.Collectors.toMap;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class votaciones_activity extends AppCompatActivity {

    private EditText txtVotos;
    private TextView txtWinner, TXTTOTAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votaciones);
        txtVotos = findViewById(R.id.txtVotes);
        txtWinner = findViewById(R.id.txtX1);
        TXTTOTAL = findViewById(R.id.TXTTOTAL);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calculateResults(View v)
    {
        String votosString = txtVotos.getText().toString();
        String[] votos = votosString.split(",");
        String cadena = "";
        HashSet<String> ids = new HashSet<String>(Arrays.asList(votos));
        System.out.println(ids);
        System.out.println(votos);
        int totalVotes = 0;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String id:ids) {
            int sum = 0;
            for (String vt:votos) {
                if(vt.equals(id))
                {
                   sum++;
                }
            }
            map.put(id,sum);
            totalVotes +=sum;
            System.out.println(map);
        }
        Map<String, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        int pos=1;
        //System.out.println(reverseSortedMap);

        for (Map.Entry<String,Integer> p: sorted.entrySet()) {
            double cal = (new Double(p.getValue())/ new Double(totalVotes))*100;
            cal = Math.round(cal*100.0)/100.0;
            cadena +=  (pos)+"° lugar: Candidato \""+p.getKey()+"\" \nVotos: "+p.getValue()+" | Porcentaje: "+cal+"% \n\n";
            pos++;
        }
        TXTTOTAL.setText("VOTOS TOTALES: "+totalVotes);
        txtWinner.setText(cadena);


    }




}