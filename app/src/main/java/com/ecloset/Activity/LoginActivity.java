package com.ecloset.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ecloset.R;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username,et_password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


    }

    //TODO:登录逻辑后面补充
    private boolean CheckLogin(String username, String password){
        return true;
    }

    private void init(){
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if(CheckLogin(username, password)){
                    Intent intent = new Intent("LoginSuccess");
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"用户名和密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}