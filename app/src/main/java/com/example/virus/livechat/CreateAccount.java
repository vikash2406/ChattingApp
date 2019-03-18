package com.example.virus.livechat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
    private EditText medtEmail , medtUsername , medtPassword;
    private Button mbtnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        medtEmail = findViewById(R.id.edtEmail);
        medtUsername = findViewById(R.id.edtUsername);
        medtPassword = findViewById(R.id.edtPassword);
        mbtnCreateAccount = findViewById(R.id.btnCreatingAccount);

        mbtnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {

        final String uEmail = medtEmail.getText().toString();
        final String uName = medtUsername.getText().toString();
        final String pword = medtPassword.getText().toString();

        if(uEmail.equals("")||uName.equals("")||pword.equals("")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CreateAccount.this);
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

            ParseUser user = new ParseUser();

            user.setUsername(uName);
            user.setEmail(uEmail);
            user.setPassword(pword);

            user.put("city" , "Ranchi");

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        logUserIn(uName , pword);
                        Log.i("Info","user signed up");
                        startActivity(new Intent(CreateAccount.this , List.class));
                    }
                }
            });
        }
    }

    private void logUserIn(String uName, String pword) {

        if(!uName.equals("")||!pword.equals("")){
            ParseUser.logInInBackground(uName, pword, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {

                    if(e == null){
                        Log.v("User Logged In IS:" , parseUser.getUsername());
                    }else{

                    }
                }
            });
        }
    }
}


