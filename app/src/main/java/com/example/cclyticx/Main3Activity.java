package com.example.cclyticx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button REGISTER,LOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        REGISTER=findViewById(R.id.register);
        LOGIN=findViewById(R.id.login);

REGISTER.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);


    }
});
LOGIN.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(intent);

    }
});

    }
}
