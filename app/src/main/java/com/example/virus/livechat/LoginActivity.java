package com.example.virus.livechat;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private Button mbtnLoginId ;
    private EditText mUsernameId , mPasswordId;

    ProgressDialog progressDialog;
    String user;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameId = findViewById(R.id.edtUsernameId);
        mPasswordId = findViewById(R.id.edtpasswordId);
        mbtnLoginId = findViewById(R.id.btnLoginId);

        mbtnLoginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAccount();
            }
        });

    }

    private void loginAccount() {

        final String uNameId = mUsernameId.getText().toString();
        final String pwordId = mPasswordId.getText().toString();

        if(uNameId.equals("")||pwordId.equals("")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
            dialog.setTitle("Empty Fields");
            dialog.setMessage("Please complete the form");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        else{
            ParseUser.logInInBackground(uNameId, pwordId, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        startActivity(new Intent(LoginActivity.this, List.class));
                    } else {
                        Toast.makeText(LoginActivity.this , "Failed" , Toast.LENGTH_LONG).show();
                    }

                }
            });

        }
    }
}