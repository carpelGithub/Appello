package com.example.appello;


import static com.example.appello.Encryption.createSecretKey;
import static com.example.appello.Encryption.encrypt;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

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

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                try{

                    if ( pwd1.getText().toString().equals(pwd2.getText().toString())){

                        WriteToFile rf = new WriteToFile(getFilesDir().toString(), "config.txt");

                        List<String> list=new ArrayList<String>();

                        list.add(nome.getText().toString());
                        list.add(cognome.getText().toString());
                        list.add(mail.getText().toString());
                        list.add(encryPassword(pwd1.getText().toString()));

                        String a  = list.stream().collect(Collectors.joining(","));
                        if (rf.WriteRegistration(a))
                            ((TextView) findViewById(R.id.passErr)).setText("Sei stato registrato!");;
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});

    }

    public String encryPassword(String pwd){
        byte[] salt = new String("24358977373").getBytes();
        int iterationCount = 60000;
        int keyLength = 128;
        try {

            SecretKeySpec key = createSecretKey(pwd.toCharArray(), salt, iterationCount, keyLength);
            return encrypt(pwd, key);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "";


    }
}
