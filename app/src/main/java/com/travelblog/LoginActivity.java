package com.travelblog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private AlertDialog.Builder builder;
    private TextInputLayout textUsernameLayout;
    private TextInputLayout textPasswordLayout;
    private ProgressBar loginProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUsernameLayout = findViewById(R.id.textUsernameLayout);
        textPasswordLayout = findViewById(R.id.textPasswordLayout);
        loginButton = findViewById(R.id.loginButton);
        loginProgressBar = findViewById(R.id.login_progress_bar);
        loginButton.setOnClickListener(v -> onLoginClicked());
        Objects.requireNonNull(textUsernameLayout.getEditText()).addTextChangedListener(createTextWatcher(textUsernameLayout));
        Objects.requireNonNull(textPasswordLayout.getEditText()).addTextChangedListener(createTextWatcher(textPasswordLayout));
        builder = new AlertDialog.Builder(this).setMessage(R.string.login_alert_msg).setPositiveButton( "OK", (dialog, which) -> dialog.dismiss());
    }

    private TextWatcher createTextWatcher(TextInputLayout t){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(t.isErrorEnabled()){
                    t.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
    }

    private void showErrorDialog(){
        builder.show();
    }

    private void onLoginClicked() {
        String username = Objects.requireNonNull(textUsernameLayout.getEditText()).getText().toString();
        String password = Objects.requireNonNull(textPasswordLayout.getEditText()).getText().toString();

        if(username.isEmpty()){
            textUsernameLayout.setError("Please provide a login email");
        } else if (password.isEmpty()) {
            textPasswordLayout.setError("Please provide a password");
        } else if (!(username.equals("admin") && password.equals("admin"))){
            showErrorDialog();
        } else {
            performLogin();
        }
    }

    private void performLogin(){
        textUsernameLayout.getEditText().setEnabled(false);
        textPasswordLayout.getEditText().setEnabled(false);
        loginButton.setVisibility(Button.INVISIBLE);
        loginProgressBar.setVisibility(ProgressBar.VISIBLE);
        Handler h = new Handler();
        h.postDelayed(() -> {
            StartMainActivity();
            finish();
        }, 2000);
    }

    private void StartMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
