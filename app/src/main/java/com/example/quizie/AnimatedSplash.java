package com.example.quizie;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class AnimatedSplash extends AppCompatActivity {

    ImageView ivTop,ivQuizie,ivBottom;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay= 200;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_splash);
        ivTop = findViewById(R.id.iv_top);
        ivBottom = findViewById(R.id.iv_bottom);
        ivQuizie = findViewById(R.id.iv_quizie);
        textView = findViewById(R.id.text_view);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.top_wave);

        ivTop.setAnimation(animation1);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                ivQuizie,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        );

        objectAnimator.setDuration(500);

        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();

        animatText("Quizie");
        //Glide.with(this).load()
            //.asGif();
            //.diskCacheStrategy(DiskCacheStrategy.ALL)

                //.into(ivQuizie);

            Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);
            ivBottom.setAnimation(animation2);

             new Handler().postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     startActivity(new Intent(AnimatedSplash.this,MainActivity.class)
                     .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                     finish();
                 }
             },4000);




    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setText(charSequence.subSequence(0,index++));
            if(index <= charSequence.length() ){
                handler.postDelayed(runnable,delay);
            }
        }
    };
    public void animatText(CharSequence cs){
        charSequence=cs;
        index = 0 ;
        textView.setText("");

        handler.removeCallbacks(runnable);

        handler.postDelayed(runnable,delay);
    }
}