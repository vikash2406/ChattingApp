package com.example.virus.livechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnLogin , mbtnCreate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnCreate = findViewById(R.id.btnCreateAccount);
        mbtnLogin = findViewById(R.id.btnLogin);

        mbtnCreate.setOnClickListener(this);
        mbtnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreateAccount:
                startActivity(new Intent(MainActivity.this , CreateAccount.class));
                break;
            case R.id.btnLogin:
                startActivity(new Intent(MainActivity.this , LoginActivity.class));
                break;
        }

    }
}
