package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ending_Screen extends AppCompatActivity {
    Button returnButton;
    //String final_mistakes;
   // TextView mistakes_result;
  //  public Intent mIntent = getIntent();
   // int intValue = mIntent.getIntExtra("intVariableName", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String final_mistakes = Integer.toString(intValue);
        //mistakes_result = findViewById(R.id.mistakes_result);
       // mistakes_result.setText(final_mistakes);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending__screen);
     returnButton = findViewById(R.id.return_button);
     returnButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             openActivity_Movies();
         }
     });

    }
    public void openActivity_Movies(){
        Intent intent= new Intent(this, MoviesActivity.class);
        startActivity(intent);
    }
}
