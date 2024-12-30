package com.bank.izbank.database;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("OnkQRoZQkaM8Tlbss3e3qeKGQKuS5fFCJgj4ea9l\n")
                // if desired
                .clientKey("9W4m4711Fnq9YXQ2yDofBbxVr8PxmVfdP0r84pFa")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
