package com.example.quizie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkIt_Knowledge_Q4 extends AppCompatActivity {
    public Button a,b,c,nextQuiz;
    //public Intent mIntent = getIntent();
    //int intValue = mIntent.getIntExtra("intVariableName", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }

        });
        builder.setMessage("Did you Know Lisa Koshy is a Famous Youtuber??")
                .setTitle("Fun Fact!");
        AlertDialog dialog = builder.create();
        setContentView(R.layout.activity_work_it__knowledge__q4);
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
              // intValue++;

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b.setTextColor(Color.GREEN);
                dialog.show();
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
               // intValue++;
            }
        });

        nextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_work_it_Q5();
            }
        });

    }
    public void openActivity_work_it_Q5(){
        Intent intent= new Intent(this, WorkIt_Knowledge_Q5.class);
        //intent.putExtra("intVariableName", intValue);
        startActivity(intent);
        //opens Work_It_Quiz
    }
}