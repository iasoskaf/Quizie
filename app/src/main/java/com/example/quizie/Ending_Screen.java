package com.example.quizie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ending_Screen extends AppCompatActivity {
    Button returnButton;
    //String final_mistakes;
   // TextView mistakes_result;
  //  public Intent mIntent = getIntent();
   // int intValue = mIntent.getIntExtra("intVariableName", 0);
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //creating chanel
        NotificationChannel channel = new NotificationChannel("Notification", "Notification",NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        //String final_mistakes = Integer.toString(intValue);
        //mistakes_result = findViewById(R.id.mistakes_result);
       // mistakes_result.setText(final_mistakes);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending__screen);
     returnButton =(Button) findViewById(R.id.return_button);
     returnButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             //notification code
             Intent intent = new Intent(getApplicationContext(),Work_It_Quiz.class);
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

             PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,PendingIntent.FLAG_ONE_SHOT);


             NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"Notification");
             builder.setContentTitle("You Finished Your First Quiz!!");
                 builder.setContentText("Wanna try another Work It Quiz? Tap here");
             builder.setSmallIcon(R.drawable.ic_stat_name);
             builder.setContentIntent(pendingIntent);
             builder.setPriority(NotificationCompat.PRIORITY_HIGH);

             builder.setAutoCancel(true);

             NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Ending_Screen.this);
             managerCompat.notify(1,builder.build());


             openActivity_Movies();

         }
     });


    }
    public void openActivity_Movies(){
        Intent intent= new Intent(this, MoviesActivity.class);
        startActivity(intent);
    }

}
