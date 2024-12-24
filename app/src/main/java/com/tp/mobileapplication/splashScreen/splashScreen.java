package com.tp.mobileapplication.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tp.mobileapplication.Bill.Bill;
import com.tp.mobileapplication.MainScreen.AdminPanelActivity;
import com.tp.mobileapplication.MainScreen.MainScreenActivity;
import com.tp.mobileapplication.R;
import com.tp.mobileapplication.Sign.SignIn;
import com.tp.mobileapplication.UserInfo.Admin;
import com.tp.mobileapplication.UserInfo.BankAccount;
import com.tp.mobileapplication.UserInfo.User;
import com.tp.mobileapplication.UserInfo.UserContext;
import com.tp.mobileapplication.UserInfo.UserTypeState;
import com.felipecsl.gifimageview.library.GifImageView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.tp.mobileapplication.Sign.SignIn.mainUser;

public class splashScreen extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;
    private UserContext userContext;
    private UserTypeState normalUser;
    public static UserTypeState adminUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifImageView = findViewById(R.id.GifImageView);
        progressBar = findViewById(R.id.progress_barr);
        progressBar.setVisibility(progressBar.VISIBLE);
        userContext=new UserContext();
        normalUser=new User();
        adminUser=new Admin();
        //Gif create
        try {
            InputStream inputStream = getAssets().open("deneme2.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex){

        }





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mainUser.getId().equals("9999") &&  mainUser.getName().equals("admin")){
                    userContext.setState(adminUser);
                    userContext.TypeChange(mainUser);
                    Intent intent = new Intent( splashScreen.this, AdminPanelActivity.class);

                    startActivity(intent);
                }else{
                    userContext.setState(mainUser);
                    Intent splashIntent = new Intent( splashScreen.this, MainScreenActivity.class);
                    splashScreen.this.startActivity(splashIntent);
                }

                splashScreen.this.finish();
            }
        },5000);


    }


}