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

                    try  {
                        boolean isfound = false;
                        Scanner in = new Scanner(new File(getFilesDir(), "USERDATA.txt"));

                        while (in.hasNextLine()) {
                            String s = in.nextLine();
                            String[] sArray = s.split(",");

                            if (username.getText().toString().equals(sArray[0]) && pass.getText().toString().equals(sArray[1])) {

                                setContentView(R.layout.pag2);
                                TextView docente = (TextView) findViewById(R.id.Docente);
                                docente.setText(username.getText().toString());
                                isfound = true;
                                break;
                            }
                        }
                        if (!isfound) {
                            username.setText("");
                            pass.setText("");
                            TextView passErr = (TextView) findViewById(R.id.passErr);
                            passErr.setText("Credenziali errate!");
                               /* new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        public void run() {
                                            passErr.setText("") ;
                                         }
                                     },
                               4000
                                );*/
                        }
                        in.close();
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }) ;



    }
}