package com.example.appello;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Registrazione extends AppCompatActivity {

    EditText nome;
    EditText cognome;
    EditText mail;
    EditText pwd1;
    EditText pwd2;
    Button btn;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);


        btn = (Button) findViewById(R.id.buttonReg);
        nome = (EditText) findViewById(R.id.nome);
        cognome = (EditText) findViewById(R.id.cognome);
        mail = (EditText) findViewById(R.id.email);
        pwd1 = (EditText) findViewById(R.id.pass1);
        pwd2 = (EditText) findViewById(R.id.pass2);
        
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try{


                    if ( pwd1.getText().toString().equals(pwd2.getText().toString())){

                    WriteToFile rf = new WriteToFile(getFilesDir().toString(), "USERDATA.txt");
                    String[] a = {nome.getText().toString(),cognome.getText().toString(),
                            mail.getText().toString(),pwd1.getText().toString()};
                    rf.WriteRegistration(a);
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

    }
}
