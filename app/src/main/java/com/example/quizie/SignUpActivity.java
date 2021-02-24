package com.example.quizie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String TAG = "TAG";
    public EditText date_input;
    EditText signup_username,signup_password,email_signup,editTextDate;
    TextView loginbtn;
    Button signup_button ,main_signup_button;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    LinearLayout linear_layout_buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        main_signup_button = findViewById(R.id.main_signup_button);
        signup_username = findViewById(R.id.signup_username);
        signup_password = findViewById(R.id.signup_password);
        email_signup = findViewById(R.id.email_signup);
        editTextDate = findViewById(R.id.editTextDate);
        loginbtn=findViewById((R.id.CreateText));
        signup_button =findViewById(R.id.button_signup);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_signup.getText().toString().trim();
                String password = signup_password.getText().toString().trim();
                String username = signup_username.getText().toString().trim();
                String birthDate = editTextDate.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    email_signup.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    signup_username.setError("Username is required");
                }
                if(TextUtils.isEmpty(password)){
                    signup_password.setError("Password is required");
                    return;
                }
                if(password.length()<6){
                    signup_password.setError("Password must be >= 6 charactters");
                }
             fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         linear_layout_buttons = (LinearLayout) findViewById(R.id.linear_layout_buttons);
                         //MainActivity.main_signup_button.setVisibility(View.INVISIBLE);
                         linear_layout_buttons.setVisibility(View.INVISIBLE);
                         Toast.makeText(SignUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                         userID = fAuth.getCurrentUser().getUid();
                         DocumentReference documentReference =fStore.collection("users").document(userID);
                         Map<String,Object> user =new HashMap<>();
                         user.put("signup_username",username);
                         user.put("signup_password",password);
                         user.put("email_signup",email);
                         user.put("editTextDate",birthDate);
                         documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void aVoid) {
                                 Log.d(TAG, "onSuccess: user Profile is created for"+ userID);
                             }
                         });
                         startActivity(new Intent(getApplicationContext(),MainActivity.class));

                     } else {
                         MainActivity.main_signup_button.setVisibility(View.VISIBLE);
                         Toast.makeText(SignUpActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 }
             });
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


        date_input = (EditText) findViewById(R.id.editTextDate);



        date_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


    }
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month , int dayOfMonth){
        String date = month + "/" + dayOfMonth + "/" + year;
        date_input.setText(date);
    }

}