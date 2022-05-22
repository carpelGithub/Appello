package com.example.appello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class Appello extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
       // Button buttonAppello = (Button) findViewById(R.id.btnAppello) ; //funzionalita.Appello

        super.onCreate(savedInstanceState);
        setContentView(R.layout.classi);




            System.out.println("ciao sono in appello");



    }
}