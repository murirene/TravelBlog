package com.travelblog;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordLayout = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> onLoginClicked());
    }

    private void onLoginClicked() {
        String username = textUsernameLayout.getEditText().getText().toString();
        String password = textPasswordLayout.getEditText().getText().toString();

        if(username.isEmpty()){
            textUsernameLayout.setError("Please provide a login email");
        } else if (password.isEmpty()) {
            textPasswordLayout.setError("Please provide a password");
        }

    }
}
