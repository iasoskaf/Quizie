package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkIt_Knowledge_Q5 extends AppCompatActivity {
    public Button a,b,c,nextQuiz;
   // public Intent mIntent = getIntent();
   // int intValue = mIntent.getIntExtra("intVariableName", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_it__knowledge__q5);
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
                //intValue++;

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Oops! Wrong Answer , Try again", Toast.LENGTH_SHORT).show();
                b.setEnabled(false);
                //intValue++;
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c.setTextColor(Color.GREEN);
                Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                nextQuiz.setEnabled(true);
                c.setEnabled(false);
            }
        });

        nextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openActivity_work_it_Q6();
            }
        });

    }
    public void openActivity_work_it_Q6(){
        Intent intent= new Intent(this, WorkIt_Knowledge_Q6.class);
        //intent.putExtra("intVariableName", intValue);
        startActivity(intent);
        //opens Work_It_Quiz
    }
}