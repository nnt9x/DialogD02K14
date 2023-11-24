package com.example.dialogd02k14;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public abstract class LoginDialog extends Dialog {

    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnCancel;

    public abstract void getDataLogin(String username, String password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);
        // Bind id
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        // Bat su kien click

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu tu EditText
                String username = edtUsername.getText().toString();
                if(username.isEmpty()){
                    edtUsername.setError("Username cannot empty!");
                    return;
                }
                String password = edtPassword.getText().toString();
                if(password.isEmpty()){
                    edtPassword.setError("Password cannot empty!");
                    return;
                }
                // Da co du lieu -> gui du lieu ve noi co the login ??
                getDataLogin(username, password);

                // An dialog
                resetForm();
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // An dialog
                resetForm();
                dismiss();
            }
        });

    }

    public void resetForm(){
        edtUsername.setText("");
        edtPassword.setText("");
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
    }


}
