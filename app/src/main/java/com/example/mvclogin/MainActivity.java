package com.example.mvclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvclogin.Controller.ILoginController;
import com.example.mvclogin.Controller.LoginController;
import com.example.mvclogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edit_email,edit_password;
    Button login;

    ILoginController iLoginController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_email=findViewById(R.id.et_email);
        edit_password=findViewById(R.id.et_password);
        login=findViewById(R.id.btn_login);

        getSupportActionBar().hide();

        iLoginController=new LoginController(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginController.OnLogin(edit_email.getText().toString().trim(),edit_password.getText().toString().trim());

            }
        });

    }

    @Override
    public void OnLoginSuccess(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnLoginFailure(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}