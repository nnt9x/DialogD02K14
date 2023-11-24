package com.example.dialogd02k14;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private LoginDialog loginDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlertDialog(View view) {
        // Tao alert tai day va show len
        alertDialog = new AlertDialog.Builder(this)
                .setTitle("Title dialog")
                .setMessage("Bạn có muốn xoá item này?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Thuc hien
                        Toast.makeText(MainActivity.this, "Xoá thành công!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Thuc hien
                    }
                })
                .create();
        alertDialog.show();

    }

    public void showLoginDialog(View view) {
        // Tao dialog tuy bien
        // Tao giao dien, bat cac sự kiện
        if (loginDialog == null) {
            loginDialog = new LoginDialog(this) {
                @Override
                public void getDataLogin(String username, String password) {
                    loginProcess(username, password);
                }
            };
        }

        // Show dialog
        loginDialog.show();

    }

    public void loginProcess(String username, String password){
        // Thuc hien login
        // Gui Web API....
        if(username.equals("admin") && password.equals("admin")){
            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
        else{
            Toast.makeText(MainActivity.this, "Login fail", Toast.LENGTH_SHORT).show();
        }

    }
}
