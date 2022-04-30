package com.example.appello;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Scanner;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.login) ;


        Button buttonLog = (Button) findViewById(R.id.buttonLog) ; //Bottone Log In
        Button buttonReg = (Button) findViewById(R.id.buttonReg) ; //Registarti

        EditText username = (EditText) findViewById(R.id.username) ; //username
        EditText pass = (EditText) findViewById(R.id.pass) ; //password
        TextView docente = (TextView) findViewById(R.id.Docente) ;


        buttonReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                setContentView(R.layout.registrazione);

            }
        }) ;


        buttonLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ReadFromFile rf = new ReadFromFile(getFilesDir().toString(), "USERDATA.txt");

                if (rf.isValidLogin(username, pass)) {
                    setContentView(R.layout.pag2);
                    ((TextView)findViewById(R.id.Docente)).setText(username.getText().toString());
                } else {
                    username.setText("");
                    pass.setText("");
                    ((TextView)findViewById(R.id.passErr)).setText("Credenziali errate!");
                }


                               /* new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        public void run() {
                                            passErr.setText("") ;
                                         }
                                     },
                               4000
                                );*/

            }} );

        }

    }
