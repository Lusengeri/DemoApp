package com.alsoftware.navbottombarcombidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alsoftware.navbottombarcombidemo.login.Model;
import com.alsoftware.navbottombarcombidemo.login.OnLoginListener;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText emailInput = findViewById(R.id.emailInput);
        TextInputEditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);
        Button fbLoginButton = findViewById(R.id.facebookLoginButton);
        Button forgotPwdButton = findViewById(R.id.forgotButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                Model model = Model.getInstance(LoginActivity.this.getApplication());
                model.login(email, password, new OnLoginListener() {
                    @Override
                    public void onLogin(User user) {
                        model.setUser(user);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                });
            }
        });

        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });

        forgotPwdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }
}