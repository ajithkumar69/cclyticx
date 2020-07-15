package com.example.cclyticx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent= new Intent(splashscreen.this,Main3Activity.class);
                    startActivity(intent);

                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
