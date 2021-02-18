package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Work_It_Quiz extends AppCompatActivity {
    public Button knowledge_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        knowledge_quiz = findViewById(R.id.knowledge_button);
        knowledge_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_work_it_quiz1();
            }
        });






    }
    public void openActivity_work_it_quiz1(){
        Intent intent= new Intent(this, WorkIt_Knowledge_Q1.class);
        startActivity(intent);
        //opens Work_It_Quiz
    }

}