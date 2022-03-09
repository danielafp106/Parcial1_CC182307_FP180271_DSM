package udb.fp180271dsm.tallerp_cc182307_fp180271;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openVotaciones(View v)
    {
        Intent llamar = new Intent(this, votaciones_activity.class);
        startActivity(llamar);
    }
}