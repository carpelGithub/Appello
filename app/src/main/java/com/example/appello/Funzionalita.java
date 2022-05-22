package com.example.appello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Funzionalita extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.funzionalita);

        Button buttonAppello = (Button) findViewById(R.id.btnAppello) ; //funzionalita.Appello

        buttonAppello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent openAppello = new Intent(Funzionalita.this, Appello.class);
                startActivity(openAppello);
            }

        });


    }}