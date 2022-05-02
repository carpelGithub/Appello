package com.example.appello;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.login) ;


        Button buttonLog = (Button) findViewById(R.id.buttonLog) ; //Bottone Log In
        Button buttonReg = (Button) findViewById(R.id.buttonReg) ; //Registarti

        EditText username = (EditText) findViewById(R.id.username) ; //username
        EditText pass = (EditText) findViewById(R.id.pass) ; //password

        buttonReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent openRegistrazione = new Intent(MainActivity.this, Registrazione.class);
                startActivity(openRegistrazione);
            }

            });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

               login();

            }} );

        }

    public void login() {

        EditText username = (EditText) findViewById(R.id.username); //username
        EditText pass = (EditText) findViewById(R.id.pass); //password

        ReadFromFile rf = new ReadFromFile(getFilesDir().toString(), "config.txt");

        if (rf.isValidLogin(username, pass)) {
            setContentView(R.layout.pag2);
            ((TextView) findViewById(R.id.Docente)).setText(username.getText().toString());
        } else {
            username.setText("");
            pass.setText("");
            ((TextView) findViewById(R.id.passErr)).setText("Credenziali errate!");
        }


                               /* new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        public void run() {
                                            passErr.setText("") ;
                                         }
                                     },
                               4000
                                );*/

    }

}
