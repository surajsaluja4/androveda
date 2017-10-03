package com.example.hp.women_security;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static int time_out=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent pass=new Intent(MainActivity.this,Signup.class);
                    startActivity(pass);
                    finish();
                }
            },time_out);
//        b1=(Button) findViewById(R.id.bmain);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(MainActivity.this, Signup.class);
//                startActivity(i);
//
//            }
//        });

    }
}
