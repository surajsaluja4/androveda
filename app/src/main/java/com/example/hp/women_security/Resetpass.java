package com.example.hp.women_security;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resetpass extends AppCompatActivity {
Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);
    reset=(Button)findViewById(R.id.reset_final);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Resetpass.this, Loggedin.class);
                startActivity(i);

            }
        });
    }
}
