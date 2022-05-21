package com.example.appello;

import android.os.Build;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {

    String nameFile;
    String directory;
    Scanner in;

    public ReadFromFile( ){
    }

    public ReadFromFile( String dir, String namef){
        this.nameFile = namef;
        this.directory = dir;
    try{
        in = new Scanner(new File(this.directory, this.nameFile));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public  boolean isValidLogin(EditText username, EditText pass){
        String[] sArray;
        boolean trovato = false;
        try{
            while (in.hasNextLine()) {

                sArray = in.nextLine().split(",");

                System.out.println("pwd sul file: "+sArray[3]);

                String decryptedPassword = Encryption.decrypt(sArray[3]);

                System.out.println(decryptedPassword);
                System.out.println(sArray[2]);

                if (username.getText().toString().equals(sArray[2]) && pass.getText().toString().equals(decryptedPassword)) {
                    trovato = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // credenziali errate
            in.close();
            return trovato;
        }
    }



}
