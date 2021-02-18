package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkIt_Knowledge_Q1 extends AppCompatActivity {

    public Button a,b,c,nextQuiz;
    //public static int mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //mistakes = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_it__knowledge__q1);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        nextQuiz = findViewById(R.id.complete);
        nextQuiz.setEnabled(false);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Oops! Wrong Answer , Try again", Toast.LENGTH_SHORT).show();
                a.setEnabled(false);
                //mistakes++;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setTextColor(Color.GREEN);
                Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                nextQuiz.setEnabled(true);
                b.setEnabled(false);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Oops! Wrong Answer , Try again", Toast.LENGTH_SHORT).show();
                c.setEnabled(false);
                //mistakes++;
            }
        });

        nextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_work_it_Q2();
            }
        });




    }
    public void openActivity_work_it_Q2(){
        Intent intent= new Intent(this, WorkIt_Knowledge_Q2.class);
        //intent.putExtra("intVariableName", mistakes);
        startActivity(intent);



        //opens Work_It_Quiz
    }
}