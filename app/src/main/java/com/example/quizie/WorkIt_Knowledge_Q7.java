package com.example.quizie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WorkIt_Knowledge_Q7 extends AppCompatActivity {
    public Button a,b,c,complete;
    //public Intent mIntent = getIntent();
    //int intValue = mIntent.getIntExtra("intVariableName", 0);
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    private Button close_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_it__knowledge__q7);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        complete = findViewById(R.id.complete);
        complete.setEnabled(false);
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
                complete.setEnabled(true);
                c.setEnabled(false);
            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //createNewContactDialog();
                openActivity_Ending_Screen();
            }
        });

    }
    /*public void createNewContactDialog(){
        dialogbuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up,null);
        close_btn = contactPopupView.findViewById(R.id.close_btn);
        dialogbuilder.setView(contactPopupView);
        dialog= dialogbuilder.create();
        dialog.show();

       close_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });




    }

*/



    public void openActivity_Ending_Screen(){
        Intent intent= new Intent(this, Ending_Screen.class);
        //intent.putExtra("intVariableName", intValue);
        startActivity(intent);
        //opens Work_It_Quiz
    }
}