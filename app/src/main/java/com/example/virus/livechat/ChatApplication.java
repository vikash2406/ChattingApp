package com.example.virus.livechat;

import android.app.Application;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import model.Message;

public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //ParseObject.registerSubclass(Message.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ybOf5XSbWe41C9EM3RNsfqNX302QLUEqeDTqJUvt")
                .clientKey("ntaQuzSgK24LPO3BdHN3UQS4aBLACcK8zeGDLZUC")
                .server("https://parseapi.back4app.com")
                .build()
        );


    }
}
