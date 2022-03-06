package udb.fp180271dsm.tallerp_cc182307_fp180271;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText newUser, newPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newUser = findViewById(R.id.txtNewUser);
        newPass = findViewById(R.id.txtNewPass);
    }

    public void openLogin(View v)
    {
        Intent llamar = new Intent(this,login_activity.class);
        startActivity(llamar);
    }

    public void NewAccount(View v){
        try
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdParcial1", null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String userToSave = newUser.getText().toString();
            String passToSave = newPass.getText().toString();
            if(userToSave.length()!=0 && passToSave.length()!=0) //No campos vacíos
            {
                Cursor isUniqueUser = bd.rawQuery("SELECT * FROM Accounts WHERE user = '"+userToSave+"'", null);
                if(!isUniqueUser.moveToFirst()) //Comprobando que no exista ese usuario en la BD
                {
                    ContentValues newRecord = new ContentValues();
                    newRecord.put("user", userToSave);
                    newRecord.put("password", passToSave);
                    bd.insert("Accounts", null, newRecord);
                    bd.close();
                    newUser.setText("");
                    newPass.setText("");
                    Toast.makeText(this, "¡Cuenta registrada con Éxito!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Ese usuario ya existe, intente con uno diferente", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "No se permiten campos vacíos", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}