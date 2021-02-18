package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MoviesActivity extends AppCompatActivity {
    public ImageButton work_it_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        work_it_button = (ImageButton) findViewById(R.id.movie1);

        work_it_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_work_it_quiz();
            }
        });



    }
    public void openActivity_work_it_quiz(){
        Intent intent= new Intent(this, Work_It_Quiz.class);
        startActivity(intent);
        //opens Work_It_Quiz
    }
}