package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.User;

public class Login extends AppCompatActivity {

    ArrayList<User> users;

    DBSQLiteManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button RegisterBtn = findViewById(R.id.BtnRegister);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });


        manager = new DBSQLiteManager(this);
        users = manager.getUser_list();
        manager.getUsers();

        Button LoginBtn = findViewById(R.id.BtnLogin);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean IsValid = false;

                TextView error = findViewById(R.id.TxtErrorMsg);
                EditText TxtUsername = findViewById(R.id.BoxUsername);
                EditText TxtPassword = findViewById(R.id.BoxPassword);

                for (User u: users) {

                if(u.getUsername().equals(TxtUsername.getText().toString()) && u.getPassword().equals(TxtPassword.getText().toString())){
                    IsValid = true;
                    break;
                }
                }

                if(IsValid)
                    startActivity(new Intent(Login.this, Home.class));
                else
                    error.setText("Invalid Username/Password");
            }
        });

    }
}
