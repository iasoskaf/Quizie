package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity {
    public Switch mute_all;
    public Button log_out ;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        log_out = findViewById(R.id.log_out);
        fAuth=FirebaseAuth.getInstance();
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Intent intent=new Intent(SettingsActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        mute_all = (Switch) findViewById(R.id.mute_all_switch);
        mute_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioManager audioManager = (AudioManager)SettingsActivity.this.getSystemService(Context.AUDIO_SERVICE);
                if(mute_all.isChecked()){
                    mute();
                }
                if(mute_all.isChecked()==false){
                    unmute();
                }
            }
        });

    }
    private void mute() {
        //mute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        Toast mute_toast = Toast.makeText(this, "All device sounds have been muted!", Toast.LENGTH_LONG);
        mute_toast.show();
    }

    public void unmute() {
        //unmute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        Toast unmute_toast = Toast.makeText(this, "All device sounds have been unmuted!", Toast.LENGTH_LONG);
        unmute_toast.show();
    }

    }
