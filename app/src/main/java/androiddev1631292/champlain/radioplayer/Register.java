package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.User;

public class Register extends AppCompatActivity {


    ArrayList<User> users;
    DBSQLiteManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        manager = new DBSQLiteManager(this);
        users = manager.getUser_list();
        manager.getUsers();



        Button RegisterBtn = findViewById(R.id.Register);

        RegisterBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView error = findViewById(R.id.TxtErrorMsg);
                EditText TxtUsername = findViewById(R.id.BoxUsername);
                EditText TxtEmail = findViewById(R.id.BoxEmail);
                EditText TxtPassword = findViewById(R.id.BoxPassword);
                EditText TxtPassword2 = findViewById(R.id.BoxPassword2);

                boolean uniqueTest = false;

                for (User u : users) {
                    if (TxtUsername.getText().toString().equals(u.getUsername())) {
                        uniqueTest = true;
                        break;
                    } else {
                        uniqueTest = false;
                    }

                }

                if (uniqueTest) {
                    error.setText("Username already taken");
                } else {

                    if (TxtPassword.getText().toString().equals(TxtPassword2.getText().toString())) {

                        User c = new User(TxtUsername.getText().toString(), TxtEmail.getText().toString(), TxtPassword.getText().toString());

                        addUser(c);

                        TxtUsername.setText("");
                        TxtEmail.setText("");
                        TxtPassword.setText("");
                        TxtPassword2.setText("");

                        startActivity(new Intent(Register.this, Login.class));
                    } else {
                        error.setText("Password do not match");
                    }
                }
            }
        });
    }

    private void addUser(User c) {

        //Contact createdContact = DBManager.addContact(c);

        DBSQLiteManager dbslm = new DBSQLiteManager(this);
        dbslm.addUser(c);

    }
}
