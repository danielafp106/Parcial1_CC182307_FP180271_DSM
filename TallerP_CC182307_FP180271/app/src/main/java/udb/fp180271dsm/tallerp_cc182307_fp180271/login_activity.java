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

public class login_activity extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
    }

    public void openCreateAccount(View v)
    {
        finish();
    }

    public void Login(View v)
    {
        try
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdParcial1", null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String userToCheck = user.getText().toString();
            String passToCheck = pass.getText().toString();
            if(userToCheck.length()!=0 && passToCheck.length()!=0) //No campos vacíos
            {
                Cursor userExist = bd.rawQuery("SELECT * FROM Accounts WHERE user = '"+userToCheck+"'", null);
                if(userExist.moveToFirst()) //Comprobando que no exista ese usuario en la BD
                {
                    bd.close();
                    if(passToCheck.trim().equals(userExist.getString(1).trim())) //comprobando contraseñas
                    {
                        Toast.makeText(this, "¡Bienvenid@ "+userExist.getString(0)+"!", Toast.LENGTH_SHORT).show();
                        Intent llamar = new Intent(this,menu_activity.class);
                        startActivity(llamar);
                        this.finish();
                    }
                    else
                    {
                        Toast.makeText(this, "¡Contraseña Incorrecta!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Ese no usuario no existe, ingrese credenciales válidas o cree una cuenta", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "Ingrese todos sus datos de inicio de sesión", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}