package com.example.appello;

import static com.example.appello.Encryption.createSecretKey;
import static com.example.appello.Encryption.decrypt;

import android.widget.EditText;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.crypto.spec.SecretKeySpec;

public class ReadFromFile {

    String nameFile;
    String directory;
    Scanner in;

    public ReadFromFile( String dir, String namef){
        this.nameFile = namef;
        this.directory = dir;
    try{
        in = new Scanner(new File(this.directory, this.nameFile));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }

    public  boolean isValidLogin(EditText username, EditText pass){
        String[] sArray;

        while (in.hasNextLine()) {

            sArray = in.nextLine().split(",");

            if (username.getText().toString().equals(sArray[2]) && pass.getText().toString().equals(decryPassword(sArray[3]))) {
                in.close();
                return true;
        }
        }
        // credenziali errate
        in.close();
        return false;

    }

    public String decryPassword(String pwd){
        byte[] salt = new String("24358977373").getBytes();
        int iterationCount = 60000;
        int keyLength = 128;
        try {

            SecretKeySpec key = createSecretKey(pwd.toCharArray(), salt, iterationCount, keyLength);
            return decrypt(pwd, key);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "";


    }
}
