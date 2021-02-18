package com.example.quizie;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public Button login_button;
    public static Button main_signup_button;
    public ImageButton settings_button;
    public Button play_button;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         login_button = (Button) findViewById(R.id.login_button);
         login_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 openActivity_login();
             }


         });
        main_signup_button = (Button) findViewById(R.id.main_signup_button);
        main_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_signup();
            }
        });

        settings_button = (ImageButton) findViewById(R.id.settings_button);
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_settings();
            }
        });

        play_button = (Button) findViewById(R.id.play_button);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_movies();
            }
        });

    }
     public void openActivity_login(){
        Intent intent= new Intent(this, LoginActivity.class);
                startActivity(intent);
                //opens Login Activity
    }
    public void openActivity_signup(){
        Intent intent= new Intent(this,SignUpActivity.class);
        startActivity(intent);
        //opens sign up Activity
    }
    public void openActivity_settings(){
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
    public void openActivity_movies(){
        Intent intent = new Intent(this,MoviesActivity.class);
        startActivity(intent);
    }

}